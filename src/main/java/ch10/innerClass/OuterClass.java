package ch10.innerClass;

//외부클래스
public class OuterClass {
    private  int outerField = 10;
    private InnerClass innerClass;

    public void outerMethod(){
        InnerClass innerClass = new InnerClass();//외부클래스에서 내부클래스 접근가능
        innerClass.innerMethod();
    }


    //내부클래스
    class InnerClass{
        public void innerMethod(){
            System.out.println("outerField : "+outerField);//내부클래스에서 외부클래스멤버접근가능.
        }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.outerMethod();

    }
}
