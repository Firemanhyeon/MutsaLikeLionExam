package ch12.IO.Exam2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class TextFileManager {
    String txt ;

    public TextFileManager(String txt) {
        this.txt = txt;
    }

    //파일쓰기
    public void writeToFile(List<String> userInput) {
        try(FileWriter fw = new FileWriter("tests.txt");) {
            for(String s : userInput) {
                fw.write(s+"\n");
            }
            System.out.println("파일저장이 완료되었습니다");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    //파일읽기
    public List<String> readFromFile() {
        List<String> list = new ArrayList<String>();
        try(BufferedReader br = new BufferedReader(new FileReader("tests.txt"));)
        {
            String line ;
            while((line = br.readLine()) != null) {
                list.add(line);
            }
            return list;
        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
