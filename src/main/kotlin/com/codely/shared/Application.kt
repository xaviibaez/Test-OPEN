package com.codely.shared

import com.codely.api.infrastructure.docs.SwaggerConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@ComponentScan("com.codely")
@EnableSwagger2
@EnableWebMvc
@Import(SwaggerConfig::class)
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
