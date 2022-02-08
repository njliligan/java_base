package com.njganlili.netio.bio;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BIOClientTest {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 8001);
        OutputStream out = client.getOutputStream();
        Scanner inScanner = new Scanner(client.getInputStream());
        //inScanner.useDelimiter("\r\n\r\n"); // 修改了换行符, 服务端需要进行修改
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();

            out.write(s.getBytes(StandardCharsets.UTF_8));

            String response = inScanner.nextLine();
            System.out.println("服务器响应： " + response);

            if ("close".equals(s)) {
                client.close();
                break;
            }
        }
    }

}
