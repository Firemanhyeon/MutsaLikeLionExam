package ch12.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WWWRead {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.naver.com");
            InputStream inputStream = url.openStream();
            //URL 에서 한줄 씩 입력받아서 출력해보세요.
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String msg ;
            while ((msg = reader.readLine()) != null) {

                System.out.println(msg);
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
