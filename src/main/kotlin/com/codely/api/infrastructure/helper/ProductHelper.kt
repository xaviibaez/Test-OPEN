package com.codely.api.infrastructure.helper

interface ProductHelper {
    fun getAllProducts(): String
    fun getProductsByUser(ids: List<Long>): String
}