package com.example.testtask.service

import com.example.testtask.controller.CalculatePriceDto
import com.example.testtask.controller.PurchaseDto
import com.example.testtask.entity.Coupon
import com.example.testtask.entity.Product
import com.example.testtask.repository.ICouponRepository
import com.example.testtask.repository.IProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.example.testtask.exception.CouponNotFoundException
import java.lang.Exception
import java.util.*

@Service
class ShopServiceImpl(
    // couponRepository: CouponRepository
) : IShopService {

    @Autowired
    private lateinit var productRepository: IProductRepository

    @Autowired
    private lateinit var couponRepository: ICouponRepository

    override fun calculatePrice(dto: CalculatePriceDto): Double {
        println("" + dto.product + dto.couponCode + dto.taxNumber);

        var price = findPriceProductById(dto.product.toInt())
        var priceWithDiscount = calcPriceWithDiscount(price, dto.couponCode)

        var tax = taxCalc(dto.taxNumber)
        println("цена продукта №${dto.product}: " + price)
        println("цена продукта со скидкой №${dto.product}: " + priceWithDiscount)
        println("налог по стране:" + tax)

        var itog: Double = priceWithDiscount + priceWithDiscount * tax

        println("итого=${priceWithDiscount}+${priceWithDiscount}*${tax} = " + itog)
        return itog
    }


    fun calcPriceWithDiscount(price: Double, couponName: String): Double {
        if (findCouponByName(couponName)) {

            var prefix = couponName.get(0).toString()
            var discountNumber: String = ""
            for (i in 1..couponName.length - 1) {
                discountNumber = discountNumber.plus(couponName[i])
            }
            println("число в скидке=$discountNumber")

            var discount: Double = discountNumber.toInt().toDouble()


            when (prefix) {
                "P" -> {
                    println("Процентная скидка")
                    discount = discount / 100

                    println("$price -$price * $discount ="+(price-price*discount))
                    return price-price * discount
                }

                "D" -> {
                    println("Вещественная скидка")
                    var itog = price - discount
                    if (itog < 0) return 0.0
                    else
                        return itog
                }

                else -> {
                    println("Нет такого купона")
                    throw (Exception("Нет такого купона"))
                }
            }
        } else throw CouponNotFoundException(couponName)

    return price
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
        var price = productRepository.findByName(name)?.price ?: -1.0
        return price
    }

    fun findPriceProductById(id: Int): Double {
        var price = productRepository.findById(id)?.get()?.price ?: -1.0
        return price
    }


    /**
     * Найти купон в базе
     * вернуть true если есть
     * false если нет
     * */
    fun findCouponByName(name: String): Boolean {
        var discount = couponRepository.findByName(name)
        if (discount != null) return true
        else throw CouponNotFoundException(name)//throw(Exception("Купона $name не существует"))
    }

    override fun purchase(dto: PurchaseDto): String {
        println("" + dto.product + dto.couponCode + dto.taxNumber + dto.paymentProcessor);
        return "maybe purchase"
    }


}