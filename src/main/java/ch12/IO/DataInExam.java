package ch12.IO;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInExam {
    public static void main(String[] args) {
        try(DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"))) {
            int a = dis.readInt();
            System.out.println(a);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
