package com.njganlili.io.netio.bio.chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//这是一个客户端
public class SingleThreadClient {
    public static void main(String[] args) {
        String ip="127.0.0.1";
        int port=4406;
        try {
            Socket socket=new Socket(ip,port);
            //发送消息
            OutputStream out = socket.getOutputStream();
            PrintStream printStream=new PrintStream(out);
            printStream.println("嗨，你好");
            printStream.flush();
            //接收消息
            InputStream in = socket.getInputStream();
            Scanner scanner = new Scanner(in);
            System.out.println("服务端>" + scanner.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

