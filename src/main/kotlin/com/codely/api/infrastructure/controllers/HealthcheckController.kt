package com.codely.api.infrastructure.controllers

interface HealthcheckController {
    fun health(): String
}