package com.sosimplebox.p004_import;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationMain.class)
public class ImportAnnotationTestB {
	@Autowired
	TestB testB;
	
	@Test
	public void test() {
		testB.printName();
	}
}
