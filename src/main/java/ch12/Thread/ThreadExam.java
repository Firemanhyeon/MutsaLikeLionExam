package ch12.Thread;

class MyThread extends Thread {//상속 Thread를 상속받은 myTread는 Thread가 된다.
    //쓰레드가 해야하는 일
    @Override
    public void run() {
        System.out.println("myThread출발");
        for(int i=0;i<10;i++) {
            System.out.println("My안녕");
        }
        System.out.println("myThread종료");
    }

}
class HHThread extends Thread {//상속 Thread를 상속받은 myTread는 Thread가 된다.
    //쓰레드가 해야하는 일
    @Override
    public void run() {
        System.out.println("HHThread출발");
        for(int i=0;i<10;i++) {
            System.out.println("HH안녕");
        }
        System.out.println("HHThread종료");
    }

}

public class ThreadExam {
    public static void main(String[] args) {
        System.out.println("main출발");

        //쓰레드생성.
        MyThread myThread = new MyThread();
        myThread.start();//쓰레드시작
        HHThread hhThread = new HHThread();
        hhThread.start();
        for(int i=0;i<10;i++) {
            System.out.println("main 안녕");
        }
        System.out.println("main 종료");
    }

}
