package com.example.testtask.controller

class PurchaseDto (
    val product: UInt,
    val taxNumber: String,
    val couponCode: String,
    val paymentProcessor: String
)