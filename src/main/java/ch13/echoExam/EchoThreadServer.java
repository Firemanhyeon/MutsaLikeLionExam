package ch13.echoExam;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EchoThreadServer {
    public static void main(String[] args) {
        //여러개의 사용자들이 사용하는 서버 만들기
        //1.ServerSocket생성 (1개만 있으면 됨.)
        try(
            ServerSocket serverSocket = new ServerSocket(9999);

            ){

            while(true){
                Socket clientSocket = serverSocket.accept();
                EchoThread echoThread = new EchoThread(clientSocket);
                echoThread.start();
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class EchoThread extends Thread{
    private Socket socket;

    EchoThread(Socket socket ){
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println(socket.getInetAddress().getHostAddress()+"로 부터 연결되었습니다.");
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
            ){



            String input=null;
            while((input = br.readLine()) != null){
                System.out.println("클라이언트로부터 받은 메세지:"+input);
                pw.println(input);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
