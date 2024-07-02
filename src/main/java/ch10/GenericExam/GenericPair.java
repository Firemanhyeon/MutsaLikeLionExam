package ch10.GenericExam;

import ch10.innerClass.Book;

public class GenericPair<T1,T2> {
    private T1 first;
    private T2 second;

    public GenericPair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }

    public static void main(String[] args) {
        GenericPair<String , Integer> genericPair = new GenericPair<String , Integer>("안녕",1);
        String a = genericPair.getFirst();
        Integer b = genericPair.getSecond();
        Book book = new Book("Book Title");
        book.setAuthorName("123"); // Book 클래스에 있는 setAuthorName 메소드를 사용하여 접근
        GenericPair<Book, String> genericPair1 = new GenericPair<>(book, "11");
    }
}
