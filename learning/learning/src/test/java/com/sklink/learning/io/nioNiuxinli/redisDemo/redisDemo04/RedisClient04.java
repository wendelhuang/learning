package com.sklink.learning.io.nioNiuxinli.redisDemo.redisDemo04;

import com.sklink.learning.io.nioNiuxinli.redisDemo.RedisClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

public class RedisClient04 implements RedisClient {

    private String ip;
    private int port;
    private Socket socket;

    public RedisClient04(String ip, int port) {
        this.ip = ip;
        this.port = port;
        try {
            this.socket = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String key) {
        try {
            OutputStream out = socket.getOutputStream();
            String cmd = "get|" + key;
            byte length = (byte) cmd.getBytes().length;
            byte[] data = new byte[cmd.getBytes().length+1];
            data[0] = length;
            for(int i = 0; i < cmd.getBytes().length; i++) {
                data[i+1] = (byte)cmd.charAt(i);
            }
            out.write(data);
            out.flush();


            InputStream in = socket.getInputStream();
            int len = in.read();
            byte[] buffer = new byte[len];

            int offset = 0;
            int bytesRead = in.read(buffer, 0, len);
            while(offset < len) {
                offset += bytesRead;
                bytesRead = in.read(buffer, offset, 512-offset);
            }

            String[] response = (new String(buffer, 0, offset)).split("\\|");
            return response[1];
        }catch (Exception e) {

        } finally{
        }
        return "";
    }

    public void set(String key, String value) {

        try {


            OutputStream out = socket.getOutputStream();
            String cmd = "set|" + key + "|" + value;
            byte length = (byte) cmd.getBytes().length;
            byte[] data = new byte[cmd.getBytes().length+1];
            data[0] = length;
            for(int i = 0; i < cmd.getBytes().length; i++) {
                data[i+1] = (byte)cmd.charAt(i);
            }
            out.write(data);
            out.flush();

            InputStream in = socket.getInputStream();
            int len = in.read();
            byte[] buffer = new byte[len];
            int offset = 0;
            int bytesRead = in.read(buffer);
            while(offset < len) {
                offset += bytesRead;
                bytesRead = in.read(buffer, offset, len-offset);
            }
            String bufString = new String(buffer,0,offset);

            System.out.println(bufString);

            String[] response = bufString.split("\\|");
            if(response[0].equals("2")) {
                throw new RuntimeException("bad command");
            }
        }catch (Exception e) {

        }finally {
        }
    }

    @Override
    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for(int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                RedisClient04 redisClient = new RedisClient04("127.0.0.1", 8888);
                for(int j = 0; j < 50; j++) {
                    Random random = new Random();
                    String key = String.valueOf(random.nextInt(1000));
                    String value = String.valueOf(random.nextInt(1000));
                    redisClient.set(key, value);
                    System.out.println(redisClient.get(key));
                }
                redisClient.close();
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
