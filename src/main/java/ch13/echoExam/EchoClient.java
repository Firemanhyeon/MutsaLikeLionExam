package ch13.echoExam;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
    public static void main(String[] args) {
        try(
                Socket socket = new Socket("127.0.0.1", 9999);
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            ){
                String input = null;
                while((input = keyboard.readLine()) != null) {
                    if("exit".equalsIgnoreCase(input.trim())) {//nullpointException을 발생시키지않는다.
                        break;
                    }
                    pw.println(input);

                    String read = br.readLine();
                    System.out.println("서버로부터 받은 응답메세지:" + read);
                }


        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
