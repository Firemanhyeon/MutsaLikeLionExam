package ch01;

import java.util.Scanner;

public class Multi99Table {
    public static void  gugudan(){
        for(int i=1;i<10;i++){
            for(int j=1;j<10;j++){
                System.out.printf("%3d",i*j);///%3d 는 세자리수까지 입력할수 있는 정수

            }
            System.out.println();
        }
    }

    public static void triangle(int a){
        for(int i=0; i<a;i++){
            for(int j=0; j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void triangle1(int b){
        for(int i = 0; i<b;i++){
            for(int j=0;j<b-i; j++){
                System.out.print(" ");
            }
            for(int k=0;k<2*i+1;k++){
                System.out.print("*");
            }


            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //구구단메소드
        gugudan();

        //삼각형
        System.out.println("삼각형 단수 입력");
        int a = sc.nextInt();
        triangle(a);

        //이등변삼각형

        System.out.println("이등변삼각형 단수");
        int b = sc.nextInt();
        triangle1(b);

    }
}
