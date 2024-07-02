package ch07;
class P{
    int i =5;
    int getI(){
        return i;
    }
}
class C extends  P{
    int i =10;
    int getI(){
        return i;
    }
    void printI(){
        System.out.println(i);
    }
}
public class Test8 {
        static void test(P p){
            System.out.println(p.i);
            System.out.println(p.getI());
            ((C)p).printI();
        }
    public static void main(String[] args) {
        C c = new C();
        test(c);
        System.out.println("=========");
        P pc = new C();
        test(pc);
        System.out.println("==========");
        P p = new P();
        test(p);
    }
}
