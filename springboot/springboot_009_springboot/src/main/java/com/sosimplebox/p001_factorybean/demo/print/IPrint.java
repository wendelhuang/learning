package com.sosimplebox.p001_factorybean.demo.print;

import com.sosimplebox.p001_factorybean.engine.ISpi;

public interface IPrint extends ISpi<Integer> {
	
	default void execute(Integer level, Object... msg) {
		print(msg.length > 0? (String)msg[0] : null);
	}
	
	void print(String msg);
}
