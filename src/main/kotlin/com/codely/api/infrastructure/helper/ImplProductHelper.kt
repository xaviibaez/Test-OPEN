package com.codely.api.infrastructure.helper

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Repository
import java.net.URL

@Repository
class ImplProductHelper: ProductHelper {

    //Formamos los json de respuesta
    override fun getAllProducts() = runBlocking {
        var skip = 0
        var products = "{\"data\": ["

        while (skip <= 100) {
            val result = async(Dispatchers.IO) {
                URL("https://dummyjson.com/products?skip=" + skip).readText()
            }
            //Para que sea 100% escalable, deberia recuperar el skip y limit del ultimo result
            products += result.await() + ","
            skip += 10
        }

        products = products + "]\n" + "}"
        return@runBlocking products
    }

    override fun getProductsByUser(ids: List<Long>) = runBlocking {
        var products = "{\"data\": ["

        for (id in ids) {
            val result = async(Dispatchers.IO) {
                URL("https://dummyjson.com/carts/user/" + id).readText()
            }

            //Para que sea 100% escalable, deberia recuperar el skip y limit del ultimo result
            products += result.await() + ","
        }

        products = products + "]\n" + "}"
        return@runBlocking products
    }
}