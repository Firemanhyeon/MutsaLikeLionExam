package ch08.exam;

public class CreditPayment implements Payment{
    @Override
    public void processPayment() {
        System.out.println("카드결제");
    }
}
