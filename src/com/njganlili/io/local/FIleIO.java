package com.njganlili.io.local;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;

/**
 * @author njgan
 * @description 文件
 * @date 2022/2/15 8:32
 */
public class FIleIO {

    public static void main(String[] args) throws IOException {
        //字节
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\njgan\\Downloads\\hello.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.ISO_8859_1);
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\njgan\\Downloads\\helloWord.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
        //或者
        //直接是字符
        FileReader fileReader = new FileReader("C:\\Users\\njgan\\Downloads\\hello.txt");
        FileWriter fileWriter = new FileWriter("C:\\Users\\njgan\\Downloads\\fileWriterHelloWord.txt");
        //带buffer的
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\njgan\\Downloads\\hello.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\njgan\\Downloads\\fileBufferWriterHelloWord.txt"));

        fileWriter.write(fileReader.read());
        int n = 0;
        char[] chars = new char[100];

        while (
                (n = inputStreamReader.read(chars)) != -1
        ){
            outputStreamWriter.write(chars,0,n);
        }
        //字节输出
        while (
                (n = fileReader.read(chars)) != -1
        ){
            fileWriter.write(chars,0,n);
        }

        String line = null;
        //以为readLine()是读取到没有数据时就返回null(因为其它read方法当读到没有数据时返回-1)，而
        // 实际上readLine()是一个阻塞函数，当没有数据读取时，就一直会阻塞在那，而不是返回null；
        // 因为readLine()阻塞后，System.out.println(message)这句根本就不会执行到，
        // 所以在接收端就不会有东西输出。要想执行到System.out.println(message)，一个办法是发送完数据后就关掉流，
        // 这样readLine()结束阻塞状态，而能够得到正确的结果，但显然不能传一行就关一次数据流；
        // 另外一个办法是把System.out.println(message)放到while循环体内就可以。
        //readLine()只有在数据流发生异常或者另一端被close()掉时，才会返回null值。
        //如果不指定buffer大小，则readLine()使用的buffer有8192个字符。在达到buffer大小之前，只有遇到"/r"、"/n"、"/r/n"才会返回
        while ( (line = bufferedReader.readLine()) != null ){
            //换行符没了
            bufferedWriter.write(line);
        }

        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.flush();
        fileInputStream.close();
        fileOutputStream.close();
        inputStreamReader.close();
        outputStreamWriter.close();
    }
}
