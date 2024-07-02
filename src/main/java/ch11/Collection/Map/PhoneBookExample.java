package ch11.Collection.Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PhoneBookExample {
    public static void main(String[] args) {
        Map<String,String> phoneBook = new HashMap<>();

        phoneBook.put("Mike","123");
        phoneBook.put("John","456");
        phoneBook.put("Jane","789");

        String number = phoneBook.get("Mike");
        System.out.println(number);

        //전체전화번호 목록 출력
        System.out.println("전체전화번호");
        for(Map.Entry<String,String>entry : phoneBook.entrySet()){//entrySet메소드를 활용해 phoneBook의 모든항목을 순회하며 키와 값을 출력한다.
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        //데이터삭제
        phoneBook.remove("Mike");
        System.out.println("전체전화번호");
        for(Map.Entry<String,String>entry : phoneBook.entrySet()){//entrySet메소드를 활용해 phoneBook의 모든항목을 순회하며 키와 값을 출력한다.
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        //특정 키 존재여부
        if(phoneBook.containsKey("John")){
            System.out.println("존재해요");
        }
        //특정 값 존재여부
        if(phoneBook.containsValue("John")){
            System.out.println("존재해요");
        }else {
            System.out.println("존재하지않아요");
        }

        //Map이 비었는지 확인
        System.out.println("비었어요?"+ phoneBook.isEmpty());
        //map크기확인
        System.out.println("크기: "+ phoneBook.size());
        //읽기전용 리스트 생성
        Map<String , String> list =Collections.unmodifiableMap(phoneBook);
        System.out.println(list);
    }
}
