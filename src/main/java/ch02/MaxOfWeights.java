package ch02;

import java.util.Random;

public class MaxOfWeights {
    public static void main(String[] args) {
        int random = (int)(Math.random()*6)+1; //math클래스 메소드 사용
        System.out.println(random);


        Random random1 = new Random();//random클래스 메소드사용
        System.out.println(40+ random1.nextInt(60));
    }
}
