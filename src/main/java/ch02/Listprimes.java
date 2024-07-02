package ch02;

import java.util.Scanner;

public class Listprimes {
    //입력한 숫자 이하의 소수 구하기
    public static void primes(int num){
        for(int i =1 ; i<=num; i+=2){
           boolean isPrime = true;
           for (int j =2 ; j<i;j++){
               if(i%j==0){
                   isPrime=false;
                   break;
               }
           }
           if(isPrime){
               System.out.println(i);
           }
       }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력하세요");
        int num  = sc.nextInt();
        primes(num);
    }
}
