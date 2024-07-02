package ch12.Thread;
class MyRunnable implements Runnable {//Thread는 아니다
    String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    //실행할 작업
    @Override
    public void run() {
        System.out.println("myRunnable 실행");
        for (int i = 0; i < 100; i++) {
            System.out.println(name+"runnable run"+i);
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("my runaable 종료");
    }
}
class HHRunnable implements Runnable {//Thread는 아니다
    //실행할 작업
    @Override
    public void run() {
        System.out.println("HHRunnable 실행");
        for (int i = 0; i < 100; i++) {
            System.out.println("HHRunnable run");
        }
        System.out.println("HHRunnable runaable 종료");
    }
}
public class RunnableExam {
    public static void main(String[] args) {
        System.out.println("main실행");
        Thread runnable = new Thread(new MyRunnable("철수"));//쓰레드가 아니라 쓰레드를 선언하고 안에 생성자로 넣어줘야한다.
        runnable.start();
        Thread runnable1 = new Thread(new HHRunnable());
        runnable1.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main run");
        }
        System.out.println("main 종료");
    }
}
