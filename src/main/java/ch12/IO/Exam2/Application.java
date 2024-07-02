package ch12.IO.Exam2;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        String filePath = "texts.txt";
        TextFileManager fileManager = new TextFileManager(filePath);
        UserInputHandler inputHandler = new UserInputHandler();
        //파일 읽어오기
        List<String> fileContent = fileManager.readFromFile();

        //입력받기
        fileContent = inputHandler.getUserInput(fileContent);
        //파일만들기
        fileManager.writeToFile(fileContent);

        //파일 읽어오기
        fileContent = fileManager.readFromFile();

        System.out.println("Content of the file:");
        fileContent.forEach(System.out::println);
    }
}