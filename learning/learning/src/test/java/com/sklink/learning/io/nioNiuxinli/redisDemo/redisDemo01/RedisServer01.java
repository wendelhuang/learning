package com.sklink.learning.io.nioNiuxinli.redisDemo.redisDemo01;

import com.sklink.learning.io.nioNiuxinli.redisDemo.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RedisServer01 {
    public static Map<String, String> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888, 10);

        byte[] buffer = new byte[512];
        while (true) {
            Socket clientSocket = null;
            clientSocket = serverSocket.accept();

            System.out.println(String.format("client address: [%s]", clientSocket.getRemoteSocketAddress().toString()));

            try {
                InputStream in = clientSocket.getInputStream();
                int bytesRead = in.read(buffer, 0, 512);
                int totalBytesRead = 0;
                while(bytesRead != -1) {
                    totalBytesRead += bytesRead;
                    bytesRead = in.read(buffer, totalBytesRead, 512-totalBytesRead);
                }

                byte[] response = Utils.processRequest(cache, buffer, totalBytesRead, false);
                Utils.logDebug(String.format("response: [%s]", new String(response)));

                OutputStream out = clientSocket.getOutputStream();
                out.write(response);
                out.flush();
                clientSocket.shutdownOutput();
            }catch (Exception e) {
                System.out.println("read or write date exception");
            }finally {
                clientSocket.close();
            }
        }
    }
}
