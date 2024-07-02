package ch02;

public class DogTest {
    public static void main(String[] args) {
        Dog dog = new Dog("wolwol" , "yellow");//인스턴스화 할때 Dog라는 객체가 생성된다.
        dog.age=17;
        dog.bark();
        System.out.println(dog.age);
        System.out.println(dog.color);
        dog.displayInfo();

        Dog dog1 = new Dog();
        dog1.age=12;
        dog1.displayInfo();

        Dog.classMethod();
        Dog dogx= new Dog();
        dogx.instanceMethod();

    }
}
