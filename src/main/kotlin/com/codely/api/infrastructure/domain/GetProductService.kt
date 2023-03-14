data class GetProductService(
    val maxPriceProduct: Product?,
    val minPriceProduct: Product?,
    val averagePrice: Double,
    val productsByBrand: Map<String, List<Product>>,
    val productsByCategory: Map<String, List<Product>>,
)
