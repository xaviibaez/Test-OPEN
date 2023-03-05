package com.codely.api.infrastructure.controllers

interface IHealthcheckController {
    fun health(): String
}