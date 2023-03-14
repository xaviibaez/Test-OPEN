data class GetProductServiceUser(
    val productsByIdTitle: Map<Pair<Int, String>, Pair<Pair<Int, Int>, Double>>,
    val totalQuantity: Int,
    val totalPrice: Int,
    val totalDiscountPercentage: Double,
    val averageDiscount: Double
)
