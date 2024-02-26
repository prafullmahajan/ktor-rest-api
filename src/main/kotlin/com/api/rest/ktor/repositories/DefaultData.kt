package com.api.rest.ktor.repositories

import com.api.rest.ktor.models.Employee

object DefaultData {
        val DEFAULT_Employee = Employee("1","Prafull","Mahajan","prafullmahajan1@gmail.com")
        val DEFAULT_Employees = listOf(DEFAULT_Employee)
}