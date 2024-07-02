package ch11.Collection.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        System.out.println(map.get(1));

        Set<Integer> set = map.keySet();//키값을 Set타입으로 반환한걸 set에 담는다
        Iterator<Integer> iterator = set.iterator();//이터레이터선언
        while (iterator.hasNext()) {//빼낸다.
            Integer key = iterator.next();
            System.out.println(key + ": " + map.get(key));
        }
    }
}
