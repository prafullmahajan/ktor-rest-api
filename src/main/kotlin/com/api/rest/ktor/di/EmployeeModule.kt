package com.api.rest.ktor.di

import com.api.rest.ktor.repositories.EmployeeRepository
import com.api.rest.ktor.repositories.EmployeeRespositoryImpl
import com.api.rest.ktor.services.EmployeeService
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/*
Constructor DSL
Injecting EmployeeRepository by creating singletone instance of EmployeeRepositoryImpl
Also injecting singletone instance of employeeService

EmployeeRepository is referenced in employeeService constructor
*/
var employeeModule = module {
    singleOf(:: EmployeeRespositoryImpl) {bind<EmployeeRepository>()}
    singleOf(::EmployeeService)
}

// Classic DSL
//val appModule = module {
//    single<UserRepository> { UserRepositoryImpl() }
//    single { UserService(get()) }
//}