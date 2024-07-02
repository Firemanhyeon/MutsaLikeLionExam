package ch12.Thread.babyLion;

import java.io.*;

public class Exam02 {
    public static void main(String[] args) {
        try(BufferedReader fr = new BufferedReader(new FileReader("sample.txt"))){
            String line;
            while ((line = fr.readLine()) != null) {
                System.out.println(line);
            }
        }catch(IOException e){

        }
    }
}
