package com.example.testtask.service

import com.example.testtask.controller.CalculatePriceDto
import com.example.testtask.controller.PurchaseDto

interface IShopService {

    fun calculatePrice(dto: CalculatePriceDto): Double

    fun purchase(dto: PurchaseDto):String

}