package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_11;

public class JMTP02_11_Task {
    private String getData1;
    private String getData2;
    synchronized public void doLongTimeTask() {
        try {
            System.out.println("task begin");
            Thread.sleep(3000);
            getData1 = String.format("长时间处理任务后从远程返回的值1 threadName = %s", Thread.currentThread().getName());
            getData2 = String.format("长时间处理任务后从远程返回的值2 threadName = %s", Thread.currentThread().getName());
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("task end");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
