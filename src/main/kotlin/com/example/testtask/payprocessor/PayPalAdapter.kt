package com.example.testtask.payprocessor

class PayPalAdapter(var pp:PaypalProcessor):IPaymentProcessor {
    override fun doPay(price:Int) {
        pp.makePayment(price)
    }

    override fun doPay(price: Float): Boolean {
        TODO("Not yet implemented")
    }
}