package ch12.IO.Exam1;

import java.io.*;

public class IOExam {
    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter bw = new PrintWriter("consumer.txt");)
        {
            for(int i=0;i<3;i++){
                System.out.println("이름");
                String name = br.readLine();
                System.out.println("전화번호");
                String number = br.readLine();
                String data = name.concat(" "+number);
                bw.println(data);
            }


        }catch(IOException e){
            e.printStackTrace();
        }
        try(BufferedReader br1 = new BufferedReader(new FileReader("consumer.txt"));){
            String data1 = br1.readLine();
            System.out.println(data1);
            while((data1 = br1.readLine())!=null){
                System.out.println(data1);
            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
