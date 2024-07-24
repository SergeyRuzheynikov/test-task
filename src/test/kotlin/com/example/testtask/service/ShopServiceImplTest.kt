package com.example.testtask.service

import com.example.testtask.controller.CalculatePriceDto
import com.example.testtask.controller.PurchaseDto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class ShopServiceImplTest {

    @Autowired
    private lateinit var serviceImpl: ShopServiceImpl

    @Test
    fun calculatePriceTest4() {
        var dto: CalculatePriceDto = CalculatePriceDto(4u,"FR000000000","P10")

        var actual=serviceImpl.calculatePrice(dto)

        var expected=129600.0.toFloat()

        assertEquals(expected,actual)

    }

    @Test
    fun calculatePriceTest3() {
        var dto: CalculatePriceDto = CalculatePriceDto(3u,"FR000000000","P10")

        var actual=serviceImpl.calculatePrice(dto)

        var expected=10.8.toFloat()

        assertEquals(expected,actual)

    }


    @Test
    fun calculatePriceTest2() {
        var dto: CalculatePriceDto = CalculatePriceDto(2u,"FR000000000","P10")

        var actual=serviceImpl.calculatePrice(dto)

        var expected=21.6.toFloat()

        assertEquals(expected,actual)

    }


    @Test
    fun calculatePriceTest1() {
        var dto: CalculatePriceDto = CalculatePriceDto(1u,"FR000000000","P10")

        var actual=serviceImpl.calculatePrice(dto)

        var expected=108.0.toFloat()

        assertEquals(expected,actual)

    }


    @Test
    fun purchaseTest1() {
        var dto: PurchaseDto = PurchaseDto(1u,"FR000000000","P10","paypal")

        var actual=serviceImpl.purchase(dto)

        var expected="purchase: kotlin.Unit"

        assertEquals(expected,actual)

    }




}