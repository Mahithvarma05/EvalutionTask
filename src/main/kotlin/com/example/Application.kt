package com.example


import com.example.db.DBClass
import com.example.plugins.configContentNegotiation
import com.example.plugins.configStatusPages
import com.example.route.route
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.tomcat.Tomcat
fun main() {
embeddedServer(Tomcat, port = 8080, module = Application::module)
    .start(wait = true)

}

fun Application.module() {
    configContentNegotiation()
    configStatusPages()
    DBClass.init()
    route()
}
