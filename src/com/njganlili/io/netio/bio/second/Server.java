package com.njganlili.io.netio.bio.second;

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
            socket.setReceiveBufferSize(5);
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
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                byte[] buffer = new byte[1024];
                for (; ; ) {
                    // 先读出来, 这里的处理方式肯定不对, 不过只输入 ascii 字符也无所谓
                    int l = in.read(buffer);
                    String s = new String(buffer, 0, l);
                    System.out.printf("received message: %s\n", s);
                    if ("close".equals(s)) {
                        out.write("bye~".getBytes(StandardCharsets.UTF_8));
                        out.flush();
                        Thread.sleep(2000);
                        break;
                    }else {
                        out.write("recived...".getBytes(StandardCharsets.UTF_8));
                    }
                }
                System.out.println("关闭接口");
                socket.close();
                System.out.println("socket已关闭");
            } catch (Exception e) {

            }
        }
    }
}
