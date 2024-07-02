package ch13.echoExam.Chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        //아이디가 처음에 입력되게 하기 위해서 args[0]에서 받아오는것으로 구현.
        if(args.length != 1){
            System.out.println("사용법 : java ChatClient id");
            System.exit(1);
        }
        try(
                Socket socket = new Socket("14.38.151.15" , 12345);
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader keyboard= new BufferedReader(new InputStreamReader(System.in));
            ){
            //접속되면 아이디를 보낸다.(서버와의 약속)
            out.println(args[0]);

            //네트워크에서 입력된 내용을 담당하는 부분을 스레드로 구현
            new InputThread(socket , in).start();
            //출력을 담당하는 코드
            String msg = null;
            while((msg = keyboard.readLine()) != null){
                if("/quit".equals(msg)){
                    break;
                }

                out.println(msg);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

class InputThread extends Thread{
    private Socket socket;
    private BufferedReader in;

    InputThread(Socket socket , BufferedReader in){
        this.socket = socket;
        this.in = in;
    }

    @Override
    public void run() {
        try{
           String msg = null;
           while((msg = in.readLine()) != null){
               System.out.println(msg);
           }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
