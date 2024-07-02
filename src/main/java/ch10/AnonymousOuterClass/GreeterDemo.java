package ch10.AnonymousOuterClass;

public class GreeterDemo {
    public static void main(String[] args) {

        Greeter morningtreter = new Greeter() {//익명ㅇ객체
            @Override
            public void greet() {
                System.out.println("좋은아침입니다");
            }
        };

        Greeter eveningtreter = new Greeter() {

            @Override
            public void greet() {
                System.out.println("좋은저녁입니다");
            }
        };

        morningtreter.greet();
        eveningtreter.greet();
    }
}
