package com.codely.api.infrastructure.controllers

import ProductReturn
import com.codely.api.infrastructure.services.ProductService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/products")
class ProductController(private val productService: ProductService) : IProductController{
    @GetMapping("/")
    @ResponseBody
    override fun getAllProducts(): ProductReturn {
        val result: ProductReturn = productService.getAllProducts();
        return result;
    }
}