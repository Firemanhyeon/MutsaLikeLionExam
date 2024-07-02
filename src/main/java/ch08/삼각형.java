package ch08;

public class 삼각형 extends 도형{
    private double base;
    private double height;

    public 삼각형(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double 너비계산() {
        return (base*height)/2;
    }
}
