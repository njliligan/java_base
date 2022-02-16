package com.njganlili.steam;

import com.njganlili.CommonUtil;
import com.njganlili.model.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author njgan
 * @description
 * @date 2022/2/13 10:51
 */
public class EndOperation {

    public static void main(String[] args){
//        1,匹配，聚合操作
//        allMatch：接收一个 Predicate 函数，当流中每个元素都符合该断言时才返回true，否则返回false
//        noneMatch：接收一个 Predicate 函数，当流中每个元素都不符合该断言时才返回true，否则返回false
//        anyMatch：接收一个 Predicate 函数，只要流中有一个元素满足该断言则返回true，否则返回false
//        findFirst：返回流中第一个元素
//        findAny：返回流中的任意元素
//        count：返回流中元素的总个数
//        max：返回流中元素最大值
//        min：返回流中元素最小值
        List<User> users = CommonUtil.getUserList();
        boolean sexAllExit = users.stream().allMatch(user -> {
            return Objects.nonNull(user.getUserSex());
        });
        boolean sexNoneExit = users.stream().noneMatch(user -> {
            return Objects.nonNull(user.getUserSex());
        });
        boolean sexAnyExit = users.stream().anyMatch(user -> {
            return Objects.nonNull(user.getUserSex());
        });

        Optional<User> firstUser = users.stream().findFirst();
        Optional<User> anyUser = users.stream().findAny();

        Long countUser = users.stream().count();

        Optional<Integer> maxAge = users.stream().max(((o1, o2) -> {
            if (o1.getUserAge() == o2.getUserAge()){
                return o1.getUserName().compareTo(o2.getUserName());
            }else {
                return o1.getUserAge().compareTo(o2.getUserAge());
            }
        })).map(User::getUserAge);

        Optional<Integer> minAge = users.stream().min(((o1, o2) -> {
            if (o1.getUserAge() == (o2.getUserAge())){
                return o1.getUserName().compareTo(o2.getUserName());
            }else {
                return o1.getUserAge().compareTo(o2.getUserAge());
            }
        })).map(User::getUserAge);
        if(minAge.isPresent()){
            System.out.println(minAge.get());
        }
//        2,规约操作
//        Optional<T> reduce(BinaryOperator<T> accumulator)：第一次执行时，accumulator函数的第一个参数为流中的第一个元素，第二个参数为流中元素的第二个元素；第二次执行时，第一个参数为第一次函数执行的结果，第二个参数为流中的第三个元素；依次类推。
//        T reduce(T identity, BinaryOperator<T> accumulator)：流程跟上面一样，只是第一次执行时，accumulator函数的第一个参数为identity，而第二个参数为流中的第一个元素。
//        <U> U reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner)：在串行流(stream)中，该方法跟第二个方法一样，即第三个参数combiner不会起作用。在并行流(parallelStream)中,我们知道流被fork join出多个线程进行执行，此时每个线程的执行流程就跟第二个方法reduce(identity,accumulator)一样，而第三个参数combiner函数，则是将每个线程的执行结果当成一个新的流，然后使用第一个方法reduce(accumulator)流程进行规约。
        //经过测试，当元素个数小于24时，并行时线程数等于元素个数，当大于等于24时，并行时线程数为16
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);

        Integer v = list.stream().reduce((x1, x2) -> x1 + x2).get();
        System.out.println(v);   // 300

        Integer v1 = list.stream().reduce(10, (x1, x2) -> x1 + x2);
        System.out.println(v1);  //310

        Integer v2 = list.stream().reduce(0,
                (x1, x2) -> {
                    System.out.println("stream accumulator: x1:" + x1 + "  x2:" + x2);
                    return x1 - x2;
                },
                (x1, x2) -> {
                    System.out.println("stream combiner: x1:" + x1 + "  x2:" + x2);
                    return x1 * x2;
                });
        System.out.println(v2); // -300

