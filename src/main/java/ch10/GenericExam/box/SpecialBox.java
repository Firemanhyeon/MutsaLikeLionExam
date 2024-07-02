package ch10.GenericExam.box;

public class SpecialBox<T> extends Box<T> {

    public SpecialBox(T content) {
        super(content);
    }
    //특별한 기능을 추가하는 메소드
    public void printContent(){
        System.out.println("Special box contains:" + getContent());
    }
}
