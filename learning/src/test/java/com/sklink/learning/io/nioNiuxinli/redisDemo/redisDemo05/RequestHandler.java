package com.sklink.learning.io.nioNiuxinli.redisDemo.redisDemo05;

import com.sklink.learning.io.nioNiuxinli.redisDemo.Utils;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class RequestHandler implements Runnable {
    private SocketChannel channel;
    private ByteBuffer buffer;

    public RequestHandler(SocketChannel channel, Object buffer) {
        this.channel = channel;
        this.buffer = (ByteBuffer) buffer;
    }
    @Override
    public void run() {
        try {
            int position = buffer.position();
            buffer.flip();
            int len = buffer.get();
            if (len > position + 1) {
                buffer.position(position);
                buffer.limit(buffer.capacity());
                return;
            }
            byte[] data = new byte[len];
            buffer.get(data, 0, len);

            byte[] response = Utils.processRequest(RedisServer05.cache, data, len, true);
            Utils.logDebug(String.format("response: %s", new String(response)));

            buffer.clear();

            buffer.put(response);
            buffer.flip();
            channel.write(buffer);
            buffer.clear();

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("read or write date exception");
        }finally {
        }
    }
}
