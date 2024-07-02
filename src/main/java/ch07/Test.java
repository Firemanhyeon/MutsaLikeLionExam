package ch07;

public class Test {
    public static void main(String[] args) {
        MathBean mathBean = new MathBean();
        mathBean.printClassName();


        ClassA classA = new ClassA();
        System.out.println(ClassA.fieldA);
        System.out.println(classA.fieldB);

        System.out.println(classA.count);
        System.out.println(classA.name);
        System.out.println(classA.number);

        ClassB classB  = new ClassB();
        classB.print();

    }
}
