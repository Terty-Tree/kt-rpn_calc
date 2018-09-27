enum class Operator(private val identifier: String, private val operation: (Int, Int) -> Int) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> if (b != 0) a / b else exit(5, "Error!") }),
    MOD("%", { a, b -> if (b != 0) a % b else exit(5, "Error!") });

    fun equals(str: String) = str == this.identifier

    operator fun invoke(a: Int, b: Int) = operation(a, b)
}

fun getOperator(str: String): Operator? {
    return Operator.values()
            .firstOrNull { it.equals(str) }
            ?.let { (it) }
}
