package com.example.utils.helperFuctions

import com.example.exceptions.InvalidRequestException
import com.example.model.ApiRequest
import io.ktor.http.*
import io.ktor.server.plugins.requestvalidation.*


fun validateRequest(request: ApiRequest): ValidationResult {
    with(request) {
        return when {
            request.status.isBlank() -> throw InvalidRequestException(HttpStatusCode.BadRequest)
            else -> ValidationResult.Valid
        }
    }

}
