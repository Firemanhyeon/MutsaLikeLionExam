package ch07;

public class Child extends Parent{


    int getI(int i){
        System.out.println("child 매개변수있음");
        return i;
    }

//    int getI(){
//        System.out.println("child 매개변수없음");
//        return i;
//    }

}
