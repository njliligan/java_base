package com.njganlili.io.netio.bio.chat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadServer {
    public static void main(String[] args) {
        int port=4406;
        try {
            //创建服务端
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务端启动，运行在"+serverSocket.getLocalSocketAddress());
            //等待客户端连接
            Socket clientSocket=serverSocket.accept();//此时阻塞，等待客户端连接  直到客户端连接服务端返回Socket
            System.out.println("有新用户连接，客户名为"+clientSocket.getPort());
            //数据接收和发送
            //1.接收
            InputStream in = clientSocket.getInputStream();
            Scanner scanner = new Scanner(in);
            System.out.println("客户端>" + scanner.nextLine());
            //2.发送
            OutputStream out = clientSocket.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            printStream.println("你好，我是客户端==");
            printStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


