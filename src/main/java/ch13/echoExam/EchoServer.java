package ch13.echoExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try(
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true)//autoFlush println수행할때 자동으로 flush()하겠다
            )
            {
                String request = null;
                while( (request = br.readLine()) != null ){
                    pw.println(request);
                    System.out.println("Server received: " + request);
                }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
