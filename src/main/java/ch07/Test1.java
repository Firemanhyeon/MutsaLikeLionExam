package ch07;

public class Test1 {
    public static void main(String[] args) {
        Parent parent = new Parent();
        System.out.println(parent.i);
        System.out.println(parent.getI());
        //child는 아무것도 가지고있지 않은데 parent 클래스에 있는것들을 사용할 수 있다.
        Child child = new Child();
        System.out.println(child.i);
        System.out.println(child.getI());
        System.out.println(child.getClass().getName());//object가 부모의 부모이기때문에 child에서도 사용이 가능하다.
    }
}
