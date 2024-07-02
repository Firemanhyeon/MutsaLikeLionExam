package ch12.IO.FIle;

import java.io.File;

public class FileExam {
    public static void main(String[] args) {
        //파일들을 가져와서 파일들의 리스트를 가져온다.
        File dir = new File("./src/main/java");
        String[] files=dir.list();
        for (String file : files) {
            System.out.println(file);
        }
    }
}
