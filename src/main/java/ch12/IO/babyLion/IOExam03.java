package ch12.IO.babyLion;

import java.io.*;

public class IOExam03 {
    public static void main(String[] args) {
        //파일에서부터 한줄씩 읽어서 콘솔에 출력하는 코드

        try(BufferedReader br = new BufferedReader(new FileReader("tests.txt"));
            PrintWriter pw = new PrintWriter("pwOutput.txt" );
        ){
            String line;
            while((line=br.readLine())!=null){
                System.out.println(line);
                pw.println(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
