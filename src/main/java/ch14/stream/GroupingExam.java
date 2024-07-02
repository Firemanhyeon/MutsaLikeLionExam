package ch14.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingExam {
    public static void main(String[] args) {
        List<Member> list = Arrays.asList(
                new Member("kang" , 20 , Member.FEMALE),
                new Member("ho" , 50 , Member.FEMALE),
                new Member("eee" , 40 , Member.MALE),
                new Member("aaa" , 30 , Member.MALE)
        );

        Map<Integer , List<Member>> mapBySex = list.stream().collect(Collectors.groupingBy(Member::getSex));
        System.out.println("남자");
        mapBySex.get(Member.MALE).stream().forEach(member -> System.out.println(member.getName()));
    }
}
