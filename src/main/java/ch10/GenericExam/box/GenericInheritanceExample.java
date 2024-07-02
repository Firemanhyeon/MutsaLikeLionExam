package ch10.GenericExam.box;

public class GenericInheritanceExample {
    public static void main(String[] args) {
        //제네릭의 상속
        //박스를 상속받은 스페셜박스 . 상속받아 그대로사용하고있다
        //컬러박스 : 상속+ 필드 새로 추가
        SpecialBox<String> specialBox = new SpecialBox<>("Hello world");
        specialBox.printContent();

        C<String , String > colorBox = new C("HelloWorld" , "red");
        System.out.println(colorBox);
    }
}
