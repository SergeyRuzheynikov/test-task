package com.example.testtask.payprocessor

import com.example.testtask.exception.PayPalPriceException

class PaypalProcessor {

//    fun makePayment(price: Int){
//
//        if (price>100000) throw PayPalPriceException(price)
//    }

   fun makePayment(price: Int)
   {
       if (price>100000) throw PayPalPriceException(price)
   }
}