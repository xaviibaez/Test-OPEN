package com.codely.api.infrastructure.controllers

import GetProductService
import GetProductServiceUser
import com.codely.api.infrastructure.services.ImplProductService
import org.springframework.web.bind.annotation.*

//todo: rename IInterface a Interface , Implemented a ImplImplemented
@RestController
@RequestMapping("/api/products")
class ImplProductController(private val productService: ImplProductService) : ProductController {

    /*
    Debe devolver la siguiente información acerca de los productos que devuelve la llamada a: https://dummyjson.com/products
    Producto con el precio más alto
    Producto con el precio más bajo
    Precio medio de los productos
    Número de productos por marca
    Número de productos por categoría
     */
    @GetMapping("/")
    @ResponseBody
    override fun getAllProducts(): GetProductService {
        val result: GetProductService
        try {
            result = productService.getAllProducts()
        } catch (e: Exception) {
            throw Exception(e.message)
        }

        return result
    }

    /*
    Dada una lista de usuarios debe devolver una lista de todos los productos que existen en los carts de dichos usuarios.
    Para obtener los carts de cada usuario hay que llamar a: https://dummyjson.com/carts/user/x Siendo x el id de usuario.
    Dicha lista debe ir agrupada por el id y la descripción del producto y debe mostrar la cantidad total de productos y el precio total.
    También la media del descuento aplicado para ese producto en todos los carros.
     */
    @GetMapping("/user")
    @ResponseBody
    override fun getAllProductsPerUser(@RequestParam ids: List<Long>): GetProductServiceUser {
        val result: GetProductServiceUser
        try {
            result = productService.getProductsByUser(ids)
        } catch (e: Exception) {
            throw Exception(e.message)
        }

        return result
    }
}