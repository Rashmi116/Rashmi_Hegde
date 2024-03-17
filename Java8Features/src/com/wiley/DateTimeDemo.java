package com.wiley;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;

public class DateTimeDemo {

	public static void main(String[] args) {
		LocalDate today=LocalDate.now();
        System.out.println(today);
        LocalDateTime date2=LocalDateTime.now();
        System.out.println(date2);
        LocalDate bd=LocalDate.of(2002, Month.MARCH, 11);
        System.out.println(bd);
        Period p=Period.between(bd, today);
        System.out.println(p.getYears()+"years "+p.getMonths()+"months "+p.getDays());
        
        System.out.println("Date After 10 days: "+today.plusDays(10));
        System.out.println("Date before 10 days: "+today.minusDays(10));
        System.out.println("Date After 3 weeks: "+today.plusWeeks(3));
        System.out.println("Date After 3 weeks: "+today.minusWeeks(3));
        System.out.println("Date After 20 months: "+today.plusMonths(20));
        System.out.println("Date After 20 months: "+today.minusMonths(20));
        System.out.println("Date After 2 Years: "+today.plusYears(2));
        
        ZoneId america=ZoneId.of("Australia/Sydney");
        LocalDateTime time_in_america=LocalDateTime.now(america);
        System.out.println(time_in_america);
	}

}
