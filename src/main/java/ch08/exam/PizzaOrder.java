package ch08.exam;

public class PizzaOrder extends Order{
    @Override
    void prepareFood() {
        System.out.println("피자를 준비합니다");
    }

    @Override
    void serveFood() {
        System.out.println("피자를 서빙합니다");
    }
}
