package com.example.testtask.controller

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull
import org.springframework.validation.annotation.Validated

data class CalculatePriceDto (

    val product: UInt,
    //@field:NotBlank(message = "taxNumber is required")
    @field:Size(max = 15, min = 4, message = "Please enter full tax")
    @field:NotEmpty(message = "Please enter tax")
    val taxNumber: String,
    val couponCode: String,
)