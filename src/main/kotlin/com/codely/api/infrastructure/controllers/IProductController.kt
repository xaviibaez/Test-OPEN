package com.codely.api.infrastructure.controllers

import ProductReturn
import org.springframework.web.bind.annotation.PathVariable
interface IProductController {
    fun getAllProducts(): ProductReturn?
    fun getAllProductsPerUser(@PathVariable id: Long): ProductReturn?
}