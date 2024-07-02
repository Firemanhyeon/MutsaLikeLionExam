package ch03;

import java.util.Arrays;

public class SearchExam {
    //순차검색
    static int sequentialSearch(int[] array , int key){
        for(int i=0; i<array.length;i++){
            if(array[i]==key){
                return i;
            }
        }
        return -1;
    }
    //이진검색
    static int binarySearch(int[] array , int key){
        int low =0;//처음인덱스
        int high = array.length-1;//마지막인덱스
        Arrays.sort(array);//정렬
        while(low<=high){
            int mid = (low+high)/2;//중간인덱스값
            if(array[mid]==key){//중간값과 key값 체크
                return mid;//맞으면 리턴
            } else if (array[mid]<key) { //아니면 중간값보다 큰지 작은지 체크
                low = mid+1;//중간값이 작으면 더 크다는 의미니까 처음인덱스+1
            }else{
                high = mid-1;//중간값이 높으면 더 작다는 의미니까 마지막인덱스-1
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int [] iarr = {551,3,5,6,7,33,45};
        int key = 33;
        if(sequentialSearch(iarr,key)!=-1){
            System.out.println("찾으시려는 숫자는 "+sequentialSearch(iarr,key)+"위치에 있습니다");
        }else{
            System.out.println("찾으시려는 숫자가 없습니다");
        }

        if(binarySearch(iarr,key)!=-1){
            System.out.println("찾으시려는 숫자는 "+binarySearch(iarr,key)+"위치에 있습니다");
        }else{
            System.out.println("찾으시려는 숫자가 없습니다");
        }

    }
}
