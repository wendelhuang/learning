package com.sklink.learning.io.nioNiuxinli.redisDemo.redisDemo02;

import com.sklink.learning.io.nioNiuxinli.redisDemo.RedisClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

public class RedisClient02 implements RedisClient {

    private String ip;
    private int port;

    public RedisClient02(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String get(String key) {
        Socket socket = null;
        try {
            socket = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            OutputStream out = socket.getOutputStream();
            out.write(("get|" + key).getBytes());
            socket.shutdownOutput();

            InputStream in = socket.getInputStream();
            byte[] buffer = new byte[512];

            int offset = 0;
            int bytesRead = in.read(buffer);
            while(bytesRead != -1) {
                offset += bytesRead;
                bytesRead = in.read(buffer, offset, 512-offset);
            }

            String[] response = (new String(buffer, 0, offset)).split("\\|");
            return response[1];
        }catch (Exception e) {

        } finally{
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public void set(String key, String value) {
        Socket socket = null;

        try {
            socket = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            OutputStream out = socket.getOutputStream();
            out.write(("set|" + key + "|" + value).getBytes());
            out.flush();
            socket.shutdownOutput();

            InputStream in = socket.getInputStream();
            byte[] buffer = new byte[512];
            int offset = 0;
            int bytesRead = in.read(buffer);
            while(bytesRead != -1) {
                offset += bytesRead;
                bytesRead = in.read(buffer, offset, 512-offset);
            }
            String bufString = new String(buffer,0,offset);

            System.out.println(bufString);

            String[] response = bufString.split("\\|");
            if(response[0].equals("2")) {
                throw new RuntimeException("bad command");
            }
        }catch (Exception e) {

        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() {

    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for(int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                RedisClient02 redisClient = new RedisClient02("127.0.0.1", 8888);
                for(int j = 0; j < 300; j++) {
                    Random random = new Random();
                    String key = String.valueOf(random.nextInt(1000));
                    String value = String.valueOf(random.nextInt(1000));
                    redisClient.set(key, value);
                    System.out.println(redisClient.get(key));
                }
            });
            threads[i].start();
        }

        for(int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
