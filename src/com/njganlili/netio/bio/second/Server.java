package com.njganlili.netio.bio.second;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;

/**
 * BIO
 * telnet 127.0.0.1 8001
 */
public class Server {

    public static void main(String[] args) throws Exception {
        Socket socket = null;
        InetAddress address = Inet4Address.getByAddress(new byte[]{127, 0, 0, 1});
        ServerSocket serverSocket = new ServerSocket(8001, 50, address);
        ExecutorService executor =
                new ThreadPoolExecutor(
                        4,
                        20,
                        1000,
                        TimeUnit.SECONDS,
                        new LinkedBlockingQueue<Runnable>(),
                        new ThreadPoolExecutor.CallerRunsPolicy()
                );
        for ( ; ; ) {
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
            try {
                BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
                BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
                for (; ; ) {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("reading message.....");
                    byte[] buffer = new byte[1024];
                    // 先读出来, 这里的处理方式肯定不对, 不过只输入 ascii 字符也无所谓
                    int l = in.read(buffer);
                    String s = new String(buffer, 0, l);
                    System.out.printf("received message: %s\n", s);
                    // 输入 close 关闭链接
                    // 复制粘贴过去试试
                    if (s.contains("close")) {
                        out.write("bye~".getBytes(StandardCharsets.UTF_8));
                        out.flush();
                        out.close();
                        in.close();
                        break;
                    }
                    System.out.println(Thread.currentThread().getName()+"writing message.....");
                    System.out.println("writing message.....");
                    //out.write("\r\necho: ".getBytes(StandardCharsets.UTF_8));
                    //out.write("\r\n".getBytes(StandardCharsets.UTF_8));
                    //out.write("内容是:".getBytes(StandardCharsets.UTF_8));
                    //out.write(buffer, 0, l);
                    // 协议: 每个响应消息以 \r\n\r\n 结束
                    //out.write("\r\n\r\n".getBytes(StandardCharsets.UTF_8));
                    //out.write("\r\n".getBytes(StandardCharsets.UTF_8));
                    //out.flush();
                    System.out.println("finished....");
                    Thread.sleep(3000);
                }
                System.out.println("关闭接口");
                socket.close();
                System.out.println("socket已关闭");
            } catch (Exception e) {

            }
        }
    }
}
