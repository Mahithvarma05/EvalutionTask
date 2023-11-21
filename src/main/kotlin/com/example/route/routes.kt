package com.example.route

import com.example.service.StorePanInfoData
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.*

fun Application.route() {

    routing {

        route("/v1/onboarding/user-info") {
            get("/pan-verification") {
                val result = StorePanInfoData().getDetails()
                call.respond(result)
            }
        }
    }
    }