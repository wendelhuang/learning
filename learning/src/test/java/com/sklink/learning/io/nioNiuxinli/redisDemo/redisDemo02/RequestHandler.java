package com.sklink.learning.io.nioNiuxinli.redisDemo.redisDemo02;

import com.sklink.learning.io.nioNiuxinli.redisDemo.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RequestHandler implements Runnable {
    private Socket clientSocket;

    public RequestHandler(Socket socket) {
        this.clientSocket = socket;
    }
    @Override
    public void run() {
        byte[] buffer = new byte[512];
        try {
            InputStream in = clientSocket.getInputStream();
            int bytesRead = in.read(buffer, 0, 512);
            int totalBytesRead = 0;
            while(bytesRead != -1) {
                totalBytesRead += bytesRead;
                bytesRead = in.read(buffer, totalBytesRead, 512-totalBytesRead);
            }

            byte[] response = Utils.processRequest(RedisServer02.cache, buffer, totalBytesRead, false);
            Utils.logDebug(String.format("response: [%s]", new String(response)));

            OutputStream out = clientSocket.getOutputStream();
            out.write(response);
            out.flush();
            clientSocket.shutdownOutput();
        }catch (Exception e) {
            System.out.println("read or write date exception");
        }finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
