package ch07;

public class Test3 {
    public static void m1(Child obj){

    }
    public static void main(String[] args) {
        //부모타입으로 자식을 참조할 수 있다.
        //조상은 자손을 가리킬수있다.
        Parent parent = new Child();
        Object obj = new Child();
        Object obj2 = new Parent();

        m1((Child)parent);
        m1((Child)obj);
        //m1((Child)obj2);
        //object타입으로 선언했기때문에 쓸 수 없다. 하지만 Child타입으로 형변환을 한다면 쓸 수 있다.
        //System.out.println(((Child)obj).i);
        //System.out.println(obj.getI());

        //Child c = obj;작은그릇이 큰그릇을 담을 수 없다.

        Object bbb = new Child();//인스턴스타입은 Child

        if(bbb instanceof  Child){
            Child ccc = (Child) bbb;
            System.out.println("형변환완료");
        }
    }
}
