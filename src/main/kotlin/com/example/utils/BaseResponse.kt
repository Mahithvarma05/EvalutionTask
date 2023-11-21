package com.example.utils

import io.ktor.http.HttpStatusCode

sealed class BaseResponse<T>(val status: HttpStatusCode = HttpStatusCode.OK){

    data class SuccessResponse<T>(val data: T?=null,val message: String?=null):BaseResponse<T>()

    data class ErrorResponse<T>(val data: T?=null,val message: String?=null):BaseResponse<T>()
}
