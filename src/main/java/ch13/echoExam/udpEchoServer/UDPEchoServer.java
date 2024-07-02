package ch13.echoExam.udpEchoServer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoServer {
    public static void main(String[] args) {
        //UDP통신 특정 port에 DatagramScocket 생성
        try(DatagramSocket socket = new DatagramSocket(8888);){

            while(true){
                byte[] recieveData = new byte[1024];
                byte[] sendData;
                DatagramPacket recivePacket = new DatagramPacket(recieveData  , recieveData.length);//패킷하나만들어서준비
                socket.receive(recivePacket);//클라이언트로부터 데이터를 얻는다

                String message = new String(recivePacket.getData()).trim();//얻은 데이터를 다시 보내야하기때문에 싸준다.
                InetAddress clientAdress = recivePacket.getAddress();
                int port = recivePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(message.getBytes() , message.getBytes().length , clientAdress , port);
                socket.send(sendPacket);//클라이언트한테 데이터를 보내는 방법
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
