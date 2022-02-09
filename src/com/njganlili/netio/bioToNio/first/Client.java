package com.njganlili.netio.bioToNio.first;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8001));
        socketChannel.configureBlocking(false);
        ByteBuffer recvBuff = ByteBuffer.allocate(1024);
        ByteBuffer sendBuff = ByteBuffer.allocate(1024);
        int request_times = 10;
        byte[] body = new byte[1024];
        while (true){
            //设置日期格式
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String resp = "The server time : " + df.format(new Date());
            sendBuff.put(resp.getBytes());
            socketChannel.write(sendBuff);
            sendBuff.rewind();

            int bodyLen = recvBuff.getInt();
            if (bodyLen>0){
                recvBuff.get(body, 0, bodyLen);
                System.out.println("Recv message from client: " +
                        new String(body, 0, bodyLen));
                recvBuff.clear();
            }
            Thread.sleep(2000);
        }
    }

}
