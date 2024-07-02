package ch12.Thread.babyLion;

public class Exam03 {
    public static void main(String[] args) {
        System.out.println("메인시작");
        MyThread1 myThread = new MyThread1();
        myThread.start();
        try {
            myThread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("메인끝");
    }
}
class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("스레드 시작");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("스레드끝");
    }
}
