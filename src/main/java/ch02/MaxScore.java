package ch02;

import java.util.Scanner;

public class MaxScore {
    static Scanner sc = new Scanner(System.in);
    public static int maxScore(int[] arr){
        int max=0;
        for(int i=0;i<arr.length;i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        return max;

    }
    public static void main(String[] args) {
        System.out.println("학생수를입력하세요");
        int cnt = sc.nextInt();
        int[] arr = new int[cnt];
        for(int i =0; i<arr.length;i++){
            System.out.println("점수를 입력하세요");
            arr[i] = sc.nextInt();
        }
        System.out.println("최고점수는 "+maxScore(arr)+"점 입니다");
    }
}
