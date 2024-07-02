package ch10.GenericExam.container;

public class IntegerContainer implements Container<Integer> {
        Integer value;
    @Override
    public void set(Integer value) {
        this.value = value;
    }

    @Override
    public Integer get() {
        return value;
    }
}
