package com.sosimplebox.p007_autocloseable;

public class AC2 implements AutoCloseable {
	
	static {
		System.out.println("static in " + AC2.class);
	}

	@Override
	public void close() throws Exception {
		
		System.out.println("close in " + AC2.class);
	}

}
