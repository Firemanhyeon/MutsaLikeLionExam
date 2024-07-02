package ch06;

import java.util.Arrays;

public class SimpleSelectSortExam {
    static void simpleSelectSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){//최소값을 찾는다
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr , i , minIndex);
        }
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr , int a , int b){//바꿀배열 , 최소값(바꿀값) , 바꿀인덱스
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]= temp;

    }

    public static void main(String[] args) {
        int[] arr= {5,11,3 ,7,10,2 };

        simpleSelectSort(arr);
    }
}
