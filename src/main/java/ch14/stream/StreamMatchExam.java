package ch14.stream;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

public class StreamMatchExam {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(-1,1,2,3,4,5);
        boolean allPositive = list.stream().allMatch(n -> n>0);//전부다 조건에 만족하냐
        boolean anyPositive = list.stream().anyMatch(n -> n>0);//하나라도만족하냐
        boolean nonePositive = list.stream().noneMatch(n -> n>0);//전부다일치하지않냐
        System.out.println(allPositive);
        System.out.println(anyPositive);
        System.out.println(nonePositive);
    }
}
