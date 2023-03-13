package com.codely.api.infrastructure.helper

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.client.WebClient
import java.net.URL

@Repository
class ProductHelper {

    private val webClient = WebClient.builder()
        .baseUrl("https://dummyjson.com")
        .build()

    fun getAllProducts() = runBlocking {
        val result = async(Dispatchers.IO) {
            URL("https://dummyjson.com/products").readText()
        }

        return@runBlocking result.await()
    }
}