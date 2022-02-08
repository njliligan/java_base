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
        int a = 1;
        while (true) {
            byte[] buffer = new byte[1024];
//            int l = bufferedInputStream.read(buffer);
//            String s = new String(buffer, 0, l);
//            System.out.printf("received message: %s\n", s);
            bufferedOutputStream.write("hello".getBytes(StandardCharsets.UTF_8), 0, "hello".getBytes(StandardCharsets.UTF_8).length);
            bufferedOutputStream.flush();
            if(a == 2){
                bufferedOutputStream.write("close".getBytes(StandardCharsets.UTF_8), 0, "hello".getBytes(StandardCharsets.UTF_8).length);
                bufferedOutputStream.flush();
            }
            a++;
//            a++;
//            if (a == 10) {
//                bufferedOutputStream.write("close".getBytes(StandardCharsets.UTF_8), 0, "close".getBytes(StandardCharsets.UTF_8).length);
//                bufferedOutputStream.flush();
//            }
            System.out.println();
            Thread.sleep(1000);
        }
    }

}
