package com.example.testtask.service

import com.example.testtask.controller.CalculatePriceDto
import org.springframework.stereotype.Service

@Service
class ShopServiceImpl:IShopService {
    override fun calculatePrice(dto: CalculatePriceDto): UInt {
        println(""+dto.product+dto.couponCode+dto.taxNumber);
        return (2+2).toUInt()
    }


}