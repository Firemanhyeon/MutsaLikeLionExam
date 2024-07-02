package ch12.IO.Exam2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UserInputHandler {
    //사용자 입력
    public List<String> getUserInput(List<String> list) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){

            while (true) {
                System.out.println("텍스트를 입력하세요 그만하시려면 0을 입력하세요");
                String input = br.readLine();
                System.out.println(list.toString());
                if(input.equals("0")){
                    return list;
                }else{
                    list.add(input);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;

    }
}
