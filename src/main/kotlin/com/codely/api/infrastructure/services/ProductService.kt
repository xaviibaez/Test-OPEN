package com.codely.api.infrastructure.services

import ProductList
import ProductReturn
import com.codely.api.infrastructure.helper.ProductHelper
import org.springframework.stereotype.Service
import com.google.gson.Gson
import rawData


@Service
class ProductService(private val productHelper: ProductHelper) {

    fun getAllProducts(): ProductReturn {
        val gson = Gson()
        val test = productHelper.getAllProducts()
        val rawData = gson.fromJson(test, rawData::class.java)

        val productList = gson.fromJson(test, ProductList::class.java)

        val maxPriceProduct = productList.products.maxByOrNull { it.price }
        println("Producto con el precio más alto: $maxPriceProduct")

        val minPriceProduct = productList.products.minByOrNull { it.price }
        println("Producto con el precio más bajo: $minPriceProduct")

        val averagePrice = productList.products.map { it.price }.average()
        println("Precio medio de los productos: $averagePrice")

        val productsByBrand = productList.products.groupBy { it.brand }
        for ((brand, products) in productsByBrand) {
            println("Número de productos de la marca $brand: ${products.size}")
        }

        val productsByCategory = productList.products.groupBy { it.category }
        for ((category, products) in productsByCategory) {
            println("Número de productos de la categoría $category: ${products.size}")
        }

        val result: ProductReturn = ProductReturn(maxPriceProduct, minPriceProduct, averagePrice, productsByBrand,
            productsByCategory)

        return result;
    }
}
