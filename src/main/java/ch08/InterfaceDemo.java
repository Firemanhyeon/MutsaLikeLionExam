package ch08;

public class InterfaceDemo {
    public static void main(String[] args) {
        //인터페이스도 타입이 될 수 있다.
        Ainter ainter = new Dimpl();
        Cinter cinter = new Dimpl();

        //자기가 정의한 것만 사용가능.
        ainter.aMethod();
        cinter.cMethod();

        Binter binter = new Dimpl();
        Dinter dinter = new Dimpl();

        binter.bMethod();
        binter.aMethod();
        binter.same();

    }
}
