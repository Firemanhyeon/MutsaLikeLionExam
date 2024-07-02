package ch10.GenericExam.container;

public interface Container <T>{

    //메소드선언
    void set(T value);
    T get();
}
