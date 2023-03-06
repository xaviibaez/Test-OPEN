package com.codely.api.infrastructure.controllers

import com.codely.api.infrastructure.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RestController
class ProductController: IProductController {
    @Autowired
    var productService: IProductService? = null

    @GetMapping("/product")
    @ResponseBody
    override fun getAllProducts(): String {
        productService
        return "Products"
    }
}
