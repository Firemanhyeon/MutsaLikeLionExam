package ch12.IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamExam {
    public static void main(String[] args) {
        //char단위 입출력스트림
        try(FileReader reader = new FileReader("a.txt");
        FileWriter writer = new FileWriter("C.txt");
        ){
          int c;
          while((c = reader.read()) != -1) {
              writer.write(c);
          }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
