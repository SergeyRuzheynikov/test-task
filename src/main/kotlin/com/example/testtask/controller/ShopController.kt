package com.example.testtask.controller

import com.example.testtask.service.IShopService
import jakarta.validation.Valid
import org.apache.catalina.connector.Response
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class ShopController(private val shopService: IShopService) {


        //    {
        //        "product": 1,
        //        "taxNumber": "DE123456789",
        //        "couponCode": "D15"
        //    }
        // => iphone, germany, 15% discount
        @PostMapping("/calculate-price")
        fun calculatePrice(@Validated @RequestBody dto: CalculatePriceDto): Double {
            return shopService.calculatePrice(dto = dto)
        }


        @PostMapping("/purchase")
        fun purchase(@RequestBody dtoPurchase: PurchaseDto): String {
            return shopService.purchase(dto = dtoPurchase)
        }

}