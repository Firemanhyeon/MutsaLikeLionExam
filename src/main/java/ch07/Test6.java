package ch07;
//부모타입으로 설정하는이유
//부모타입으로 설정하면 사용자의 입력에 따라 다른 메소드를 사용할수도 있기 때문에
class 새{
    public void say(){
        System.out.println("짹짹");
    }
}
class 앵무새 extends 새{
    public void say(){
        System.out.println("앵무새");
    }
}
class 참새 extends 새{
    public void say(){
        System.out.println("참새");
    }
}
class 비둘기 extends 새{
    public void say(){
        System.out.println("비둘기");
    }
}
public class Test6 {
    public static void main(String[] args) {
        새 bird1 = new 새();
        새 bird2 = new 앵무새();
        새 bird3 = new 참새();
        새 bird4 = new 비둘기();

        bird1.say();
        bird2.say();
        bird3.say();
        bird4.say();

    }
}
