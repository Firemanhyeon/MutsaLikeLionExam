package ch08.exam;

public class CashPayment implements Payment{
    @Override
    public void processPayment() {
        System.out.println("현금결제");
    }
}
