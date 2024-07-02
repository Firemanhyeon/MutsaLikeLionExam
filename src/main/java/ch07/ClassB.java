package ch07;

public class ClassB {
    public String name; //어디든

    protected boolean flag; // 같은패키지 or 상속받은 클래스

    String address; // 같은패키지

    private int age; //해당클래스내에서만

    public void print(){
        System.out.println(name);
        System.out.println(flag);
        System.out.println(address);
        System.out.println(age);
    }
}
