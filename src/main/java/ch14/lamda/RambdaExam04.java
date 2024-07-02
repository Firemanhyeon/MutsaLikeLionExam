package ch14.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class RambdaExam04 {
    public static void main(String[] args) {
        //메소드참조 ::
        //1.정적메소드 참조
        //BiFunction<Integer,Integer,Integer> maxFunc = (a,b)-> Math.max(a,b);//이렇게 구현할걸 더 간단하게 구현한다.
        BiFunction<Integer,Integer,Integer> maxFunc = Math::max;

        System.out.println(maxFunc.apply(1,3));

        //2.인스턴스메소드 참조
        String str = "hello world";
        Supplier<Integer> supplier = str::length;
        System.out.println(supplier.get());

        //3.임의 객체의 인스턴스메소드참조
        List<String> list = Arrays.asList("hello", "world" , "java" , "hhhh");
        List<Integer> length = new ArrayList<>();
        Function<String , Integer> lengthFunc2 = String::length;
        for(String s : list) {
            length.add(lengthFunc2.apply(s));
        }
        System.out.println(length.toString());

        //4.생성자 참조
        Supplier<List<String>> listSupplier =  ArrayList::new;
        List<String> list2 = listSupplier.get();
        list2.add("11");
        System.out.println(list2.toString());
    }
}
