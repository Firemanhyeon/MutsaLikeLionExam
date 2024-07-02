package ch14.lamda;

import java.util.function.*;

public class RambdaExam1 {
    public static void main(String[] args) {
        //predicate
        //조건을 테스트하는데 사용 boolean값 반환
        Predicate<Integer> isPositive = x-> x>0;

        System.out.println(isPositive.test(1));

        //Consumer
        //입력을 받고 반환값이 없는 연산 수행
        Consumer<String>consumer = s-> System.out.println(s);
        consumer.accept("hello");

        //Function
        //입력을 받아서 출력을 반환
        Function<String ,Integer> lengthFunc = s->s.length();
        System.out.println(lengthFunc.apply("hello"));

        //Suplier
        //입력없이 값을 반환
        Supplier<Double> randomSupplier = ()-> Math.random();
        System.out.println(randomSupplier.get());

        //int고정 Supplier
        IntSupplier intSupplier  = () -> (int)(Math.random()*6);
        System.out.println(intSupplier.getAsInt());

        //UnarrayOperation
        //입력과 출력이 같은 타입일때 사용
        UnaryOperator<Integer> square = x -> x*x;
        System.out.println(square.apply(5));

        //BiFunction
        //두개의 입력을 받고 하나의 결과를 반환
        BiFunction<Integer , Integer , Integer> biFunction = (a,b)-> a+b;
        System.out.println(biFunction.apply(5,5));

        //Consumer의 andThen메소드 활용
        Consumer<String>consumer1 = s-> System.out.println(s+"aaa");
        Consumer<String>consumer2 = s-> System.out.println(s+"bbb");

        consumer1.accept("carami");
        consumer2.accept("carami");

        Consumer<String> consumerAB = consumer1.andThen(consumer2);
        consumerAB.accept("carami");
    }
}
