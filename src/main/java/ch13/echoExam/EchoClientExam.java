package ch13.echoExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClientExam {
    public static void main(String[] args) throws Exception {
        //1. socket생성
        Socket socket = new Socket("127.0.0.1",9999);
        System.out.println(9999+"포트와 연결되었습니다.");

        //2.데이터 읽고 쓰기
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));//서버에서 보낸거 읽기
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));//서버로보내기

        //3.클라이언트가 키보드를 통해 입력하기위한 통로
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String line =null;
        while ((line = keyboard.readLine()) != null) {
            if(line.equalsIgnoreCase("exit")){
                break;
            }
            //서버에게 보냄
            pw.println(line);
            pw.flush();

            //서버에서 받음
            String echo = br.readLine();
            System.out.println("서버로부터 받은 응답메시지: "+ echo);
        }
        String echo = br.readLine();
        System.out.println("서버로부터 받은 응답메시지: "+ echo);

        pw.close();
        br.close();
        keyboard.close();
        socket.close();
    }
}
