package com.api.rest.ktor.models

import kotlinx.serialization.Serializable

/*
 data Model Class Employee
* */

@Serializable
data class Employee (val id: String, val firstName: String, val lastName: String, val email: String) {
}

val employees = mutableListOf<Employee>()