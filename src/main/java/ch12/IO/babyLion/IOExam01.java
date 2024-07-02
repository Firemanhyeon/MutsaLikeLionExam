package ch12.IO.babyLion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class IOExam01 {
    public static void main(String[] args) {
        //파일로부터 읽어와서 콘솔에 출력하는 코드를 작성해보세요
        try (FileInputStream fis = new FileInputStream("lion.txt");){
            int a ;
            int count=0;

//            while((a=fis.read())!=-1){
//                count++;
//                System.out.print((char)a);
//            }
            byte[] b = new byte[fis.available()];
            while((a=fis.read(b))!=-1){
                count++;
                String s = new String(b,0,a);
                System.out.println(s);
            }
            System.out.println(count);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
