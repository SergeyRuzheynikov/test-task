package com.example.testtask.payprocessor

interface IPaymentProcessor {
    fun doPay(price: Int)
    fun doPay(price: Float):Boolean
}