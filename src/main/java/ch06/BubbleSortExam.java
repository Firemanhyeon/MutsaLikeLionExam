package ch06;

import java.util.Arrays;

public class BubbleSortExam {
    static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0; j<arr.length-1-i;j++){//한번돌면 마지막요소 하나가 정렬된다.
                if(arr[j]>arr[j+1]){
                    swap(arr, j , j+1);
                }
            }
            System.out.println(i+1+"번째 정렬: "+ Arrays.toString(arr));
        }
    }
    static void swap(int[] a , int idx1 , int idx2){
        int temp = a[idx1];
        a[idx1]= a[idx2];
        a[idx2] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {5,3,8,4,2};
        bubbleSort(arr);
        for(int result : arr){
            System.out.println(result);
        }

    }
}
