package ch14.lamda;
class MyFunctionalInterfaceImpl implements MyFunctionalInterface{
    @Override
    public void method1() {
        System.out.println("Impl method 1 call");
    }

    @Override
    public void method2(int a, int b) {
        System.out.println("Impl method 2 call");
    }
}
public class MyFunctionalInterfaceTest {
    public static void main(String[] args) {
        MyFunctionalInterface myFunctionalInterface;
        MyFunctionalInterfaceImpl myFunctionalInterfaceImpl = new MyFunctionalInterfaceImpl();
        myFunctionalInterface = new MyFunctionalInterface() {
            @Override
            public void method1() {
                System.out.println("method 1 call");
            }

            @Override
            public void method2(int a, int b) {
                System.out.println("method 2 call");
            }
        };
        myFunctionalInterface.method1();
        myFunctionalInterfaceImpl.method2(1,2);

        //myFunctionalInterface = ()-> System.out.println("lamda method1");//인터페이스가 가지고있는 메소드가 두개가 있기 때문에 람다표현식을 사용할 수 없다.
    }
}
