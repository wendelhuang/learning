package com.sklink.learning.io.nioNiuxinli.redisDemo.redisDemo05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RedisServer05 {
    public static Map<String, String> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(200, 1000, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8888), 1000);
        Selector selector = Selector.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int num = selector.select();
            if (num == 0) {
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> it = selectionKeys.iterator();

            while(it.hasNext()) {
                SelectionKey key = it.next();
                it.remove();
                if (key.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(512));
                    System.out.println("new connection");
                }
                if (key.isReadable()) {
                    SocketChannel clientSocketChannel = (SocketChannel) key.channel();
                    if (!clientSocketChannel.isConnected()) {
                        clientSocketChannel.finishConnect();
                        key.cancel();
                        clientSocketChannel.close();
                        System.out.println("socket closed");
                        continue;
                    }
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    int len = clientSocketChannel.read(buffer);
                    Socket socket = clientSocketChannel.socket();
                    if (len == -1) {
                        clientSocketChannel.finishConnect();
                        key.cancel();
                        clientSocketChannel.close();
                        System.out.println("socket closed");
                    }else{
                        threadPool.execute(new RequestHandler(clientSocketChannel, buffer));
                    }
                }
            }

        }
    }
}
