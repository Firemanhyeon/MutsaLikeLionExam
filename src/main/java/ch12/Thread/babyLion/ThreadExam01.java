package ch12.Thread.babyLion;

public class ThreadExam01 {
    public static void main(String[] args) {
        //쓰레드구현두가지방법
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
//1. 상속
class MyThread extends Thread {
    //실제하고자하는 일 run 메서드안에서 구현
    @Override
    public void run() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("쓰레드에서 하고자하는일");
    }
}
