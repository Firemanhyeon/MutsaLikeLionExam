package ch02;

import java.util.Arrays;

public class DecimalToBinary {
    //10진수를 2진수로 변환하는 코드
    public static void main(String[] args) {
        int decimal = 29;//10진수

        //StringBuilder 문자열타입을 좀 더 효과적으로 사용할수있는 자료구조
        StringBuilder binary = new StringBuilder();

        while(decimal>0){
            int remainder = decimal%2;//2로나눈 나머지를 remainder에 저장
            decimal=decimal/2;//다음 계산을 위해 2로 나눔
            binary.append(remainder);//binary에 저장
        }
        System.out.println(binary.reverse().toString());//거꾸로 출력
    }
}
