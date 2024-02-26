package com.api.rest.ktor

import com.api.rest.ktor.di.employeeModule
import com.api.rest.ktor.models.Employee
import com.api.rest.ktor.plugins.*
import com.api.rest.ktor.services.EmployeeService
import io.ktor.http.*
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
//import org.koin.java.KoinJavaComponent.inject
import org.koin.ktor.ext.inject

//import org.koin.ktor.ext.inject

fun main() {


    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::main)
            .start(wait = true)
}

//fun Application.module() {
//    configureSerialization()
//    configureRouting()
//}

fun Application.main(){
    install(Koin) {
        modules(employeeModule)
    }


    // Lazy inject employee service
    val service by inject<EmployeeService> ()

    // this will add list of employees from constants to employee model
    service.saveDefaultEmployees()

    configureSerialization()
    configureRouting(service)
}
