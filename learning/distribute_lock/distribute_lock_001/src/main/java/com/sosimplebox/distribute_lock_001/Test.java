package com.sosimplebox.distribute_lock_001;

public class Test {
	public static void main(String[] args) {
		RedisDistributeService redisDistributeService = new RedisDistributeService();
		
		for(int i = 0; i < 50; i++) {
			ThreadA t = new ThreadA(redisDistributeService, "thread-" + i);
			t.start();
		}
	}
}
