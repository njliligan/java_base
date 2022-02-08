package com.njganlili.netio.bio.second;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket client = new Socket("127.0.0.1", 8001);
        byte[] bytes = new byte[1024];
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(client.getOutputStream());
        BufferedInputStream bufferedInputStream = new BufferedInputStream(client.getInputStream());
        while (true) {
            bufferedOutputStream.write("hello".getBytes(StandardCharsets.UTF_8), 0, "hello".getBytes(StandardCharsets.UTF_8).length);
            bufferedOutputStream.flush();
//            int r = -1;
//            while ((r = bufferedInputStream.read())!= -1) {
//                System.out.println(Byte.valueOf((byte) r));
//            }
            System.out.println();
            Thread.sleep(1000);
        }
    }

}
