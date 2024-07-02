package ch14.lamda;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exam {
    public static void main(String[] args) {
//        문제 1: 문자열 리스트 정렬하기
//        요구 사항: 주어진 List<String>을 문자열 길이에 따라 정렬하되, 람다식을 사용하여 Collections.sort() 메서드를 활용하라.
            List<String> list = Arrays.asList("55555","4444","333","22","111");
            Collections.sort(list , (s1 , s2) -> s1.length()-s2.length());
            System.out.println(list);
//        문제 2: 최대값 찾기
//        요구 사항: 주어진 정수 배열에서 최대값을 찾아 출력하라. 람다식을 사용하여 자바의 Comparator 인터페이스와 함께 Arrays.sort()를 활용하라.
            Integer[] list1 = {123, 1, 2, 3,45,6};
            Comparator<Integer> comparator = (a,b) -> a-b;
            Arrays.sort(list1,comparator);
            System.out.println(list1[list1.length-1]);
//        문제 3: 리스트의 각 요소에 연산 적용하기
//        요구 사항: 주어진 List<Integer>의 각 요소에 10을 더한 결과를 새 리스트에 저장하고 출력하라. 람다식을 사용하여 List의 forEach() 메서드를 활용하라.
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4,5,6);
        List<Integer> newList = new ArrayList<>();
        list3.forEach( i -> newList.add(i+10));
        System.out.println(newList);
//        문제 4: 조건에 맞는 요소 찾기
//        요구 사항: 주어진 List<String>에서 글자 수가 5 이상인 첫 번째 단어를 찾아 출력하라. for 루프와 람다식을 활용하여 조건에 맞는 요소를 찾아보세요.
            List<String> list4 = Arrays.asList("111","222","333","444","55555","666","77777");

            Predicate<String> condition = s -> s.length()>=5;

            for(String str : list4){
                if(condition.test(str)){
                    System.out.println(str);
                    break;
                }
            }
//      문제 5: 요소 변환하기
//      요구 사항: 주어진 List<Integer>의 각 요소를 제곱한 결과를 새 리스트에 저장하고 출력하라. for 루프와 람다식을 활용하여 각 요소를 변환하라.
          List<Integer> list5 = Arrays.asList(1,2,3,4,5);
            List<Integer> newList5 = new ArrayList<>();
            Function<Integer , Integer> func = i -> i*i;
            for(int a : list5){
                newList5.add(func.apply(a));
            }
        System.out.println(newList5);

//      문제 6: 모든 요소에 대해 조건 확인하기
//      요구 사항: 주어진 List<Integer>의 모든 요소가 짝수인지 확인하라. 람다식을 활용하여 조건 검사를 수행하고 결과를 출력하라.
        List<Integer> list6 = Arrays.asList(2,2,2,4,2);
        Predicate<Integer> predicate = i -> i%2 ==0;
        boolean chk = true;
        for(int a : list6){
            if(!predicate.test(a)) {
                System.out.println("홀수가 있습니다");
                chk=false;
                break;
            }
        }
        if(chk){
            System.out.println("전부짝수입니다");
        }

    }
}
