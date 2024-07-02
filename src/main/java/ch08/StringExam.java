package ch08;

public class StringExam {
    public static void main(String[] args) {
        //불변객체
        //String 클래스
        String str1 ="hello";//문자열만 저장할수있는 장소에 hello를 저장한다.
        String str2 = "hello";//새로운 값을 저장하는게 아니라 str1이 가리키고있는 hello를 똑같이 가리킨다.
        String str3 = new String("hello");//3과 4는 각각 만들어진다.
        String str4 = new String("hello");

        if(str1 == str2){//같은곳을 가리키고있기 때문에 같다고나온다.
            System.out.println("같아요");
        }else{
            System.out.println("달라요");
        }

        if(str3 == str4){//가리키는 주소가 달라서 다르다고나온다.
            System.out.println("같아요");
        }else{
            System.out.println("달라요");
        }



        if(str1.equals(str2)){//같다고나온다.
            System.out.println("같아요");
        }else{
            System.out.println("달라요");
        }

        if(str3.equals(str4)){//같다고나온다.
            System.out.println("같아요");
        }else{
            System.out.println("달라요");
        }

        System.out.println(str1.concat("hihihii"));
        System.out.println(str1);
    }
}
