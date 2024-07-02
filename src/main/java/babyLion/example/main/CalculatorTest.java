package babyLion.example.main;

import babyLion.example.util.Calculator;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.plus(3,4));
        System.out.println(cal.minus(3,4));
    }
}
