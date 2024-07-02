package ch07;

public class Test2 {
    public static void main(String[] args) {
        //아무것도 상속받지않으면 Object를 상속받는다. 모든 클래스는 Object의 자손이다
        Parent p = new Parent();
        System.out.println(p.getClass().getName());//object가 가진 getClass()메소드 사용가능
    }
}
