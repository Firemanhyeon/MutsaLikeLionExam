package ch07;

public class CarTest {
    public static void main(String[] args) {
        Car car1 = new Car();
        System.out.println("====================");
        Car car = new Car("벤틀리");//만들어질때 car의 생성자를 자동으로 생성한다.\
        System.out.println("====================");
        Car car2 = new Car(10);
        System.out.println("====================");
        Car car3 = new Car("소나타",20);
        System.out.println("====================");
        Bus bus = new Bus();//부모인 car생성자가 먼저 호출되고 그다음 bus생성자가 호출된다
        System.out.println("====================");

        Bus bus1 = new Bus();//부모는 default 생성자가 호출.

    }
}
