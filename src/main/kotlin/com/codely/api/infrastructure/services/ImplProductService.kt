package com.codely.api.infrastructure.services

import Product
import GetProductService
import GetProductServiceUser
import ProductAvailability
import RawDataProduct
import RawDataProductUser
import com.codely.api.infrastructure.helper.ImplProductHelper
import org.springframework.stereotype.Service
import com.google.gson.Gson

@Service
class ImplProductService(private val productHelper: ImplProductHelper) {

    val gson = Gson()
    /*
    Todos los tests seran sobre esta capa de servicio.
    Tantos por cada throw KOs y OKs
     */
    fun getAllProducts(): GetProductService {
        val rawData =
            gson.fromJson(productHelper.getAllProducts(), RawDataProduct::class.java) ?: throw Exception("Raw data empty")

        val products = arrayListOf<Product>()
        if (!rawData.data.isNullOrEmpty()) {
            for (processedData in rawData.data) {
                if (processedData != null) {
                    for (product in processedData.products) {
                        if (product != null) {
                            products.add(product)
                        }
                    }
                }
            }
        }

        val maxPriceProduct = products.maxByOrNull { it.price }
        println("Producto con el precio más alto: $maxPriceProduct")

        val minPriceProduct = products.minByOrNull { it.price }
        println("Producto con el precio más bajo: $minPriceProduct")

        val averagePrice = products.map { it.price }.average()
        println("Precio medio de los productos: $averagePrice")

        val productsByBrand = products.groupBy { it.brand }
        for ((brand, products) in productsByBrand) {
            println("Número de productos de la marca $brand: ${products.size}")
        }

        val productsByCategory = products.groupBy { it.category }
        for ((category, products) in productsByCategory) {
            println("Número de productos de la categoría $category: ${products.size}")
        }

        return GetProductService(
            maxPriceProduct, minPriceProduct, averagePrice, productsByBrand,
            productsByCategory
        )
    }
    fun getProductsByUser(ids: List<Long>): GetProductServiceUser {
        if (ids.isNullOrEmpty())
            throw Exception("ids not provided")

        val rawData =
            gson.fromJson(productHelper.getProductsByUser(ids), RawDataProductUser::class.java) ?: throw Exception("Raw data empty")

        val products = arrayListOf<ProductAvailability>()

        if (!rawData.data.isNullOrEmpty()) {
            for (processedData in rawData.data) {
                if (processedData != null) {
                    for (cart in processedData.carts) {
                        if (cart != null) {
                            for (product in cart.products) {
                                products.add(product)
                            }
                        }
                    }
                }
            }
        }

        //val productsGrouped = products.groupBy { it.id; it.title }

        var totalQuantity = 0
        var totalPrice = 0
        var totalDiscountPercentage = 0.0
        var averageDiscount = 0.0

        val productsByIdTitle = products
            //.flatMap { it.products }
            .groupBy { it.id to it.title }
            .mapValues { (_, products) ->
                for (product in products) {
                    totalQuantity += product.quantity
                    totalPrice += product.total
                    totalDiscountPercentage += product.discountPercentage
                }
                averageDiscount = if (products.isNotEmpty()) totalDiscountPercentage / products.size else 0.0
                Pair(totalQuantity, totalPrice) to averageDiscount
            }

        return GetProductServiceUser(productsByIdTitle, totalQuantity, totalPrice, totalDiscountPercentage, averageDiscount)
    }
}
