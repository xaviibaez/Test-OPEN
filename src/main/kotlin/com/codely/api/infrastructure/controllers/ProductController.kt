package com.codely.api.infrastructure.controllers

import ProductReturn
import com.codely.api.infrastructure.services.ProductService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/products")
class ProductController(private val productService: ProductService) : IProductController {

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
    override fun getAllProducts(): ProductReturn {
        val result: ProductReturn = productService.getAllProducts();
        return result;
    }

    /*
    Dada una lista de usuarios debe devolver una lista de todos los productos que existen en los carts de dichos usuarios. Para obtener los carts de cada usuario hay que llamar a: https://dummyjson.com/carts/user/x Siendo x el id de usuario.
    Dicha lista debe ir agrupada por el id y la descripción del producto y debe mostrar la cantidad total de productos y el precio total. También la media del descuento aplicado para ese producto en todos los carros.
     */
    @GetMapping("/{id}")
    @ResponseBody
    override fun getAllProductsPerUser(@PathVariable id: Long): ProductReturn {
        val result: ProductReturn = productService.getAllProducts();
        return result;
    }
}