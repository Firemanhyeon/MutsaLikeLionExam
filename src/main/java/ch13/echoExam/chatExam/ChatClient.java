package ch13.echoExam.chatExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        try(Socket socket = new Socket("127.0.0.1", 44444);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            ){

            Thread clientThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        String input=null;
                        while((input=in.readLine())!=null){
                            System.out.println("서버에서받은 메세지:" + input);
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            });
            clientThread.start();

            String message;
            while(true){
                System.out.println("메세지입력");
                 message=keyboard.readLine();
                if("exit".equalsIgnoreCase(message)){
                    break;
                }
                out.println(message);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
