package ch12.Thread.Exam1;

public class Main {
    public static void main(String[] args) {
        FileReaderTask fileReaderTask = new FileReaderTask();
        FileWriterTask fileWriterTask = new FileWriterTask();
        fileReaderTask.start();
        fileWriterTask.start();
    }
}
