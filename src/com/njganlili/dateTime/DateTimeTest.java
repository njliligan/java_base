package com.njganlili.dateTime;

import javax.swing.text.DateFormatter;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author njgan
 * @description
 * @date 2022/2/23 13:49
 */
public class DateTimeTest {

    public static  void main(String[] args){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE;
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        Instant instant = Instant.now();
        Clock clock = Clock.systemUTC();
        //------------------------------
        System.out.println(dateFormatter.format(localDateTime));
        localDateTime.getDayOfMonth();
        localDateTime.getDayOfWeek();
        localDateTime.getDayOfYear();
//        localDateTime.
    }

}
