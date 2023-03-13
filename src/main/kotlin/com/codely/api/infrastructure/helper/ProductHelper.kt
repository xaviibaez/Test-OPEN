package com.codely.api.infrastructure.helper

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Repository
import java.net.URL

@Repository
class ProductHelper {
    fun getAllProducts() = runBlocking {
        var skip = 0
        var products = "{\"data\": ["

        while (skip <= 100) {
            val result = async(Dispatchers.IO) {
                URL("https://dummyjson.com/products?skip=" + skip).readText()
            }
            products += result.await() + ",";
            skip += 10;
        }

        products = products + "]\n" + "}"
        return@runBlocking products
    }
}