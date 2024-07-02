package ch12.IO.babyLion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOExam02 {
    public static void main(String[] args) {
        //문자열을 파일에다가 출력
        try(
            FileOutputStream fos = new FileOutputStream("output.txt");
            ){
            String output = "Hello Worl!!d!";
            fos.write(output.getBytes());

        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
