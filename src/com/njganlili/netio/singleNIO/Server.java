package com.njganlili.netio.singleNIO;

import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * BIO
 * telnet 127.0.0.1 8001
 */
public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 8001));
        serverSocketChannel.socket().setReuseAddress(true);
        serverSocketChannel.configureBlocking(false);
        ByteBuffer recvBuff = ByteBuffer.allocate(1024);
        ByteBuffer sendBuff = ByteBuffer.allocate(1024);
        byte[] body = new byte[1024];
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.println("收到连接..........");
                socketChannel.read(recvBuff);
                int bodyLen = recvBuff.getInt();
                if (bodyLen > 0) {
                    recvBuff.get(body, 0, bodyLen);
                    System.out.println("Recv message from client: " +
                            new String(body, 0, bodyLen));
                    recvBuff.clear();
                }
                //设置日期格式
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String resp = "The server time : " + df.format(new Date());

                byte[] respBytes = resp.getBytes(StandardCharsets.UTF_8);
                System.out.printf("message package data length: %d, totoal package length: %d%n",
                        respBytes.length,
                        respBytes.length + Integer.BYTES);

                sendBuff.putInt(respBytes.length);
                sendBuff.put(respBytes);

                sendBuff.flip();
                socketChannel.write(sendBuff);

                recvBuff.rewind();
                sendBuff.rewind();
                System.out.println("结束");
            }
        }
    }
}
