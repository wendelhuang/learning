package com.sklink.learning.juc.threadPoolExecutor_001_rejectedExecutionHandler_001;

import java.util.HashMap;
import java.util.Map;

public class TestRejectedExecutionHandler {
	public static void main(String[] args) {
		Map<String, PolicyAbstractPolicy> map = new HashMap<String, PolicyAbstractPolicy>();
		map.put("AbortPolicy", new PolicyAbortPolicy());
		map.put("DiscardPolicy", new PolicyDiscardPolicy());
		map.put("DiscardOldestPolicy", new PolicyDiscardOldestPolicy());
		map.put("CallerRunsPolicy", new PolicyCallerRunsPolicy());

		// map.get("AbortPolicy").test();
		// map.get("DiscardPolicy").test();
		// map.get("DiscardOldestPolicy").test();
		map.get("CallerRunsPolicy").test();
	}
}
