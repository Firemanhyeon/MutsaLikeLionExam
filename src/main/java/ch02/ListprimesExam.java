package ch02;

import java.util.Scanner;

public class ListprimesExam {
    public static void main(String[] args) {
        System.out.println("소수를 알고싶은 숫자를 입력하세요");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        listprimes(num);
    }

    private static void listprimes(int num) {
        boolean bool= true;
        for(int i=2;i<=num;i++){
            bool=true;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    bool=false;
                    break;
                }
            }
            if(bool){
                System.out.println(i);
            }
        }
    }


}
