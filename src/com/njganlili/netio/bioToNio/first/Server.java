package com.njganlili.netio.bioToNio.first;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.concurrent.*;

/**
 * BIO
 * telnet 127.0.0.1 8001
 */
public class Server {

    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = null;
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open().bind(new InetSocketAddress("127.0.0.1", 8001));
        serverSocketChannel.configureBlocking(false);
        ByteBuffer recvBuff = ByteBuffer.allocate(1024);
        ByteBuffer sendBuff = ByteBuffer.allocate(1024);
        byte[] body = new byte[1024];
        int request_times = 10;
        while (true){
            socketChannel = serverSocketChannel.accept();
            if(socketChannel == null){
                System.out.println("waiting..........");
                Thread.sleep(1000);
            }else {
                int bodyLen = recvBuff.getInt();
                if (bodyLen >0){
                    recvBuff.get(body, 0, bodyLen);
                    System.out.println("Recv message from client: " +
                            new String(body, 0, bodyLen));
                    recvBuff.clear();
                }
                //设置日期格式
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String resp = "The server time : " + df.format(new Date());
                sendBuff.put(resp.getBytes());
                sendBuff.flip();
                socketChannel.write(sendBuff);
                sendBuff.rewind();
            }
        }
    }
}
