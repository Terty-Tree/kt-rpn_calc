import java.util.*
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 1)
        exit(1, "Usage: ./rpn_calc expression")

    val items: List<String> = args[0].replace("\\s{2,}".toRegex(), " ").split(" ")
    val numbers: LinkedList<Int> = LinkedList()
    for (item in items) {
        // Try to parse the current item into a number, if it's not a number an exception will be thrown
        try {
            numbers.add(Integer.parseInt(item))
        } catch (e: NumberFormatException) {
            // Exception was thrown so we know it's either an operator or an illegal character
            val op: Operator = getOperator(item) ?: exit(2, "Error!")
            val num1: Int = numbers.poll() ?: exit(3, "Error!")
            val num2: Int = numbers.poll() ?: exit(3, "Error!")
            numbers.push(op.operation(num1, num2))
        }
    }
    if (numbers.size != 1)
        exit(4, "Error!")
    println(numbers.poll())
}

/**
 * Prints the specified message with a newline and exits the program with the
 * specified exit code. If the exit code is 0 the message will be printed to
 * stdout otherwise it will be printed to stderr.
 *
 * @param code program exit code.
 * @param message message to print on exit.
 */
fun exit(code: Int, message: String): Nothing {
    if (code == 0)
        println(message)
    else
        System.err.println(message)
    exitProcess(code)
}