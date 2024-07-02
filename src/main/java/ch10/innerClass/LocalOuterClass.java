package ch10.innerClass;

public class LocalOuterClass {
    private int outerField = 10;

    public void outerMethod(){
        class InnerClass {//아우터클래스의 메소드 안에 내부클래스선언 outerMethod 내에서만 사용될 수 있다.
            public void innerMethod(){
                System.out.println("outerField = " + outerField);
            }
        }

        InnerClass inner = new InnerClass();
        inner.innerMethod();
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.outerMethod();
    }
}
