package com.njganlili.dateTime;

import javax.swing.text.DateFormatter;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author njgan
 * @description 时间类
 * @date 2022/2/23 13:49
 */
public class DateTimeTest {

    public static  void main(String[] args){
        //初始化
        LocalDate localDate = LocalDate.now();
        LocalDate localDateOf = LocalDate.of(2019,12,21);
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTimeOf = LocalDateTime.of(2019,12,21,20,22,21);
        Instant instant = Instant.now();
        Clock clock = Clock.systemUTC();
        //格式化
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("------------------------------");
        System.out.println(dateFormatter.format(localDateTime));
        System.out.println(localDateOf);
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getSecond());
        System.out.println("----------------------------------");
        System.out.println("减法");
        System.out.println(localDateTime.minusDays(2));
        System.out.println(localDateTime.minusHours(3));
        System.out.println(localDateTime.minus(2, ChronoUnit.HOURS));
        System.out.println("加法");
        System.out.println(localDateTime.plusDays(2));
        System.out.println(localDateTime.plusHours(4));
        System.out.println(localDateTime.plus(2, ChronoUnit.HOURS));
        System.out.println("--------------------------------------");
        //取得日期
        System.out.println(localDate.isAfter(localDateOf));
        System.out.println(localDate.isBefore(localDateOf));
        System.out.println(localDate.isEqual(localDateOf));
        System.out.println(localDate.atStartOfDay());
        System.out.println(clock.getZone());
        System.out.println(clock.instant());
        System.out.println(LocalDateTime.now(clock));
        //是否是闰年
        System.out.println(localDate.isLeapYear());
        //反序列化
        System.out.println(LocalDateTime.parse(dateFormatter.format(localDateTime),dateFormatter));
        //计算时间间隔
        System.out.println("duration--------------------------------------------------------");
        Duration duration = Duration.between(localDateTimeOf, localDateTime);
        System.out.println(duration.toString());
        System.out.println(duration.toDays());
        //
        System.out.println("period ---------------------------------------------------------");
        Period period = Period.between(localDateOf, localDate);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        System.out.println(period);
    }

}
