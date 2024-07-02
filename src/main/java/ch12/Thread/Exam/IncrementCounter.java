package ch12.Thread.Exam;

public class IncrementCounter implements Runnable {
    @Override
    public void run() {
        for(int i=100;i>0;i--){
            System.out.println("Increment counter: "+i);
            int time = (int)(Math.random()*11);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
