package ch10.utilExam;

import java.util.Calendar;
import java.util.Date;

public class DateExam {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getDate());

        Calendar calendar=Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(calendar.get(Calendar.MONTH)+1);
    }
}
