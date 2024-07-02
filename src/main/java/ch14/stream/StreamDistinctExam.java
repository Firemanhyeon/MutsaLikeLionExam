package ch14.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDistinctExam {
    public static void main(String[] args) {
        //글자수가 5 이상인 것만 필터링하고 중복은 제거해서 새로운 리스트로 반환
        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Apple", "Cherry", "Date");
        List<String> newWords = words.stream().filter( s -> s.length()>=5).distinct().collect(Collectors.toList());
        System.out.println(newWords);

        List<String>newWords2 = new ArrayList<>();
        for(String word : words) {
            if(word.length()>=5) {
                if(!newWords2.contains(word)) {
                    newWords2.add(word);
                }
            }
        }
        System.out.println(newWords2);

        words.stream().map(word -> word.toUpperCase()).forEach(System.out::println);
        //각요소에 3을 곱해서 출력
        int[] intArr = {3,34,5,1,2};
        Arrays.stream(intArr).map(i -> i*3).forEach(System.out::println);
    }
}
