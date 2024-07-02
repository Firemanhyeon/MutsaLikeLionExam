package ch07;

public class Car {
    String name;
    int speed;

    public Car(){
        System.out.println("매개변수없음 생성자 호출");
    }
    public Car(String name){
        this.name = name;
        System.out.println("String name 생성자 호출");
    }
    public Car(int speed){
        this.speed=speed;
        System.out.println("int speed 생성자 호출");
    }
    public Car(String name , int speed){
        this.name=name;
        this.speed=speed;
        System.out.println("String name , int speed 생성자 호출");
    }

}
