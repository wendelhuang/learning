package com.sosimplebox.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sosimplebox.App;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {App.class})
public class TestPropagationRequiresNew {
	
	@Autowired
	TestPropagationRequiresNewService testPropagationRequiresNewService;
	
	@Test
	public void test() {
		testPropagationRequiresNewService.test();
	}
	
	@Test
	public void testWithCatch() {
		testPropagationRequiresNewService.testWithCatch();
	}
}
