enum class Operator(val identifier: String, val operation: (Int, Int) -> Int) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b}),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> if (b != 0) a / b else exit(5, "Error!") }),
    MOD("%", { a, b -> if (b != 0) a % b else exit(5, "Error!") });

    fun equals(str: String) = str.equals(this.identifier)
}

fun getOperator(str: String): Operator? {
    return Operator.values()
            .firstOrNull { it.equals(str) }
            ?.let { (it) }
}