package ch07;

public class ClassA {
    public static int fieldA; // 클래스필드 : 인스턴스화 하지않아도 선언가능

    public int fieldB;//인스턴스필드 : 인스턴스화 해야만 선언가능

    int count; // 같은패키지안에서만 사용

    protected  int number; // 같은패키지 or 상속받은 클래스에서만 사용가능

    private String address; //같은클래스내에서만 사용

    public String name; // 어디든 사용가능
}
