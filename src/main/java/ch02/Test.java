package ch02;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String[] strlist = {"We", "are", "the", "World!"};
        int[] answer=new int [strlist.length];
        for(int i=0;i<strlist.length;i++){
             answer[i] = strlist[i].length();
        }

        System.out.println(Arrays.toString(answer));
    }
}

