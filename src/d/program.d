import core.exception : RangeError;
import std.array : replicate;
import std.conv : parse, ConvException;
import std.format : format;
import std.functional : binaryFun;
import std.range.primitives : back, popBack;
import std.stdio : writeln;
import std.string : strip;

alias opFun = int function(int, int);

auto getOperations()
{
	opFun[char] operations;
	operations['+'] = (a, b) => a + b;
	operations['-'] = (a, b) => a - b;
	operations['*'] = (a, b) => a * b;
	operations['/'] = (a, b) => a / b;
	return operations;
}

int main(string[] args)
{
	// Argument checks
	if (args.length != 2)
	{
		writeln("Usage: ./rpn-calc <expression>");
		return 1;
	}

	// Set-up
	auto operations = getOperations();
	auto expression = args[1];
	int[] numbers;

	while (expression.length > 0)
	{
		// Trim whitespace
		expression = strip(expression);

		// Print current values
		writeln(format("numbers ....: [ %(%d%|, %) ]", numbers));
		writeln(       "expression .: " ~ expression);
		writeln();

		// Try getting a number
		try
		{
			numbers ~= parse!int(expression);
			continue;
		}
		catch (ConvException ce)
		{
		}

		// Try getting an operator
		try
		{
			int function(int, int) operation = operations[expression[0]];
			expression = expression[1 .. expression.length];
			auto secondOperand = numbers.back();
			numbers.popBack();
			auto firstOperand = numbers.back();
			numbers.popBack();
			numbers ~= operation(firstOperand, secondOperand);
			continue;
		}
		catch (RangeError re)
		{
		}

		// Was neither a number nor an operator
		writeln(format("Unrecognized character: %c", expression[0]));
		return 2;
	}

	auto resultString = format("===== Final result: %d =====", numbers.back());
	auto paddingString = replicate(['='], resultString.length);
	writeln(paddingString);
	writeln(resultString);
	writeln(paddingString);
	return 0;
}