package ch07.test.test01;

public class CarExam {
    public static void main(String[] args) {
        Car car = new Car("Hyundati" , "sonata" , 2020);
        System.out.println(car.displayInfo());

        ElectricCar electricCar = new ElectricCar("Tesla", "Model S", 2021, 75);
        System.out.println(electricCar.displayInfo());
    }
}
