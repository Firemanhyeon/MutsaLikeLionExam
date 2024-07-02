package ch14.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExam {
    public static void main(String[] args) {
        List<List<String>> list = Arrays.asList(
                Arrays.asList("Apple" , "Banana"),
                Arrays.asList("Cherry , Date")
        );
        List<String> flatMap = list.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(flatMap);

        List<String> flatMap2 = Arrays.asList("hello java!!" , "hi carami!" , "lambda stream");
        flatMap2.stream().flatMap(s -> Arrays.stream(s.split(" "))).forEach(System.out::println);

        //
        List<String> list2 = Arrays.asList("1 ,3,  4,6  ,7  ,8,  9");
        list2.stream()
                .flatMapToInt(
                        data -> {
                            String[] strArr = data.split(",");
                            int[] intArr = new int[strArr.length];
                            for (int i = 0; i < strArr.length; i++) {
                                intArr[i] = Integer.parseInt(strArr[i].trim());
                            }
                            return Arrays.stream(intArr);
                        })
                .forEach(System.out::println);

        list2.stream().flatMapToInt(data -> Arrays.stream(data.split(","))
                        .mapToInt(str -> Integer.parseInt(str.trim())))
                .forEach(System.out::print);
    }
}
