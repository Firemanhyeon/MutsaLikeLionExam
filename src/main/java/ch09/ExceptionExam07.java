package ch09;

import java.util.Scanner;

public class ExceptionExam07 {
    //사용자정의 예외처리
    public void inputScore(int score){

        if(score<0 || score>5){
            throw new MyException("1~5점까지만 입력가능합니다. 당신이 입력한 점수는: "+score);
        }
        System.out.println(score);
    }

    public static void main(String[] args) throws IndexOutOfBoundsException{
        ExceptionExam07 exceptionExam07 = new ExceptionExam07();
        Scanner sc = new Scanner(System.in);
        System.out.println("점수를입력하세요");
        int score=sc.nextInt();
        try {
            exceptionExam07.inputScore(score);
        }catch (MyException e){
            System.out.println("예외발생");
            System.out.println(e.getMessage());
        }
        System.out.println("main 종료");


    }
}
