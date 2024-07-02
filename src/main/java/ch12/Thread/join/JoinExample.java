package ch12.Thread.join;

public class JoinExample {
    public static int a;
    public static void main(String[] args) {
        SumThread t = new SumThread();
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        a = SumThread.b;
        System.out.println("Sum thread 계산 결과는 :"+ a+"입니다");
    }
}

class SumThread extends Thread {
    public static int b;
    @Override
    public void run() {
        //계산을 담당하는 메소드
        b++;
        b++;
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("계산종료");
    }
}
