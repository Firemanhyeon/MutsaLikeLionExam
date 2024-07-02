package ch08.interfaceExam;

public interface Calculator {
    int add(int a, int b);
    int minus(int a, int b);

    static void light(){
        System.out.println("불을 밝히다");
    }
}
