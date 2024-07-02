package ch09;


// Main.java 파일
public class Main {
    public static void main(String[] args) {
        String encryptionKey = SecurityConfig.getEncryptionKey();
        System.out.println("암호화 키: " + encryptionKey);
    }
}


