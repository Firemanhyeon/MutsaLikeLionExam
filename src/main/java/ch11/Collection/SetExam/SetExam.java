package ch11.Collection.SetExam;

import java.util.HashSet;
import java.util.Set;

public class SetExam {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");

        for (String s : set) {
            System.out.println(s);
        }

        Set<Pen>set1 = new HashSet<>();
        set1.add(new Pen("red"));
        set1.add(new Pen("yellow"));
        set1.add(new Pen("black"));
        System.out.println(set1);
        set1.add(new Pen("red"));//red가 중복인데 중복이라고 인지를 못한다.  왜나햐면 각각 다른 객체이기때문이다.
        // 해당값들은 같은 요소다 라고 정의해주기 위해서 hashcode and equals해준다.
        System.out.println(set1);
        if(set1.contains(new Pen("red"))){
            System.out.println("있음");
        }
    }
}
