package com.api.rest.ktor.routes

import com.api.rest.ktor.models.Employee
import com.api.rest.ktor.models.employees
import com.api.rest.ktor.services.EmployeeService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.employeeRoutes(employeeService: EmployeeService) {
    route("/employee"){
        get {
            if(employees.isNotEmpty()){
                call.respond(employeeService.getAllEmployee())
            }else{
                call.respondText("No Employees Found", status = HttpStatusCode.OK)
            }
        }
        get("{id?}"){
            val id = call.parameters["id"]?:return@get call.respondText("Id is Missing",
                status = HttpStatusCode.BadRequest
            )

            val employee = employeeService.findEmployeeById(id) ?: call.respondText(
                "no employee found with id $id",
                status = HttpStatusCode.NotFound
            )

            call.respond(employee)
        }
        post{
                val employee = call.receive<Employee>()

                employeeService.addEmployee(employee)
                call.respondText("Employee Record Created Successfully..!!", status = HttpStatusCode.Created)
        }
        delete("{id?}") {
            val id = call.parameters["id"]?: return@delete call.respond(HttpStatusCode.BadRequest)

            if(employeeService.removeEmployeeById(id)){
                call.respondText("Employee Record Removed Successfully ..!!", status = HttpStatusCode.Accepted)
            }else{
                call.respondText(
                    "Not Found",
                    status = HttpStatusCode.NotFound
                )
            }
        }
    }
}