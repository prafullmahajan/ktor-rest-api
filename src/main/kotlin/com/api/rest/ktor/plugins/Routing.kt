package com.api.rest.ktor.plugins

import com.api.rest.ktor.routes.employeeRoutes
import com.api.rest.ktor.services.EmployeeService
import io.ktor.server.application.*
import io.ktor.server.routing.*

/**
 * Extension Method of Application Class
 *
 * Registering Routes in routing block
 */
fun Application.configureRouting(employeeService: EmployeeService) {
    routing {
        employeeRoutes(employeeService)
    }
}
