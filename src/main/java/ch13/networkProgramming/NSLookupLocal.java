package ch13.networkProgramming;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookupLocal {
    public static void main(String[] args) {
        try {
            InetAddress localAddress = InetAddress.getLocalHost();//호스트이름 , IP주소에 대한 InetAddress객체 반환
            System.out.println(localAddress.getHostName());
            System.out.println(localAddress.getHostAddress());

            System.out.println("byte[] 형식의 ip 주소 변환 ");
            byte[] ip = localAddress.getAddress();
            for (int i = 0; i < ip.length; i++) {
                System.out.println(ip[i] & 0xFF);
                if (i != ip.length - 1)
                    System.out.println(".");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
