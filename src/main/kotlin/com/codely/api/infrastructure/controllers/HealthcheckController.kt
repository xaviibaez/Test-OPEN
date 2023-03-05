package com.codely.api.infrastructure.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthcheckController: IHealthcheckController {

    @GetMapping("/health-check")
    @ResponseBody
    override fun health(): String = "OK"
}
