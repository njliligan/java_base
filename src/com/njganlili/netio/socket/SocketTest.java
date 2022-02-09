package com.njganlili.netio.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * BIO
 * telnet 127.0.0.1 8001
 */
public class SocketTest {
    public static void main(String[] args) throws Exception {
        Socket socket = null;
        InetAddress address = Inet4Address.getByAddress(new byte[]{127, 0, 0, 1});
        ServerSocket serverSocket = new ServerSocket(8001, 50, address);
        for (; ; ) {
            System.out.println("wait connect.....");
            socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("reading message.....");
            System.out.println(dataInputStream.readUTF());
            System.out.println("writing message.....");
            dataOutputStream.write("hello , this is response".getBytes(StandardCharsets.UTF_8));
            dataOutputStream.flush();
            System.out.println("finished....");
            //socket.close();
        }
    }
}
