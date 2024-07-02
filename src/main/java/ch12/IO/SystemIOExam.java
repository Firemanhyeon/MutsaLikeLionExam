package ch12.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemIOExam {
    public static void main(String[] args) {
        //키보드로부터 한줄 입력받기 위한 IO객체를 생성.
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("문자열을 입력하세요");
            String userInput = reader.readLine();

            System.out.println("입력받은 문자열: "+userInput);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
