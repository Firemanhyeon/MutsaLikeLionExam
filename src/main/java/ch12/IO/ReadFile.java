package ch12.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadFile {
    public static void main(String[] args) throws Exception{
        System.out.println(System.getProperty("user.dir"));

        FileInputStream fis = new FileInputStream("src/main/java/ch12/IO/readFile.java");//파일 읽어오기
        FileOutputStream fos = new FileOutputStream("b.txt");//파일쓰기

        int n;
//        byte[] bytes = new byte[1024];//바이트배열만큼 가져와서 바이트만큼 가져오기
//        while((n= fis.read(bytes)) !=-1){//한줄 읽어서 바이트만큼 가져오기
//            String str = new String(bytes);
////            System.out.println(str);
//            fos.write(bytes);
//        }
          while((n = fis.read())!=-1){
              System.out.println((char)n);
              fos.write(n);
          }
        fos.close();
        fis.close();
    }
}
