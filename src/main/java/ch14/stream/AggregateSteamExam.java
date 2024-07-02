package ch14.stream;

import java.util.Arrays;

public class AggregateSteamExam {
    public static void main(String[] args) {
        int[] intArr = {12,36,25,22,58,67};
        long count = Arrays.stream(intArr).boxed().count();
        int max = Arrays.stream(intArr).boxed().max(Integer::compareTo).orElse(0); //최대값 , List가 비어있으면 0 반환
        int min = Arrays.stream(intArr).boxed().min(Integer::compareTo).orElse(0);
        double average = Arrays.stream(intArr).average().orElse(0);
        int sum = Arrays.stream(intArr).sum();
        System.out.println(count);
        System.out.println(max);
        System.out.println(min);
        System.out.println(average);
        System.out.println(sum);
    }
}
