package com.example.testtask.exception

import org.springframework.http.HttpStatus

class PayPalPriceException(price: Int): BaseException(
    HttpStatus.BAD_REQUEST,
    ApiError(
        errorCode = "Bad price",
        description = "Price is over than 100000"

    )

) {
}