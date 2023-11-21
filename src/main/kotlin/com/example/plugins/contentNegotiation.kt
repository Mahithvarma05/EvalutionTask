package com.example.plugins

import io.ktor.serialization.jackson.jackson
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation

fun Application.configContentNegotiation() {

    install(ContentNegotiation) {
        jackson {}
    }

}
