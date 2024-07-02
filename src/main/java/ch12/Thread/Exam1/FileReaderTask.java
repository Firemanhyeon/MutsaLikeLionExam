package ch12.Thread.Exam1;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileReaderTask extends Thread {
    @Override
    public void run() {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line ;
            while ((line = br.readLine()) != null) {
                System.out.println("파일읽기: "+line);
                Thread.sleep(1000);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}
