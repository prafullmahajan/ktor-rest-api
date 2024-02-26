package com.api.rest.ktor.services

import com.api.rest.ktor.models.Employee
import com.api.rest.ktor.models.employees
import com.api.rest.ktor.repositories.DefaultData
import com.api.rest.ktor.repositories.EmployeeRepository

class EmployeeService(private val employeeRepository: EmployeeRepository) {
    fun getAllEmployee() : List<Employee> = employeeRepository.findEmployee(employees) ?: error("Can't find default employee")
    fun saveDefaultEmployees() {
        employeeRepository.addEmployees(DefaultData.DEFAULT_Employees)
    }
    fun sayHello() : String {
        return "Hello '${getAllEmployee()}'"
    }

    fun removeEmployeeById(empId : String) : Boolean{
        return employeeRepository.removeEmployee(empId)
    }

    fun findEmployeeById(empId: String): Employee?{
        return employeeRepository.findEmployeeById(empId)
    }

    fun addEmployee(employee: Employee){
        employeeRepository.addEmployeeRecord(employee)
    }
}