package ch10.GenericExam;

public class GenericMethod {
    public static <T> void printArrayElements(T[] array){
        for(T element : array){
            System.out.println(element);
        }

    }

    public static void main(String[] args) {
        Integer[] iArray = {1,2,3,4,5};
        printArrayElements(iArray);
        String[] strArray = {"A","B","C","D","E","F"};
        printArrayElements(strArray);
    }
}
