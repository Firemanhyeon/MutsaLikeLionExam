package ch08;

public class Test {
    public static void main(String[] args) {
        Child child = new Child();
        String name = child.getName();
        System.out.println(name);

        System.out.println(child);
        System.out.println(child.toString());

        String str = "hello";

        System.out.println(str);
        System.out.println(str.toString());
        //String클래스에서 object객체에서 오버라이드한 toString을 쓴다.


        Product pdt = new Product("펜" , 3000);
        Product pdt2 = new Product("펜2", 1000);

        if(pdt.equals(pdt2)){
            System.out.println("같아요");
        }else{
            System.out.println("달라요");
        }

        System.out.println(pdt.hashCode());
        System.out.println(pdt2.hashCode());
    }
}
