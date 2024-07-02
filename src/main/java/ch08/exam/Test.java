package ch08.exam;

public class Test {
    public static void main(String[] args) {
        Order pizzaOrder = new PizzaOrder();
        Order burgerOrder = new BurgerOrder();

        Payment cashPayment = new CashPayment();
        Payment creditPayment = new CreditPayment();


        pizzaOrder.completeOrder();


        burgerOrder.completeOrder();

        cashPayment.processPayment();
        creditPayment.processPayment();
    }
}
