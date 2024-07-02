package ch05;

import java.util.Scanner;

public class FactorialCalculator {
    //재귀함수
    static int factorial(int num){
        if(num>0){
             return num*factorial(num-1);

        }else{
            return 1;
        }
    }

    //일반 for문으로 구현
    static void factorial1(int num){
        int result=1;
        for(int i=1;i<=num;i++){
            result*=i;
        }
        System.out.println(result);
    }



    public static void main(String[] args) {
        System.out.println("팩토리얼을 구할 숫자를 입력하세요");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(factorial(a));
        factorial1(5);
    }
}
