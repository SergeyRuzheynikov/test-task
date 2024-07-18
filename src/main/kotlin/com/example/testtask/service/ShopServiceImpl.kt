package com.example.testtask.service

import com.example.testtask.controller.CalculatePriceDto
import com.example.testtask.controller.PurchaseDto
import com.example.testtask.entity.Product
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class ShopServiceImpl(
    // productRepository: ProductRepository,
    // couponRepository: CouponRepository
) : IShopService {
    override fun calculatePrice(dto: CalculatePriceDto): UInt {
        println("" + dto.product + dto.couponCode + dto.taxNumber);

        println(taxCalc(dto.taxNumber))
        return (2 + 2).toUInt()
    }


    fun taxCalc(taxCode: String): Double {
        var code: String = taxCode.get(0).toString() + taxCode.get(1).toString()
        when (code) {
            "DE" -> {
                println("Германия")
                return 0.19
            }

            "IT" -> {
                println("Италия")
                return 0.22
            }

            "FR" -> {
                println("Франция")
                return 0.20
            }

            "GR" -> {
                println("Греция")
                return 0.24
            }

            else -> {
                println("Нет страны с кодом $code")
                throw (Exception("Нет страны с кодом $code"))
            }
        }
        return 2.5
    }

    /**
     * Найти цену продукта
     * Например, цена Iphone для покупателя из Греции
     * составит 124 евро
     * (100 евро + налог 24%).
     * Если у покупателя есть купон на 6% скидку,
     * то цена будет 116.56 евро
     * (100 евро - 6% скидка + налог 24%)
     * */
    fun findPriceProductByName(name: String): Double {
        TODO()
        return 2.5
    }

    /**
     * Найти купон в базе
     * вернуть true если есть
     * false если нет
     * */
    fun findCouponByName(couponName: String): Boolean {
        TODO()
        return true
    }


    override fun purchase(dto: PurchaseDto): String {
        println("" + dto.product + dto.couponCode + dto.taxNumber + dto.paymentProcessor);
        return "maybe purchase"
    }


}