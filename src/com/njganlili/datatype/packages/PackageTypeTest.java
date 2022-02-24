package com.njganlili.datatype.packages;

/**
 * @author njgan
 * @description 主要测试缓存
 * @date 2022/2/23 14:27
 */
public class PackageTypeTest {

    public static void main(String[] args) {
        //内部维护了一个-128 -> 127的缓存
        //所有整数类型的类都有类似的缓存机制:除了Float和Double,Boolean不是整数也除外
        //Byte，Short，Long 的缓存池范围默认都是: -128 到 127。可以看出，Byte的所有值都在缓存区中，用它生成的相同值对象都是相等的。
        //所有整型（Byte，Short，Long）的比较规律与Integer是一样的。
        //同时Character 对象也有CharacterCache 缓存 池，范围是 0 到 127。
        //除了 Integer 可以通过参数改变范围外，其它的都不行。
        int s = 127;
        int m = 127;
        //这种方式比下面的好很多，直接从缓存里面拿。
        Integer a = Integer.valueOf(127);
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
        Character characterOne = 127;
        Character characterTwo = 127;
        System.out.println(characterOne == characterTwo);

        //最后发现Integer的127等于了int的127
        System.out.println(s == a);
    }

}
