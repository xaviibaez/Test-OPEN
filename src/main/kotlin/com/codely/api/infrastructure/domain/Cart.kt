data class Cart(
    val id: Int,
    val products: List<ProductAvailability>,
    val total:Int,
    val discountedTotal:Int,
    val userId:Int,
    val totalProducts:Int,
    val totalQuantity:Int,
)
