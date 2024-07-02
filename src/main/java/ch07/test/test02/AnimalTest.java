package ch07.test.test02;

public class AnimalTest {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Animal(); // 기본 Animal 인스턴스도 포함

        // 각 동물의 makeSound() 메서드 호출
        for(Animal animal : animals) {
            System.out.println(animal.makeSound());
        }
    }
}
