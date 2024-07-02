package ch12.IO;

import java.io.*;

public class IOExam2 {
    public static void main(String[] args) throws IOException {
        //키보드로부터 한줄씩 입력 받아서 콘솔에 출력하고 싶다.

        //키보드 System.in
        //한줄씩 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //한줄씩 읽을건데 파일로부터 읽겠다
        BufferedReader br2 = new BufferedReader(new FileReader("a.txt"));

        String str = br.readLine();


        FileOutputStream fos = new FileOutputStream("b.txt");
        fos.write(str.getBytes());

        System.out.println(str);
        System.out.println(br2.readLine());
    }
}
