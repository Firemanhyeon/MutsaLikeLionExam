package annotation;

import java.lang.reflect.Method;

public class ServiceRun {
    public static void main(String[] args) throws Exception{
        Method[] methods = ServiceRun.class.getDeclaredMethods();

        Service service = new Service();
        for (Method method : methods) {
            if(method.isAnnotationPresent(PrintAnnotation.class)){
                System.out.println("[[[[[[[[[[[[[[["+method.getName()+"]]]]]]]]]]]]");
               PrintAnnotation printAnnotation= method.getAnnotation(PrintAnnotation.class);
                for(int i=0;i< printAnnotation.number();i++){
                    System.out.println(printAnnotation.value());
                }
                System.out.println();
            }
            method.invoke(service);
        }
    }
}
