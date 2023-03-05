package com.codely.api.infrastructure.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController: IProductController {

    
    @GetMapping("/product")
    @ResponseBody
    override fun getAllProducts(): String {
        return "Products"
    }
}
