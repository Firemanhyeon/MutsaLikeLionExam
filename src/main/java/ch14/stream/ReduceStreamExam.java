package ch14.stream;

import java.util.Arrays;
import java.util.List;

public class ReduceStreamExam {
    public static void main(String[] args) {
        //리듀싱연산 : 집계 (평균 총합 최대값 최소값)등 계산
        //          데이터변환 : 여러값을 하나로 결합하여 새로운결과 생성
        //          정보추출 : 대규모 데이터 집합에서 필요한 정보를 추출하는데 사용.
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        numbers.stream().reduce( 0 ,(a,b)->a+b);
        //a=초기값 0
        //b = 꺼내온요소 1
        //a+b를 초기값에 넣어줌
        // 초기값=1
        //a = 초기값1
        //b=2
        //a+b를초기값에넣어줌
        //초기값 = 3
        //a=3 이런구조임.


        List<Member> list = Arrays.asList(
                new Member("hyeon" , 100 , 1),
                new Member("kim" , 90 , 1 ),
                new Member("hong" , 80 , 0),
                new Member("kang" , 70 , 0)
        );
        //Member들의 score총합구하기
        int memberScoreSum = list.stream().mapToInt(Member::getScore).sum();
        System.out.println(memberScoreSum);

        int memberScoreSum2 = list.stream().mapToInt(Member::getScore).reduce(0,(a,b) -> a+b);
        System.out.println(memberScoreSum2);

        int memberScoreSum3 = list.stream().filter(member -> member.getSex()==1).mapToInt(Member::getScore).reduce((a,b) -> a+b).getAsInt();
        System.out.println(memberScoreSum3);
    }
}
