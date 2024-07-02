package ch08.exam;

public class BurgerOrder extends Order{
    @Override
    void prepareFood() {
        System.out.println("햄버거를 준비합니다");
    }

    @Override
    void serveFood() {
        System.out.println("햄버거를 서빙합니다");
    }
}
