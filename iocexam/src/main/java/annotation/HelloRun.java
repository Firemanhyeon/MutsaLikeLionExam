package annotation;

import java.lang.reflect.Method;

public class HelloRun {
    public static void main(String[] args) throws Exception{
        Hello hello = new Hello();
        Method method = hello.getClass().getDeclaredMethod("print");
        if(method.isAnnotationPresent(Count100.class)){
            System.out.println(123);
        }else{
            System.out.println(456);
        }
        hello.print();
    }
}
