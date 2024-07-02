package ch12.IO;

import java.io.*;

public class BuffredExam {
    public static void main(String[] args) {
        //키보드로부터 한줄씩 5번 입력 받아서 파일에 출력하는 프로그램을 작성하세요

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fos = new FileWriter("d.txt");
            ) {
            String[] input = new String[5];
            int count=0;
            while(count<5){
                String str = reader.readLine();
                input[count] = str;
                count++;
            }
            //파일쓰기
            for(int i=0;i<input.length;i++){
                System.out.println(input[i]);
                fos.write(input[i]+"\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
