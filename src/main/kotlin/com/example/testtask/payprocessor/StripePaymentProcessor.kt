package com.example.testtask.payprocessor

class StripePaymentProcessor {

    fun pay(price: Float): Boolean{

        return price >= 100

    }
}