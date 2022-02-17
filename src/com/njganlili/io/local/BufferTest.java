package com.njganlili.io.local;

import java.io.BufferedWriter;
import java.nio.Buffer;
import java.nio.IntBuffer;

/**
 * @author njgan
 * @description
 * @date 2022/2/17 19:44
 */
public class BufferTest {

    Buffer buffer = IntBuffer.allocate(10);
//    方法
//    allocate() - 初始化一块缓冲区
//    put() - 向缓冲区写入数据
//    get() - 向缓冲区读数据
//    filp() - 将缓冲区的读写模式转换
//    clear() - 这个并不是把缓冲区里的数据清除，而是利用后来写入的数据来覆盖原来写入的数据，以达到类似清除了老的数据的效果
//    compact() - 从读数据切换到写模式，数据不会被清空，会将所有未读的数据copy到缓冲区头部，后续写数据不会覆盖，而是在这些数据之后写数据
//    mark() - 对position做出标记，配合reset使用
//    reset() - 将position置为标记值

//    核心属性
//    capacity - 缓冲区大小，缓冲区一旦创建出来以后，这个属性就不会再变化了
//    position - 读写数据的定位指针，用来标识当前读取到了哪一个位置。
//    limit - 读写的边界，用于限制指针的最大指向位置。当指针走到边界上的时候就要停住，否则就会抛出BufferUnderflowException

//    一般使用
//    写入数据到Buffer
//    调用flip()方法改变读写模式
//    从Buffer中读取数据
//    调用clear()方法或者compact()方法

//    在缓冲区刚初始化出来的时候，position指向的是数组的第一个位置，limit和数组的容量一样
//    向缓冲区中每写入一个数据，指针就会后移一位
//    当调用了flip()方法后，position又会重新指向数组的第一个位置，而limit会指向原来的position的位置。
//    然后再调用get方法的时候，每调用读取一个数据，position就会向后移动一位,直到position到达了limit的位置。实际上intBuffer.hasRemaining()方法就是判断position < limit。

//    ByteBuffer
//　　 ShortBuffer
//　　 IntBuffer
//　　 CharBuffer
//　　 FloatBuffer
//　　 DoubleBuffer
//　　 LongBuffer
    //BufferedWriter bufferedWriter = new BufferedWriter();
    //
    StringBuffer stringBuffer = new StringBuffer();
    //线程不安全
    StringBuilder stringBuilder = new StringBuilder();

    //BufferedWriter bufferedWriter =new BufferedWriter();



}
