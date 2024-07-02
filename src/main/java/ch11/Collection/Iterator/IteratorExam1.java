package ch11.Collection.Iterator;

import java.util.*;

public class IteratorExam1 {
    public static void main(String[] args) {
        List<String>list = new ArrayList<>();
        list.add("사과");
        list.add("Java");
        list.add("Python");
        list.add("C++");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
