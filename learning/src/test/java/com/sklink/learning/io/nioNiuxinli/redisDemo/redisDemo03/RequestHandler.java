package com.sklink.learning.io.nioNiuxinli.redisDemo.redisDemo03;

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
        try {
            while (true) {
                InputStream in = clientSocket.getInputStream();
                int len = in.read();
                if (len == -1) {
                    System.out.println("socket closed by client");
                    return;
                }
                byte[] buffer = new byte[len];
                int bytesRead = in.read(buffer, 0, len);
                int totalBytesRead = 0;
                while(totalBytesRead < len) {
                    totalBytesRead += bytesRead;
                    System.out.println(String.format("totalBytesRead: %d, len: %d", totalBytesRead, len));
                    if (totalBytesRead < len) {
                        bytesRead = in.read(buffer, totalBytesRead, len-totalBytesRead);
                    }
                }

                byte[] response = Utils.processRequest(RedisServer03.cache, buffer, totalBytesRead, true);
                Utils.logDebug(String.format("response: [%s]", new String(response)));

                OutputStream out = clientSocket.getOutputStream();
                out.write(response);
                out.flush();
            }
        }catch (Exception e) {
            e.printStackTrace();
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
