package com.example.JR0824.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CheckoutUtils {

    /**
     * Get the formatter for parsing and displaying Dates in the desired format
     * @return
     */
    public static SimpleDateFormat getDateFormatter(){
        return new SimpleDateFormat("M/dd/yy");
    }

    /**
     * Get the formatted for displaying costs in the desired format
     * @return
     */
    public static NumberFormat getCurrencyFormatter(){
        return NumberFormat.getCurrencyInstance();
    }

    /**
     * Determine if a given date (in calendar format) is part of a weekend. False means it is a weekday
     * @param calendar
     * @return
     */
    public static Boolean calendarIsWeekend(Calendar calendar){
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
    }

    /**
     * Determine if a given date (in calendar format) is a holiday
     * @param calendar
     * @return
     */
    public static Boolean calendarIsHoliday(Calendar calendar){
        return calendarIsLaborDay(calendar) || calendarIsFourthOfJulyObserved(calendar);
    }

    /**
     * Determine if a given date is Labor Day. Labor Day is defined as the first Monday in September
     * @param calendar
     * @return
     */
    public static Boolean calendarIsLaborDay(Calendar calendar){
        return calendar.get(Calendar.MONTH) == Calendar.SEPTEMBER && calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY && calendar.get(Calendar.DAY_OF_MONTH) < 8;
    }

    /**
     * Determine if a given date is USA's Independence Day, or the day it is observed. Independence Day is generally
     * July 4th, but on years when July 4th is on a Saturday it is observed on the 3rd, and on years when July 4th is
     * on a Sunday it is observed on the 5th.
     * @param calendar
     * @return
     */
    public static Boolean calendarIsFourthOfJulyObserved(Calendar calendar){
        return calendar.get(Calendar.MONTH) == Calendar.JULY &&
                (
                        (calendar.get(Calendar.DAY_OF_MONTH) == 4 && !calendarIsWeekend(calendar)) ||
                        (calendar.get(Calendar.DAY_OF_MONTH) == 3 && calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) ||
                        (calendar.get(Calendar.DAY_OF_MONTH) == 5 && calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
                );

    }

    /**
     * Rounds doubles to two decimal places to use as currency values.
     * @param value
     * @return
     */
    public static double roundToTwoDecimalPlaces(double value){
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
