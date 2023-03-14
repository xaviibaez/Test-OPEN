package com.codely.api.infrastructure.services

import GetProductService
import GetProductServiceUser

interface ProductService {
    fun getAllProducts(): GetProductService
    fun getProductsByUser(ids: List<Long>): GetProductServiceUser
}