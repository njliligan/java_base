package com.njganlili.io.netio.nio.singleNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8001));
        socketChannel.configureBlocking(false);
        ByteBuffer recvBuff = ByteBuffer.allocate(1024);
        ByteBuffer sendBuff = ByteBuffer.allocate(1024);
        int request_times = 10;
        byte[] body = new byte[1024];
        int a = 1;
        while (true) {
            //设置日期格式
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String request = "Request time：" + df.format(new Date());
            sendBuff.putInt(request.length());
            sendBuff.put(request.getBytes());
            sendBuff.flip();
            socketChannel.write(sendBuff);

            // 用完就清理了, 虽然不会常用这个, 但习惯养成
            sendBuff.rewind();

            System.out.println("执行次数" + a++);
            // 没读到数据根本就不用处理
            int len = socketChannel.read(recvBuff);
            if (len == -1) {
                System.out.println("remote peer closed");
                socketChannel.close();
                break;
            }
            if (len > 0) {
                recvBuff.flip();
                // 有数据才处理, 而且 为了保证你的数据包处理逻辑不出错, 你还要验证长度
                // 当然要验证长度就要设计数据缓存的逻辑了
                if (len < Integer.BYTES) {
                    continue;
                }
                int bodyLen = recvBuff.getInt();
                if (len - Integer.BYTES < bodyLen) {
                    // 这里用 rewind 是图简单说明, 实际上不能直接 rewind 了事

                    // case 1. | length = 32 | data-length = 34 |
                    // rewind 丢失下一个数据包的 2 byte

                    // 这个是重点:
                    // 通常是做成状态机处理
                    // 然后要做好数据缓存

                    // state-wait-length
                    // state-read-length
                    // state-read-data
                    // state-wait-data
                    // state-finish
                    // jump to state-wait-length
                    recvBuff.rewind();
                    continue;
                }

                if (bodyLen > 0) {
                    recvBuff.get(body, 0, bodyLen);
                    System.out.println("Recv message from client: " +
                            new String(body, 0, bodyLen));
                    recvBuff.clear();
                }
                recvBuff.rewind();
            }

            Thread.sleep(2000);
        }
    }

}
