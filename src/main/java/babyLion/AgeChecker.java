package babyLion;

import java.util.Scanner;

public class AgeChecker {
        public static void checker(int age){
            if(age < 18){
                System.out.println("미성년자입니다");
            }else{
                System.out.println("성인입니다");
            }
        }
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        Scanner sc = new Scanner(System.in);
        System.out.println("나이를입력하세요");
        int age = sc.nextInt();
        checker(age);
    }
}
