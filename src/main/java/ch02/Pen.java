package ch02;

public class Pen {
    //속성
    String color;

    String sound;

    int price;

    //행위
    String whatColor(){
        return color;
    }
    void writeSound(){
        System.out.println("글쓸때의 소리:"+sound);
    }
    void getPrice(){
        System.out.println("가격은 "+price+"입니다");
    }

}
