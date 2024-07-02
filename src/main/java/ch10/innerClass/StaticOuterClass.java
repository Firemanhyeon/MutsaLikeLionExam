package ch10.innerClass;

public class StaticOuterClass {
    private static int outerField = 10;
    private InnerClass innerClass;



    //내부클래스
    static class InnerClass{
        public static void innerMethod(){
            System.out.println("outerField : "+outerField);//인스턴스화 되어야 메모리에 올라가기때문에 쓸 수 없다.
        }
    }

    public static void main(String[] args) {

        StaticOuterClass.InnerClass innerClass = new StaticOuterClass.InnerClass();
        innerClass.innerMethod();

    }
}
