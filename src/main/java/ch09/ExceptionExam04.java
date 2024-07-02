package ch09;

public class ExceptionExam04 {
    static void 심부름(){
        //예외를 직접
        System.out.println("심부름 시작!");

        int i=0;
        System.out.println(10/i);
        System.out.println("심부름끝");
    }

    public static void main(String[] args) {
        try {
            심부름();
        }catch (Exception e){
            System.out.println("동생에게 시킴");
        }
    }
}
