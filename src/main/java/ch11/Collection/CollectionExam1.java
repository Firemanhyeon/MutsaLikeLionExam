package ch11.Collection;

import java.util.ArrayList;

public class CollectionExam1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list.size());
        System.out.println(list);
        for(String str : list) {
            System.out.println(str);
        }
        //list.clear();
        System.out.println(list);
        list.set(0 , "1");
        System.out.println(list);
        list.remove("B");
        System.out.println(list);
        System.out.println(list.remove(0));
        System.out.println(list);
    }
}
