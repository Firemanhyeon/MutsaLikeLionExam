package ch12.Thread.babyLion;

public class Exam04 {
    public static int a;
    public static void main(String[] args) {
       CounterThread counterThread = new CounterThread();
       counterThread.start();
        System.out.println("메인메소드실행");
        try {
            counterThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        a= counterThread.b;
        System.out.println("계산결과: "+a);
        CounterThread counterThread2 = new CounterThread();
        counterThread2.start();
        try {
            counterThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("계산결과: "+a);
    }
}
class CounterThread extends Thread {
    public static int b;

    @Override
    public void run() {
        b=Exam04.a;
        for(int i=0;i<10;i++){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            b++;
            System.out.println(b);
        }
        System.out.println("계산종료");
    }
}
