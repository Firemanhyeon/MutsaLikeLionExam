package ch14.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamForeachPeekExam {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        //foreach사용예시
        list.stream().forEach(System.out::println);
        //peek사용예시
        List<Integer> list1 = list.stream().peek(s -> System.out.println(s)).map(n-> n*2).peek(System.out::println).collect(Collectors.toList());
        System.out.println(list1);
        //foreach는 최종연산이기때문에 그 이후에 다른 메소드들이 들어올 수 없다. 그런데 peek는 중간연산이기때문에 반복하고도 또 그다음에 다른 메소드들을 호출할 수 있다.
    }
}
