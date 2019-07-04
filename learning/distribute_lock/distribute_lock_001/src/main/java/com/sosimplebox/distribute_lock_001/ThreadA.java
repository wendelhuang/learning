package com.sosimplebox.distribute_lock_001;


public class ThreadA extends Thread {
	
	private RedisDistributeService redisDistributeService;
	
	public ThreadA(RedisDistributeService redisDistributeService, String name) {
		super(name);
		this.redisDistributeService = redisDistributeService;
		
	}

	@Override
	public void run() {
		
		this.redisDistributeService.seckill();
	}

}
