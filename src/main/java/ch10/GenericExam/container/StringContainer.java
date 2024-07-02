package ch10.GenericExam.container;

public class StringContainer implements Container<String>{
    String value;
    @Override
    public void set(String value) {
        this.value = value;
    }

    @Override
    public String get() {
        return value;
    }


}
