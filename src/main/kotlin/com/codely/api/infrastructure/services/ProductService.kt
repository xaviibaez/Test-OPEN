package com.codely.api.infrastructure.services

import Product
import ProductReturn
import com.codely.api.infrastructure.helper.ProductHelper
import org.springframework.stereotype.Service
import com.google.gson.Gson
import RawData


@Service
class ProductService(private val productHelper: ProductHelper) {

    fun getAllProducts(): ProductReturn {
        val gson = Gson()
        val rawData = gson.fromJson(productHelper.getAllProducts(), RawData::class.java)

        val products = arrayListOf<Product>()

        //todo: add try catch and throw 400 if null
        if(!rawData.data.isNullOrEmpty()) {
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

        val result: ProductReturn = ProductReturn(maxPriceProduct, minPriceProduct, averagePrice, productsByBrand,
            productsByCategory)

        return result;
    }
}
