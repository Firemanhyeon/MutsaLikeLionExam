package ch08.interfaceExam;

public class Dog implements Animal{
    @Override
    public void speak() {
        System.out.println("멍멍");
    }
}
