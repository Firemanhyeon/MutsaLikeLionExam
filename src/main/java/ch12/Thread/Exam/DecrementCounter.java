package ch12.Thread.Exam;

public class DecrementCounter implements Runnable {
    @Override
    public void run() {
        for(int i=1;i<=100;i++) {
            System.out.println("DecrementCounter thread "+i);
            try {
                int time = (int)(Math.random()*11);
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
