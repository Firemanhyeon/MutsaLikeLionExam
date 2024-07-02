package ch14.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortedExam {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Banana" , "Apple", "Cherry" , "Date");
        List<String> sortedFruits = fruits.stream().sorted().collect(Collectors.toList());
        List<String> reverseSortedFruits = sortedFruits.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedFruits);
        System.out.println(reverseSortedFruits);

        int[] iarr = {5,3,27,9,5,9,0,4};
        //위 배열을 오름차순으로 정렬
       Arrays.stream(iarr).boxed().sorted().forEach(System.out::println);

        //내림차순으로 정렬
        //int 기본데이터타입이라 Comparator.reverseOrder()를 사용못한다. boxed()로 레퍼런스타입으로 바꿔준 후 정렬해야한다.
        Arrays.stream(iarr).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
