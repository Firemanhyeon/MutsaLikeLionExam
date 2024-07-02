package ch01;

import java.util.Arrays;

public class MiddleValue {
    public int mVal(int a , int b , int c ){

        int[] mv = new int[3];

        mv[0]=a;
        mv[1]=b;
        mv[2]=c;
        Arrays.sort(mv);
        return mv[1];

    }

    public static void main(String[] args) {
        MiddleValue mv = new MiddleValue();
        System.out.println(mv.mVal(1,2,3));
    }
}
