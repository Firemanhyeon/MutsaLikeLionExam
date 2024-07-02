package ch11.Collection.Comparable;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(){

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name+" : "+age;
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("kang" , 50));
        people.add(new Person("kim" , 20));
        people.add(new Person("hong" , 30));
        people.add(new Person("kung" , 40));

        System.out.println(people);
        Collections.sort(people);
        System.out.println(people);

        //정렬의 두가지방법
        //1.직접 생성해서 넣어주는 방법 : Comparator 사용
        Collections.sort(people,new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });
    }

    //2.Comparable<Person> 을 implements해서 메소드 오버라이딩을 통해 재정의해서 자기가 원하는대로 정렬기준을 정할 수 있다.
    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}
