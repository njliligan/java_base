package com.njganlili.netio.bio;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO
 * telnet 127.0.0.1 8001
 */
public class BIOServerTest {

    public static void main(String[] args) throws Exception {
        Socket socket = null;
        InetAddress address = Inet4Address.getByAddress(new byte[]{127, 0, 0, 1});
        ServerSocket serverSocket = new ServerSocket(8001, 50, address);

        // 什么沙雕 lint
        ExecutorService executor = Executors.newCachedThreadPool();

        for (; ; ) {
            System.out.println("wait connect.....");
            socket = serverSocket.accept();
            EchoConnection echoConnection = new EchoConnection(socket);
            executor.execute(echoConnection);
        }
    }
    static class EchoConnection implements Runnable {

        private final Socket socket;

        public EchoConnection(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {            // 我没法批量选文本, 你自己挪代码
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                byte[] buffer = new byte[1024];
                for (;;) {
                    System.out.println("reading message.....");
                    // 先读出来, 这里的处理方式肯定不对, 不过只输入 ascii 字符也无所谓
                    int l = in.read(buffer);
                    String s = new String(buffer, 0, l);
                    System.out.printf("received message: %s\n", s);

                    // 输入 close 关闭链接
                    // 复制粘贴过去试试
                    if ("close".equals(s)) {
                        out.write("\r\nbye~\r\n".getBytes(StandardCharsets.UTF_8));
                        out.close();
                        break;
                    }

                    System.out.println("writing message.....");
                    out.write("\r\necho: ".getBytes(StandardCharsets.UTF_8));
                    out.write(buffer, 0, l);
                    // 协议: 每个响应消息以 \r\n\r\n 结束
                    out.write("\r\n\r\n".getBytes(StandardCharsets.UTF_8));

                    out.flush();
                    System.out.println("finished....");
                }

                socket.close();
            } catch (Exception e) {

            }
        }
    }
}
