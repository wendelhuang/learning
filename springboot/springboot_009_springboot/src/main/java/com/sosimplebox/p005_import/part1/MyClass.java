package com.sosimplebox.p005_import.part1;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyClass implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[] {"com.sosimplebox.p005_import.part1.TestDemo2"};
	}

}
