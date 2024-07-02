package ch01;

public class MaxValue {
    //세값의 최댓값 구하기

    //메소드로 구현
    //접근제한자 리턴타입 메소드명 (매개변수들..){구현..}
    public static int max(int a, int b, int c){
        if(a>b){
            if(a>c){
                return a;
            }else{
                return c;
            }
        }else if(b>c){
            return b;
        }else{
            return c;

        }
    }

    public static void main(String[] args) {
        System.out.println(MaxValue.max(1,2,3));
    }
}
