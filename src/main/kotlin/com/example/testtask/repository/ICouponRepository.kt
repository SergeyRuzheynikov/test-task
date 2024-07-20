package com.example.testtask.repository

import com.example.testtask.entity.Coupon
import com.example.testtask.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ICouponRepository:JpaRepository<Coupon,Int> {
    fun findByName(name: String): Coupon?

}