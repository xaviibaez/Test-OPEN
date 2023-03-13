package com.codely.api.infrastructure.controllers

import Product
import ProductReturn
import org.springframework.web.servlet.function.ServerResponse
import reactor.core.publisher.Mono

interface IProductController {
    fun getAllProducts(): ProductReturn?/*
    fun getProductWithHighestPrice(): Mono<Product>
    fun getProductWithLowestPrice(): Mono<Product>
    fun getAveragePrice(): Mono<Double>
    fun getNumberOfProductsByBrand(): Mono<Map<String, Int>>
    fun getNumberOfProductsByCategory(): Mono<Map<String, Int>>*/
}