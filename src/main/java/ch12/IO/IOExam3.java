package ch12.IO;

import java.io.*;

public class IOExam3 {
    public static void main(String[] args) {
        //"a.txt" 파일에서부터 한줄씩 입력받아 입력받은 문자뒤에 hi를 추가해서 "b.txt" 파일에 출력하는 프로그램.
        try(BufferedReader fr = new BufferedReader(new FileReader("b.txt"));
            PrintWriter fw = new PrintWriter("d.txt");)
        {
            String c;
            while((c=fr.readLine())!=null){
                fw.println(c+" hi");

            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
