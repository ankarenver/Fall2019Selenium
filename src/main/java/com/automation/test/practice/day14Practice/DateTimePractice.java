package com.automation.test.practice.day14Practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimePractice {
    public static void main(String[] args) {

        DateTimeFormatter currentYear =  DateTimeFormatter.ofPattern("yyyy");
        DateTimeFormatter currentMonth =  DateTimeFormatter.ofPattern("MMMM");
        DateTimeFormatter currentDay =  DateTimeFormatter.ofPattern("dd");
        LocalDateTime now = LocalDateTime.now();

        System.out.println(currentYear.format(now));
        System.out.println(currentMonth.format(now));
        System.out.println(currentDay.format(now));

    }
}
