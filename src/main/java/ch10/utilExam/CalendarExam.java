package ch10.utilExam;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarExam {
    public static void printCalendar(int year , int month){
        //달력만들기
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, 1);
        //해당 월의 첫 요일
        int firstDay = calendar.get(Calendar.DAY_OF_WEEK);
        //해당 월의 마지막요일
        int lastDay = calendar.getActualMaximum(Calendar.DATE);

        System.out.println("해당월의첫요일:" +firstDay);
        System.out.println("해당월의 마지막요일"+lastDay);
        System.out.println("\t\t"+calendar.get(Calendar.YEAR)+"년"+(calendar.get(Calendar.MONTH)+1)+"월");
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        for(int i=1;i<firstDay;i++){
            System.out.print("\t");
        }
        for(int i=1;i<=lastDay;i++){
            System.out.print(i+"\t");
            if(firstDay%7==0){
                System.out.println();
            }
            firstDay++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("년도를 입력하세요");
        int year = sc.nextInt();
        System.out.println("월을 입력하세요");
        int month = sc.nextInt();
        printCalendar(year, month);
    }
}
