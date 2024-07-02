package ch02;

public class Dog {
    //접근제한자 생략가능한데 생략하면 패키지영역에서만 접근가능하다.
    //필드
    public String breed;
    public int age;
    public String color;

    //생성자:객체가 생성될때 초기값을 갖게할수있는것
    //접근제한자 클래스명(매개변수-초기화할변수들){}
    //생성할때부터 값을 갖게하고싶으면 생성자를 선언해준다.
    //생성자를 선언하지 않으면 default로 기본생성자를 생성한다.
    Dog(String breed , String color){
        this.breed = breed;
        this.color = color;
    }
    //아무것도없는 생성자를 생성할수도있다.
    Dog(){

    }

    //메소드
    //접근제한자 리턴타입 메소드명(매개변수들){구현}

    void bark(){
        System.out.println("월월");
    }
    void displayInfo(){
        System.out.println("bread: "+breed+" age: "+ age + " color: "+ color);
    }
    static void classMethod(){
        System.out.println("클래스메서드는 인스턴스화 하지 않아도 사용할 수 있어요");
    }
    void instanceMethod(){
        System.out.println("인스턴스메소드는 반드시 인스턴스화 한 후 사용할 수 있어요");
    }




}
