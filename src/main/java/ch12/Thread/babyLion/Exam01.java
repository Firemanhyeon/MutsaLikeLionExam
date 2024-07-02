package ch12.Thread.babyLion;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam01 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fw = new FileWriter("input.txt");
        ){
        System.out.println("입력하세요");
        while(true){
            String line = br.readLine();
            if ("exit".equals(line)) break;
            fw.write(line);
        }

        }catch(IOException e){

        }
    }
}
