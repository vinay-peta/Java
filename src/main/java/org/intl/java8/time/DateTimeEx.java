package org.intl.java8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoField;

public class DateTimeEx {

	public static void main(String[] a){
		date();
		time();
		dateAndTime();
		period();
	}
	
	public static void date(){
		LocalDate date = LocalDate.of(2018, 06, 02);
		date = LocalDate.now();
		System.out.println(date.getMonth()+"-"+date.getDayOfMonth()+"-"+date.get(ChronoField.YEAR));
	}
	
	public static void time(){
		LocalTime time = LocalTime.now();
		System.out.println(time.getHour()+"-"+time.getMinute()+"-"+time.getSecond());
	}
	
	public static void dateAndTime(){
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt.getMonth()+"-"+dt.getDayOfMonth()+"-"+dt.getYear()+"-"+dt.getHour()+"-"+dt.getMinute()+"-"+dt.getSecond());
	}
	
	public static void period(){
		Period dur = Period.between(LocalDate.of(2018, 1, 1),LocalDate.of(2019,1,1));
		System.out.println(dur.getYears());
	}
}
