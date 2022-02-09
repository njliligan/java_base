package com.njganlili.netio.bio.second;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket client = new Socket("127.0.0.1", 8001);

        client.setSendBufferSize(5);
        client.setTcpNoDelay(true);

        byte[] bytes = new byte[1024];
        OutputStream out = client.getOutputStream();
        InputStream in = client.getInputStream();
        byte[] buffer = new byte[1024];
        int a = 1;
        while (true) {
            out.write("hello".getBytes(StandardCharsets.UTF_8));
            out.flush();
            //网卡和程序异步，flush只是写出缓冲区，不一定发送出去了。
            if (a == 5) {
                out.write("close".getBytes(StandardCharsets.UTF_8));
                out.flush();
            }
            a++;
            int l = in.read(buffer);
            String s = new String(buffer, 0, l);
            System.out.printf("received message: %s\n", s);
            if("bye~".equals(s)){
                client.close();
                break;
            }
            Thread.sleep(2000);
        }
    }

}
