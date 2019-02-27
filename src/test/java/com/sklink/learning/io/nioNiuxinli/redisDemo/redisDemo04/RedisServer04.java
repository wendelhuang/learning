package com.sklink.learning.io.nioNiuxinli.redisDemo.redisDemo04;

import com.sklink.learning.io.nioNiuxinli.redisDemo.Utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RedisServer04 {
    public static Map<String, String> cache = new ConcurrentHashMap<>();
    final public static Set<Socket> socketSet = new HashSet<>(10);

    public static void main(String[] args) throws IOException {
        final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(200, 1000, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));
        ServerSocket serverSocket = new ServerSocket(8888, 1000);

        Thread thread = new Thread(() -> {
            while(true) {
                synchronized (socketSet) {
                    Iterator<Socket> it = socketSet.iterator();
                    while(it.hasNext()) {
                        Socket socket = it.next();
                        if (socket.isConnected()) {
                            try {
                                if (!socket.isInputShutdown() && socket.getInputStream().available() > 0) {
                                    it.remove();
                                    threadPool.execute(new RequestHandler(socket));
                                }
                            } catch (IOException e) {
                                socketSet.remove(socket);
                                try {
                                    socket.close();
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                                e.printStackTrace();
                            }
                        }else{
                            socketSet.remove(socket);
                            try {
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        thread.start();


        while (true) {
            Socket clientSocket = serverSocket.accept();
            Utils.logDebug(clientSocket.getRemoteSocketAddress().toString());
            threadPool.execute(new RequestHandler(clientSocket));
        }
    }
}
