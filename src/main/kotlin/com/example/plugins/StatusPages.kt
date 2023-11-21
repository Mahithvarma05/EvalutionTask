package com.example.plugins

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.application.ApplicationCall
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respond

fun Application.configStatusPages(){

    install(StatusPages) {
        exception<RuntimeException> { call: ApplicationCall, cause -> call.respond(
            status = HttpStatusCode.InternalServerError,
            message = cause.localizedMessage
        )  }
    }

}