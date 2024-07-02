package ch10.AnonymousOuterClass;

import ch10.innerClass.OuterClass;

public class AnonymousOuterClass {
    private int outerField = 10;

    public void outerMethod(){

        Runnable runnable = new Runnable() {//인터페이스를 이름없이 구현
            public void run() {
                System.out.println("outerField: "+ outerField);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void main(String[] args) {
        AnonymousOuterClass outerClass = new AnonymousOuterClass();
        outerClass.outerMethod();
    }
}
