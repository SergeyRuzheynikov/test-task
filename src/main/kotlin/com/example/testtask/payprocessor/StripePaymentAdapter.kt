package com.example.testtask.payprocessor

class StripePaymentAdapter(var sp:StripePaymentProcessor):IPaymentProcessor {
    override fun doPay(price:Int) {
        TODO("Not yet implemented")
    }

    override fun doPay(price: Float): Boolean {
        return sp.pay(price)
    }
}