package ch12.Thread.Exam1;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileWriterTask extends Thread {
    @Override
    public void run() {
        try(BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fw = new FileWriter("output.txt");){
            while (true) {
                System.out.println("텍스트를 입력하세요 그만하시려면 0을 입력하세요");
                String input = bw.readLine();
                if(input.equals("0")){
                    break;
                }else{
                    fw.write(input+"\n");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
