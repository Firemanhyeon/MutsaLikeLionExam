package ch05;

public class GCDCalculator {

    static int calculatorGCD(int x, int y){
        if(y==0){
            return x;
        }else{
            return calculatorGCD(y, x%y);
        }
    }

    static int gcd(int a , int b){
        while(b!=0){
            int temp=b;
            b=a%b;//a와 b의 나머지를 구하고
            a=temp;// b를 a에 넣어서 다시 윗줄 실행
        }
        return a;
    }

    public static void main(String[] args) {
        int a= 1071;
        int b = 462;
        System.out.println(calculatorGCD(a,b));
        System.out.println(gcd(a,b));
    }
}
