package ch12.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExam {
    public static void main(String[] args) {
        //파일로부터 읽어서
        //파일에 쓴다
        //읽는애 쓰는애 같이 쓸 수 없다.
        //읽는애 = 입력통로필요
        //쓰는애 = 출력통로 필요

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis= new FileInputStream("src/main/java/ch12/IO/ReadFile.java");
            fos= new FileOutputStream("outputFile.txt");
            int c;
            while((c=fis.read())!=-1){//read메소드를 이용하면 한바이트씩 받아올텐데 그 바이트를 c에 담는다 . 바이트로 비교할때만 없으면 -1를 리턴한다.
                fos.write(c);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fis != null) {
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try{
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
