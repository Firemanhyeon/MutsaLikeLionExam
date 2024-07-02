package ch12.IO;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutExam {
    public static void main(String[] args) {
        //원시데이터타입으로 파일에 쓰고싶다
        try(
        FileOutputStream fos = new FileOutputStream("data.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        //똑같다 DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
        ){
            dos.writeInt(1);
            dos.writeBoolean(true);
            dos.writeChar('a');
            dos.writeDouble(1.1);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
