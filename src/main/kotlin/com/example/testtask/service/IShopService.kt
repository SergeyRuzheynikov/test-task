package com.example.testtask.service

import com.example.testtask.controller.CalculatePriceDto

interface IShopService {

    fun calculatePrice(dto: CalculatePriceDto):UInt

}