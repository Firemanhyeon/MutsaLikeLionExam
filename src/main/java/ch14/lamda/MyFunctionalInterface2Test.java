package ch14.lamda;

public class MyFunctionalInterface2Test {
    public static void main(String[] args) {
        MyFunctionalInterface2 myFunctionalInterface2 ;

        myFunctionalInterface2 = new MyFunctionalInterface2() {
            @Override
            public void method1(int x) {
                int result = x+1;
                System.out.println(result);
            }
        };

       MyFunctionalInterface2 myFunctionalInterface3 = (int x )->{
            int result = x+1;
            System.out.println(result);
        };

        myFunctionalInterface3.method1(10);
    }
}
