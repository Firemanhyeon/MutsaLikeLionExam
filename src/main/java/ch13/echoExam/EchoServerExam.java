package ch13.echoExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerExam {
    public static void main(String[] args) throws Exception {
//      socket.getOutputStream(); //클라이언트의 출력
//      socket.getInputStream();
        System.out.println("서버가 준비되었습니다.");
        try( //1.ServerSocket 객체생성
             ServerSocket serverSocket = new ServerSocket(9999);//port값을 생성자로 보내야한다.
             Socket socket = serverSocket.accept();//클라이언트의 소켓을 받아온것.  클라이언트 연결 수락
             //2.데이터 읽기 및 쓰기 (데이터를 읽고 쓸 통로를 구현하기)
             //입력통로
            //클라이언트의 출력이 서버의 입력이 된다.
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //출력통로
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));)
        {
            System.out.println(socket.getInetAddress().getHostAddress()+" 로부터 연결되었습니다.");//클라이언트의 ip 주소값 가져오기
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println("클라이언트에서 받은 메세지: "+ line);

                //클라이언트에서 받은 메시지를 그대로 다시 클라이언트에게 보낸다.
                pw.println(line);
                pw.flush();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
