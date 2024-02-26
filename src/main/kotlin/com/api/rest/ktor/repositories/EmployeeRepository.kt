package com.api.rest.ktor.repositories

import com.api.rest.ktor.models.Employee
import com.api.rest.ktor.models.employees

/**
 * Repository Component to manage Employee Operations
 *
* */
interface EmployeeRepository {
    fun findEmployee(employeeList: MutableList<Employee>): List<Employee>?
    fun addEmployees(employeeList: List<Employee>)
    fun findEmployeeById(employeeId: String): Employee?
    fun removeEmployee(employeeId: String) : Boolean
    fun addEmployeeRecord(employee: Employee)
}

class EmployeeRespositoryImpl: EmployeeRepository{
    override fun findEmployee(employees: MutableList<Employee>): List<Employee>? {
        return employees
   }

    override fun addEmployees(employeeList: List<Employee>) {
        employees.addAll(employeeList)
    }

    override fun findEmployeeById(employeeId: String): Employee? {
        return employees.find {it.id == employeeId}
    }

    override fun removeEmployee(employeeId: String): Boolean{
        return employees.removeIf {it.id == employeeId}
    }

    override fun addEmployeeRecord(employee: Employee) {
        employees.add(employee)
    }
}