package ch07;

public class MathBean {

    void printClassName(){
         System.out.println(this.getClass().getName());
    }
    void printNumber(int x){
        System.out.println(x);
    }
    int getOne(){
        return 1;
    }

    int plus(int x , int y){
        return x+y;
    }

}
