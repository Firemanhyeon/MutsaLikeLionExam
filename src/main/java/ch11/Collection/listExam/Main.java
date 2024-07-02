package ch11.Collection.listExam;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        List<Integer> scores = new ArrayList<>();

        try{
            // 점수 입력 받기
            readScores(input, scores);

            // 0점 제거
            removeZero(scores);

            // 결과 출력
            printScores(scores);

            // 리소스 정리
            input.close();
        }catch(NotScoreException e){
            System.out.println(e.getMessage());
        }catch(InputMismatchException e){
            System.out.println(e.getStackTrace());
        }
        finally {
            input.close();
        }

    }
    private static void readScores (Scanner input , List<Integer> scores) throws NotScoreException {
        while(true){
            System.out.println("점수를 입력하세요");
            int a = input.nextInt();

            if(a<0 || a>100){
                throw new NotScoreException("0-100사이의 숫자만 입력이 가능합니다.");

            }else if(a==0){
                System.out.println("입력종료");
                break;
            }else{
                scores.add(a);
            }
        }
    }
    private static void removeZero(List<Integer> scores) {
        for(int i=0; i<scores.size(); i++){
            if(scores.get(i)==0){
                scores.remove(i);
            }
        }
    }
    private static void printScores(List<Integer> scores) {
        System.out.println(scores);
        int sum=0;
        for(int i=0; i<scores.size(); i++){
            sum+=scores.get(i);
        }
        int avg = sum/scores.size();
        System.out.println("평균 : "+avg);
    }
}