package com.example.routeTest

import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import io.ktor.server.testing.*
import junit.framework.TestCase.assertEquals
import kotlin.test.Test

class RouteTest {
    @Test
    fun testRoute()= testApplication {


        val response = client.get("/v1/onboarding/user-info" + "/pan-verification"){
            headers[HttpHeaders.ContentType] = ContentType.Application.Json.toString()

        }
        assertEquals(HttpStatusCode.OK, response.status)
    }
}