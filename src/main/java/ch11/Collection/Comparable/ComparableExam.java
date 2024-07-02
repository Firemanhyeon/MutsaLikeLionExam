package ch11.Collection.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExam {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("a");
        list.add("c");
        list.add("d");

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
