package ch02;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class DuplicateArray {
    static Scanner sc  = new Scanner(System.in);
    public static int[] change(int[] copied){
        copied[2]=10;
        return copied;
    }
    public static int change(int copied){
        copied=10;
        return copied;
    }

    //역순정렬 메소드
    static void swap(Integer[] a , int idx1 , int idx2){
        int temp =a[idx1];
        a[idx1]= a[idx2];
        a[idx2] = temp;
    }
    static void reverse(Integer[] a){
        for(int i=0;i<a.length;i++){
            swap(a, i , a.length-1-i);
        }
    }

    public static void main(String[] args) {

        int[] original ={10,20,30,40,50};
        int[] copied = change(original);
        System.out.println(copied[2]);
        System.out.println(original[2]);//둘다 10으로 바뀌었다
        //change라는메소드가 실행되면 copied라는 매개변수가 생기는데 그 값을 넘겨받는게 아니라
        // 주소를 넘겨받기 떄문에 똑같은 배열을 가르키고있어서 둘다 10으로 바뀌었다 레퍼런스타입의 특징

        int orig = 0;
        int copi = change(orig);
        System.out.println(orig);// 0
        System.out.println(copi);// 10
        //orig이 0 이고 copi는 메소드를 통해 10으로 초기화된다. 위에랑 다르게 주소를 가리키고있는게 아니라
        // 값 자체를 가져온거라 따로따로 봐야한다.
//        int[] copied = original.clone();
//
//        copied[2] = 0;
//        System.out.println(original[2]);
//        System.out.println(copied[2]);

        //배열 역순으로 정렬하기
        //
        System.out.println("정수의개수");
        int num = sc.nextInt();
        Integer []scores =new Integer[num];

        for(int i=0; i<scores.length;i++){
            System.out.println("점수입력");
            scores[i]=sc.nextInt();

        }
        reverse(scores);
        System.out.println("역순정렬완료");
        System.out.println(Arrays.toString(scores));

        System.out.println("역순의역순");
        //역순다른방법
        Arrays.sort(scores , Collections.reverseOrder());
        System.out.println(Arrays.toString(scores));



    }
}
