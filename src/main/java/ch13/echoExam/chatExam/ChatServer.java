package ch13.echoExam.chatExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {
    private static Set<PrintWriter> set = new HashSet<>();
    private static final int PORT = 44444;
    public static void main(String[] args) throws Exception {
        //여러개의 사용자들이 사용하는 서버 만들기
        //1.ServerSocket생성 (1개만 있으면 됨.)
        System.out.println("채팅이 시작되었습니다.");
        ServerSocket serverSocket = new ServerSocket(PORT);
        try{
            while(true){
                new ChatThread(serverSocket.accept()).start();
            }
        }finally{
            serverSocket.close();
        }
    }

    private static class ChatThread extends Thread{
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        ChatThread(Socket socket ){
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println(socket.getInetAddress().getHostAddress()+"로 부터 연결되었습니다.");
            try{
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new PrintWriter(socket.getOutputStream(),true);

                synchronized (set){
                    System.out.println("유저등록");
                    set.add(out);
                    System.out.println("채팅방유저수: "+ set.size());
                }


                String input;
                while((input = in.readLine()) != null){
                    synchronized (set){
                        for(PrintWriter writer : set){
                            writer.println(input);
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(out !=null){
                    synchronized (set){
                        System.out.println("유저가 나갔습니다.");
                        set.remove(out);
                    }
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}