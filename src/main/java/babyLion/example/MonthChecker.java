package babyLion.example;

import java.util.Scanner;

public class MonthChecker {

    public static void monthChecker(int month){
            switch (month){
                case 3,4,5:
                    System.out.println("봄입니다");
                    break;
                case 6,7,8,9:
                    System.out.println("여름입니다");
                    break;
                case 10,11:
                    System.out.println("가을입니다");
                    break;
                case 12 ,1 ,2 :
                    System.out.println("겨울입니다");
                    break;
            }
    }

    public static void main(String[] args) {
        while(true){

            System.out.println("현재 월을 입력하세요 프로그램을 종료하려면 0번을 누르세요");
            Scanner sc = new Scanner(System.in);
            int month = sc.nextInt();
            if(month==0){
                break;
            }else{
                monthChecker(month);
            }
        }
    }
}
