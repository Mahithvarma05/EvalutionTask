package com.example.client

import com.example.model.ApiRequest
import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.gson.gson

suspend fun getData(): ApiRequest {

    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            gson()
        }
    }

    val response = client.get("https://mocki.io/v1/47aa2a2a-6119-4fba-b937-713937530293")
    return Gson().fromJson(response.bodyAsText(), ApiRequest::class.java)
}
