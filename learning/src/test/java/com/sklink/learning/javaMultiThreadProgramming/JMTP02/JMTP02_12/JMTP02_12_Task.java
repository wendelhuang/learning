package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_12;

public class JMTP02_12_Task {
    private String getData1;
    private String getData2;
    public void doLongTimeTask() {
        try {
            System.out.println("task begin");
            Thread.sleep(3000);
            String data1 = String.format("长时间处理任务后从远程返回的值1 threadName = %s", Thread.currentThread().getName());
            String data2 = String.format("长时间处理任务后从远程返回的值2 threadName = %s", Thread.currentThread().getName());
            synchronized (this) {
                getData1 = data1;
                getData2 = data2;
            }
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("task end");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
