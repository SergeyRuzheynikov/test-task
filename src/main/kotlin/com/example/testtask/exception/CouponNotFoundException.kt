package com.example.testtask.exception
import org.springframework.http.HttpStatus

class CouponNotFoundException(couponName: String) : BaseException(
    HttpStatus.BAD_REQUEST,
    ApiError(
        errorCode = "coupon not found",
        description = "Coupon not found with code=$couponName"
    )
)
