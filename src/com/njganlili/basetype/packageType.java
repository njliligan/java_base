package com.njganlili.basetype;

/**
 * @author njgan
 * @description
 * @date 2022/2/23 14:27
 */
public class packageType {

    public static void main(String[] args) {
        //Integer 内部维护了一个-128 -> 127的缓存
        //所有整数类型的类都有类似的缓存机制:
        //有 ByteCache 用于缓存 Byte 对象
        //有 ShortCache 用于缓存 Short 对象
        //有 LongCache 用于缓存 Long 对象
        //Byte，Short，Long 的缓存池范围默认都是: -128 到 127。可以看出，Byte的所有值都在缓存区中，用它生成的相同值对象都是相等的。
        //所有整型（Byte，Short，Long）的比较规律与Integer是一样的。
        //同时Character 对象也有CharacterCache 缓存 池，范围是 0 到 127。
        //除了 Integer 可以通过参数改变范围外，其它的都不行。
        int s = 127;
        int m = 127;
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);
        Byte c = Byte.parseByte("127");
        Byte d = Byte.parseByte("127");
        System.out.println(c == d);
        Short e = 127;
        Short f = 127;
        System.out.println(e == f);
        Long g = 127L;
        Long h = 127L;
        System.out.println(g == h);
    }

}
