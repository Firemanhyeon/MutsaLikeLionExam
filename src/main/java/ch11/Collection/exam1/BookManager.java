package ch11.Collection.exam1;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class BookManager {

    Map<String , Book> books = new HashMap<>();

    //추가
    public void addBook(Book book) {
        books.put(book.getTitle(), book);
        System.out.println("Added Book: " + book.getTitle());
    }
    //삭제
    public void removeBook(Book book) {
        books.remove(book.getTitle());
        System.out.println(book.getTitle()+"이 삭제되었습니다");
    }
    //검색
    public void getBooks() {
        System.out.println("검색할 도서 이름을 적어주세요");
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        if(books.containsKey(title)) {
            System.out.println("찾으시는 책의 정보입니다.");
            System.out.println(books.get(title));
        }else{
            System.out.println("찾으시는 책이 없습니다.");
        }
    }

    public void displayBooks() {
        System.out.println("도서전체목록");
        for(Map.Entry<String , Book> entry : books.entrySet()) {
            System.out.println(entry.getValue().getTitle() +" "+ entry.getValue().getAuthor()+" "+ entry.getValue().getYear());
        }

    }
    public void sortBooksByYear() {
        System.out.println("년도별 정리");
        List<Book> bookList = new ArrayList<>(books.values());
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o1.getYear(), o2.getYear());
            }
        });
        for(Book book : bookList) {
            System.out.println(book.getTitle()+" "+book.getAuthor()+" "+book.getYear());
        }
    }



}
