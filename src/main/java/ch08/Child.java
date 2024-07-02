package ch08;

public class Child extends Parent{
    //상속을 거는순간 오류가 나온다. 부모클래스에서 생성자를 생성했기때문에 생성자를 하나라도 생성했을시에는 default생성자는 생성되지않아서 무조건 값을 넣어줘야한다.

    public Child() {
        super("no name", 0);
    }

    @Override
    public String getName(){
        System.out.println("나는 자식클래스에서 구현한 getName()입니다");
        return super.getName();
    }
}
