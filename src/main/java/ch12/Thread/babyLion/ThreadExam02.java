package ch12.Thread.babyLion;

public class ThreadExam02 {
    public static void main(String[] args) {
        System.out.println("메인시작");
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("구현하고자하는 일");
    }
}
