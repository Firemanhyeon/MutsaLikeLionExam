package ch10.GenericExam;

public class GenericMethodExample {
    public static <T extends Number> T max(T a , T b , T c){
        T max=a;
        if(b.doubleValue()>max.doubleValue()){
            max=b;
        }
        if(c.doubleValue()>max.doubleValue()){
            max=c;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(max(1,2,3));
        System.out.println(max(0.1,0.2,0.3));
        System.out.println(max(1f,2f,3));
    }
}
