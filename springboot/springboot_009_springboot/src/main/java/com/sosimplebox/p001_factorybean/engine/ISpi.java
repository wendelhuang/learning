package com.sosimplebox.p001_factorybean.engine;

public interface ISpi<T> {
	boolean verify(T condition);
	
	default int order() {
		return 10;
	}
}
