# Reverse Polish Notation Calculator
Simple calculator program that evaluates a trivial expression written in [reverse Polish notation](https://en.wikipedia.org/wiki/Reverse_Polish_notation), also known as postfix notation.

Note: the ambiguity of the error messages is due to the subject that was provided. The program's output has to match the specifications exactly for it to pass the automated tests. The exit codes are the best way to determine where the error lies.

# Usage
`java -jar bin/rpn_calc.jar EXPRESSION`

# Examples
`java -jar bin/rpn_calc.jar "1 1 +"`
>`2`

`java -jar bin/rpn_calc.jar "1 1 -"`
>`0`

`java.exe -jar bin/rpn_calc.jar "5 5 * 5 + 3 / 1 - 5 %"`
>`4`

`java.exe -jar bin/rpn_calc.jar "5 5 5 * + 3 / 1 - 5 %"`
>`4`