        Integer v3 = list.parallelStream().reduce(0,
                (x1, x2) -> {
                    System.out.println("parallelStream accumulator: x1:" + x1 + "  x2:" + x2);
                    return x1 - x2;
                },
                (x1, x2) -> {
                    System.out.println("parallelStream combiner: x1:" + x1 + "  x2:" + x2);
                    return x1 * x2;
                });
        System.out.println(v3); //197474048

        //收集操作
        //collect：接收一个Collector实例，将流中元素收集成另外一个数据结构。
        //        Collector<T, A, R> 是一个接口，有以下5个抽象方法：
        //            Supplier<A> supplier()：创建一个结果容器A
        //            BiConsumer<A, T> accumulator()：消费型接口，第一个参数为容器A，第二个参数为流中元素T。
        //            BinaryOperator<A> combiner()：函数接口，该参数的作用跟上一个方法(reduce)中的combiner参数一样，将并行流中各                                                                 个子进程的运行结果(accumulator函数操作后的容器A)进行合并。
        //            Function<A, R> finisher()：函数式接口，参数为：容器A，返回类型为：collect方法最终想要的结果R。
        //            Set<Characteristics> characteristics()：返回一个不可变的Set集合，用来表明该Collector的特征。有以下三个特征：
        //                CONCURRENT：表示此收集器支持并发。（官方文档还有其他描述，暂时没去探索，故不作过多翻译）
        //                UNORDERED：表示该收集操作不会保留流中元素原有的顺序。
        //                IDENTITY_FINISH：表示finisher参数只是标识而已，可忽略。
        //装成list
        List<Integer> ageList = users.stream().map(User::getUserAge).collect(Collectors.toList()); // [10, 20, 10]
        //转成set
        Set<Integer> ageSet = users.stream().map(User::getUserAge).collect(Collectors.toSet()); // [20, 10]
        //转成map,注:key不能相同，否则报错
        Map<String, Integer> stringStringMap = users.stream().collect(Collectors.toMap(User::getUserName, User::getUserAge)); // {cc=10, bb=20, aa=10}
        //返回自身
        Map<String, User> stringUserMap = users.stream().collect(Collectors.toMap(User::getUserName, Function.identity(),(key1, key2)->key2)); // {cc=10, bb=20, aa=10}
        //字符串分隔符连接
        String joinName = users.stream().map(User::getUserName).collect(Collectors.joining(",", "(", ")")); // (aa,bb,cc)
        //聚合操作
        //1.学生总数
        Long count = users.stream().collect(Collectors.counting()); // 3
        //2.最大年龄 (最小的minBy同理)
        Integer maxAges = users.stream().map(User::getUserAge).collect(Collectors.maxBy(Integer::compare)).get(); // 20
        //3.所有人的年龄
        Integer sumAge = users.stream().collect(Collectors.summingInt(User::getUserAge)); // 40
        //4.平均年龄
        Double averageAge = users.stream().collect(Collectors.averagingDouble(User::getUserAge)); // 13.333333333333334
        // 带上以上所有方法
        DoubleSummaryStatistics statistics = users.stream().collect(Collectors.summarizingDouble(User::getUserAge));
        System.out.println("count:" + statistics.getCount() + ",max:" + statistics.getMax() + ",sum:" + statistics.getSum() + ",average:" + statistics.getAverage());

        //分组
        Map<Integer, List<User>> ageMap = users.stream().collect(Collectors.groupingBy(User::getUserAge));
        //多重分组,先根据类型分再根据年龄分
        Map<String, Map<Integer, List<User>>> typeAgeMap = users.stream().collect(Collectors.groupingBy(User::getUserSex, Collectors.groupingBy(User::getUserAge)));
        //分区
//分成两部分，一部分大于10岁，一部分小于等于10岁
        Map<Boolean, List<User>> partMap = users.stream().collect(Collectors.partitioningBy(vv -> vv.getUserAge() > 10));
        //规约
        Integer allAge = users.stream().map(User::getUserAge).collect(Collectors.reducing(Integer::sum)).get(); //40


    }

}
