package com.codely.api.infrastructure.services

import org.springframework.stereotype.Service

@Service
class ProductService {
    /*
    private val webClient = WebClient.builder()
            .baseUrl("https://dummyjson.com")
            .build()
    
    fun getAllProducts(): Mono<List<Product>> {
        return webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Product::class.java)
                .collectList()
    }

    fun getProductWithHighestPrice(products: List<Product>): Mono<Product> {
        return Flux.fromIterable(products)
                .reduce { p1, p2 -> if (p1.price > p2.price) p1 else p2 }
    }

    fun getProductWithLowestPrice(products: List<Product>): Mono<Product> {
        return Flux.fromIterable(products)
                .reduce { p1, p2 -> if (p1.price < p2.price) p1 else p2 }
    }

    fun getAveragePrice(products: List<Product>): Mono<Double> {
        return Flux.fromIterable(products)
                .map { it.price }
                .reduce { p1, p2 -> p1 + p2 }
                .map { totalPrice -> totalPrice / products.size }
    }

    fun getNumberOfProductsByBrand(products: List<Product>): Mono<Map<String, Int>> {
        return Flux.fromIterable(products)
                .groupBy { it.brand }
                .flatMap { group -> group.count().map { count -> Tuples.of(group.key(), count) } }
                .collectMap(Tuple2<String, Int>::t1, Tuple2<String, Int>::t2)
    }

    fun getNumberOfProductsByCategory(products: List<Product>): Mono<Map<String, Int>> {
        return Flux.fromIterable(products)
                .groupBy { it.category }
                .flatMap { group -> group.count().map { count -> Tuples.of(group.key(), count) } }
                .collectMap(Tuple2<String, Int>::t1, Tuple2<String, Int>::t2)
    }
    */
}
