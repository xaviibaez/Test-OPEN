package com.codely.api.infrastructure.controllers

import GetProductService
import GetProductServiceUser
import org.springframework.web.bind.annotation.RequestParam

interface ProductController {
    fun getAllProducts(): GetProductService?
    fun getAllProductsPerUser(@RequestParam ids: List<Long>): GetProductServiceUser?
}