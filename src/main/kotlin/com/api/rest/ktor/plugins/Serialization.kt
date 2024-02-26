package com.api.rest.ktor.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

/**
 * Extension Method of Application Class
 *
 * Configuring the ContentNegotiation plugin and adding to application
 */
fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}
