package ch12.Thread.Exam;

public class Main {
    public static void main(String[] args) {
        DecrementCounter counter = new DecrementCounter();
        IncrementCounter incrementCounter = new IncrementCounter();
        Thread t1 = new Thread(counter);
        Thread t2 = new Thread(incrementCounter);
        t1.start();
        t2.start();
    }
}
