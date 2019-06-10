package com.sosimplebox.test_webflux_004.reactive.functional;

import static org.hamcrest.CoreMatchers.containsString;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.sosimplebox.test_webflux_004.webflux.Employee;
import com.sosimplebox.test_webflux_004.webflux.EmployeeRepository;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = EmployeeSpringFunctionalApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeSpringFunctionalIntefrationTest {
	@Autowired
	EmployeeFunctionalConfig employeeFunctionalConfig;
	
	@MockBean
	EmployeeRepository employeeRepository;
	
	@Test
	public void givenEmployeeId_whenGetEmployeeById_thenCorrectEmployee() {
		WebTestClient client = WebTestClient.bindToRouterFunction(employeeFunctionalConfig.getEmployeeByIdRoute()).build();
		
		Employee employee = new Employee("1", "Employee 1");
		
		BDDMockito.given(employeeRepository.getEmployeeById("1")).willReturn(Mono.just(employee));
		
		client.get()
				.uri("/employees/1")
				.exchange()
				.expectStatus()
				.isOk()
				.expectBody(Employee.class)
				.isEqualTo(employee);
	}
}
