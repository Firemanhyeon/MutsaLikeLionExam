package ch02;

public class TwoDimensionalArrayExample {
    public static void main(String[] args) {
        int[][]score = {
                {90,80,70,60},
                {60,20,30,70},
                {60,30,210,10,20}
        };

        for(int i=0; i< score.length;i++){
            System.out.println(i+1+"번학생의 점수");
            int sum=0;
            for(int j=0;j<score[i].length;j++){
                System.out.println(score[i][j]);
                sum+=score[i][j];
            }
            System.out.println(i+1+"번학생의 총점");
            System.out.println(sum);
            System.out.println(i+1+"번학생의 평균");
            System.out.println((double)sum/score[i].length);
            System.out.println("====================");
        }
    }

}
