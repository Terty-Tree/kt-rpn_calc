fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Usage: ./rpn_calc expression")
    } else {
        var items: List<String> = args[0].split(" ")
    }
}

enum class Operator(val identifier: String, val operation: (Int, Int) -> Int) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b}),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", ::div),
    MOD("%", ::mod);

    fun equals(str: String) = str.equals(this.identifier)
}

fun div(a: Int, b: Int): Int {
    if (b == 0)
        error("Cannot divide by zero.\n")
    return (a / b)
}

fun mod(a: Int, b: Int): Int {
    if (b == 0)
        error("Cannot mod by zero.\n")
    return (a % b)
}

fun getOperator(str: String): Operator? {
    for (op in Operator.values()) {
        if (op.equals(str))
            return (op)
    }
    return (null)
}