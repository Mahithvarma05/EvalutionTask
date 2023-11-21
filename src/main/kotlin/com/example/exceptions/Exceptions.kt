package com.example.exceptions

import com.example.model.ErrorResponse
import io.ktor.http.HttpStatusCode

class InvalidAgeException(val statusCode: HttpStatusCode,val errorResponse:ErrorResponse):RuntimeException()
class InvalidRequestException(val statusCode: HttpStatusCode):RuntimeException()

class CommonException(val msg:String,val statusCode: HttpStatusCode):RuntimeException()
