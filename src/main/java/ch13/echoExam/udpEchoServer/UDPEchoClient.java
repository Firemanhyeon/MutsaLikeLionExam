package ch13.echoExam.udpEchoServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {
    public static void main(String[] args) {
        try(
                DatagramSocket socket = new DatagramSocket(8888);
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        ){
        //서버 주소 설정
            InetAddress address = InetAddress.getByName("localhost");//
            byte[] sendData;
            byte[] receiveData = new byte[1024];
            //보낼데이터는 키보드로부터 입력받아서 보낸다.
            System.out.println("보낼메세지를 입력하세요");
            String message = keyboard.readLine();
            DatagramPacket sendPacket = new DatagramPacket(message.getBytes() , message.getBytes().length,address , 8888);
            socket.send(sendPacket);

            //서버로부터 받기
            DatagramPacket recievePacket = new DatagramPacket(receiveData , receiveData.length);
            socket.receive(recievePacket);
            String msg = new String(recievePacket.getData()).trim();
            System.out.println(msg);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
