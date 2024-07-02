package ch14.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExam1 {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a", "b", "c", "d", "e");
        List<String> filteredList = myList.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
        System.out.println(filteredList);

        List<String> filteredList2=new ArrayList<>();
        for(String str : myList){
            if(str.startsWith("a")){
                filteredList2.add(str);
            }
        }
        System.out.println(filteredList2);

        String[] names ={"kang" , "kim" , "hong" , "lee" , "son"};

        Arrays.stream(names).forEach(System.out::println);
        Arrays.stream(names).forEach(name->System.out.println(name));
        Arrays.stream(names).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        int[] iarr ={1,2,3,4,5,6,7,8,9};
        IntStream streams =    Arrays.stream(iarr).filter(s -> s%2==0);
        streams.forEach(System.out::println);
        System.out.println("===============");
        Arrays.stream(iarr).filter(s -> s%2==0).forEach(System.out::println);
    }
}
