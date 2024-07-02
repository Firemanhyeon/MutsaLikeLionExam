package ch09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionExam03 {
    public static void main(String[] args) throws FileNotFoundException {
        //예외종류의 두가지
        //1.실행시 체크하는 예외 (RuntimeException)
        //2.컴파일시 체크하는 예외 (CheckedException)
        //예외처리의 두가지 방법
        //tryCatch
        //throws
        FileInputStream fls = new FileInputStream("abc");
    }
}
