package part12;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;

/**
 * Created by niceyuanze on 17-4-26.
 */
public class Main {
    public static void main(String[] args) {
        LocalTime time1 = LocalTime.of(13,11,11);
        LocalTime time2 = LocalTime.of(15, 11, 11);
        Duration d1 = Duration.between(time1, time2);
        System.out.println(d1);

        Period tenDays = Period.between(LocalDate.of(2014,3,8),
                LocalDate.of(2014,3,18));
        System.out.println(tenDays);


        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes1 = Duration.of(3, ChronoUnit.MINUTES);

        Period tenDays1 = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2,6,1);
//        LocalDate date = LocalDate.of(2014, 3, 8);
//
//        int year = date.getYear();
//        Month month = date.getMonth();
//        int day = date.getDayOfMonth();
//        DayOfWeek dow = date.getDayOfWeek();
//        int len = date.lengthOfMonth();
//        boolean leap = date.isLeapYear();
//
//        System.out.println( date.getYear());
//        System.out.println( date.getMonth());
//        System.out.println( date.getDayOfMonth());
//        System.out.println( date.getDayOfWeek());
//        System.out.println( date.lengthOfMonth());
//        System.out.println( date.isLeapYear());
//
//        day = date.get(ChronoField.DAY_OF_WEEK);
//        year = date.get(ChronoField.YEAR);
//        int month1 = date.get(ChronoField.MONTH_OF_YEAR);
//        day = date.get(ChronoField.DAY_OF_MONTH);





    }
}
