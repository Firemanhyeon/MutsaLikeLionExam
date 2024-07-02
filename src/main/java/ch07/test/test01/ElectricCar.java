package ch07.test.test01;

public class ElectricCar extends Car{
    int batteryCapacity;

    public ElectricCar(String brand, String model, int year , int batteryCapacity) {
        super(brand, model, year);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String displayInfo() {
        return "ElectricCar{" +
                "batteryCapacity=" + batteryCapacity +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
