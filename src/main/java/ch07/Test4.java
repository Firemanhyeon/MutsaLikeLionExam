package ch07;

public class Test4 {
    public static void main(String[] args) {
        Parent c = new Child();

        System.out.println(c.getI());
        System.out.println(c.i);
//        System.out.println(((Child)c).getI(29));
    }
}
