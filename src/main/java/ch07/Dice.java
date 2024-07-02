package ch07;

public class Dice {
    int face;
    int eye;


    //생성자 - 객체가 처음 생성될 때 초기화 할 수 있는 메소드
    //접근제한자 메소드명-클래스명과 동일 (매개변수들){구현..}
    //생성자가 하나라도 추가되면 기본생성자는 쓸 수 없다.
    public Dice(int face){
        this.face = face;
        System.out.println("Dice(int)생성자실행");
    }
    public Dice(){
        //this.face = 6;
        this(6);
        System.out.println("Dice()생성자실행");
    }
    public void roll(){
        this.eye = (int)(Math.random()*face)+1;
    }
    public int  getEye(){
        return eye;
    }
}
