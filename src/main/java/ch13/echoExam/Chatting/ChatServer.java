package ch13.echoExam.Chatting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChatServer {

    public static void main(String[] args) {
        //1.서버소켓을 생성
        try(ServerSocket serverSocket = new ServerSocket(9999);){
            System.out.println("서버가 준비되었습니다");
            //여러명의 클라이언트 정보를 기억할 공간의 자료구조가 필요하다.
            Map<String , PrintWriter> chatClients = new HashMap<String , PrintWriter>();
            while(true){
                Socket socket = serverSocket.accept();
                new ChatThread(socket , chatClients).start();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        //2.accept() 를 통해서 소켓을 얻어옴 (여러명의 클라이언트와 접속할 수 있도록 구현)
        //Thread 이용

    }

}
class ChatThread extends Thread {
    //생성자를 통해서 소켓을 얻어오게 해야한다.
    private Socket socket;
    private String id;
    private Map<String , PrintWriter> chatClients;
    private PrintWriter pw=null;
    private BufferedReader br=null;


    public ChatThread(Socket socket, Map<String, PrintWriter> chatClients) {
        this.socket = socket;
        this.chatClients = chatClients;

        //클라이언트가 생성 될 떄 클라이언트로부터 아이디를 얻어오게 하고싶다.
        try{
            pw = new PrintWriter(socket.getOutputStream() , true);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            id=br.readLine();
            //이때 모든 사용자에게 알린다. id님이 입장했습니다
            broadcast(id+"님이 입장하셨습니다");
            System.out.println("새로운 사용자의 아이디는 "+id+"입니다.");

            //동시에 일어날수도있다. 이럴때 대비해서 syncronized 사용(동기화)
            synchronized (chatClients){
                chatClients.put(this.id , pw);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    //run 각각 클라이언트와 통신 할 수 있는 통로를 얻어온다.
    //모든 클라이언트에게 전송을 하기 위해서 무엇을해야할까?
    @Override
    public void run() {
        //연결된 클라이언트가 메세지를 전송하면 그 메세지를 받아서 다른 사용자들에게 보내줌
        String msg = null;
        try{
            while((msg = br.readLine())!=null){
                if ("/quit".equalsIgnoreCase(msg))
                    break;
                if(msg.indexOf("/t")==0){
                    sendMsg(msg);
                }else{
                    broadcast(id+": "+msg);
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally {
            synchronized (chatClients){
                chatClients.remove(id);
            }
            broadcast(id+"님이 나갔습니다");
            System.out.println(id+"님이 나갔습니다.");
            if(pw!=null){
                pw.close();
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
//메세지를 특정 사용자에게만 보내는 메서드
    public void sendMsg(String msg){
        int firstSpaceIndex = msg.indexOf(" ");
        if(firstSpaceIndex == -1) return;//첫번째 공백이 없으면 리턴

        int secondSpaceIndex = msg.indexOf(" " , firstSpaceIndex+1);
        if(secondSpaceIndex == -1) return;//두번째공백이없다면 리턴 /to hh 안녕
        String to = msg.substring(firstSpaceIndex+1 , secondSpaceIndex);
        String message = msg.substring(secondSpaceIndex+1);

        //to(수신자)에게 메세지전송
        PrintWriter pw = chatClients.get(to);
        if(pw!=null){
            pw.println(id+"님으로부터 온 비밀메시지: "+message);
        }else{
            System.out.println("오류: 수신자 "+to+"가 없습니다.");
        }
    }





    //전체사용자에게 알려주는 메서드
    public void broadcast(String msg){
//        for(PrintWriter pw : chatClients.values()){
//            pw.println(msg);
//        }
        synchronized (chatClients){
            Iterator<PrintWriter> iter = chatClients.values().iterator();
            while(iter.hasNext()){
                PrintWriter pw = iter.next();
                try{
                    pw.println(msg);
                }catch (Exception e){
                    iter.remove();
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

