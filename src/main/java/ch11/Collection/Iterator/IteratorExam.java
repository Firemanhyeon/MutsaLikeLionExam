package ch11.Collection.Iterator;

import java.util.*;

public class IteratorExam {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("=========================");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("=========================");
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        Iterator<String> iter = set.iterator();

        for(String s : set){
            System.out.println(s);
        }

    }

}
