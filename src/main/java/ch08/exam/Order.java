package ch08.exam;

public abstract class Order {

    abstract void prepareFood();
    abstract void serveFood();

    final void completeOrder(){
        prepareFood();
        serveFood();
        System.out.println("주문이 완료되었습니다");
    }
}
