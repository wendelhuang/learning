package com.sosimplebox.p007_autocloseable;

public class AC1 implements AutoCloseable {
	
	static {
		System.out.println("static in " + AC1.class);
	}

	@Override
	public void close() throws Exception {
		
		System.out.println("close in " + AC1.class);
	}

}
