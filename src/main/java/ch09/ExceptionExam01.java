package ch09;

public class ExceptionExam01 {
    public static void main(String[] args) {
        int[] iarr = {1,2,3};

        try {

        System.out.println(iarr[3]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("오류발생");
            System.out.println(e.getMessage());
        }finally {
            System.out.println("다음문장");
        }
    }
}
