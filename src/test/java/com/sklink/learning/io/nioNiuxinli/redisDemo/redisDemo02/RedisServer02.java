package com.sklink.learning.io.nioNiuxinli.redisDemo.redisDemo02;

import com.sklink.learning.io.nioNiuxinli.redisDemo.Utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RedisServer02 {
    public static Map<String, String> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(200, 1000, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));
        ServerSocket serverSocket = new ServerSocket(8888, 1000);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            Utils.logDebug(clientSocket.getRemoteSocketAddress().toString());
            threadPool.execute(new RequestHandler(clientSocket));
        }
    }
}
