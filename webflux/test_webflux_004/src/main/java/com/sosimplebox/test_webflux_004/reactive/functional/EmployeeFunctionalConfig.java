package com.sosimplebox.test_webflux_004.reactive.functional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.sosimplebox.test_webflux_004.webflux.Employee;
import com.sosimplebox.test_webflux_004.webflux.EmployeeRepository;

@Configuration
public class EmployeeFunctionalConfig {
	@Bean
	EmployeeRepository employeeRepository() {
		return new EmployeeRepository();
	}
	
	@Bean
	RouterFunction<ServerResponse> getAllEmployeesRoute() {
		return RouterFunctions.route(RequestPredicates.GET("/employees"), 
				req -> ServerResponse.ok().body(employeeRepository().listEmployees(), Employee.class));
	}
	
	@Bean
	RouterFunction<ServerResponse> getEmployeeByIdRoute() {
		return RouterFunctions.route(RequestPredicates.GET("/employees/{id}"),
				req -> ServerResponse.ok().body(employeeRepository().getEmployeeById(req.pathVariable("id")), Employee.class));
	}
	
	@Bean
	RouterFunction<ServerResponse> updateEmployeeRoute() {
		return RouterFunctions.route(RequestPredicates.POST("/employees/update"),
				req -> req.body(BodyExtractors.toMono(Employee.class))
						.doOnNext(employeeRepository()::updateEmployee)
						.then(ServerResponse.ok().build()));
	}
	
	@Bean
	RouterFunction<ServerResponse> composedRoutes() {
		return RouterFunctions.route(RequestPredicates.GET("/employees"), 
				req -> ServerResponse.ok().body(employeeRepository().listEmployees(), Employee.class))
				.and(RouterFunctions.route(RequestPredicates.GET("/employees/{id}"),
				req -> ServerResponse.ok().body(employeeRepository().getEmployeeById(req.pathVariable("id")), Employee.class)))
				.and(RouterFunctions.route(RequestPredicates.POST("/employees/update"),
				req -> req.body(BodyExtractors.toMono(Employee.class))
						.doOnNext(employeeRepository()::updateEmployee)
						.then(ServerResponse.ok().build())));
	}
}
