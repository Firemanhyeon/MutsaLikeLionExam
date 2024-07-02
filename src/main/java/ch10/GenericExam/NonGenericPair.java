package ch10.GenericExam;

public class NonGenericPair {
    private Object first;
    private Object second;


    public NonGenericPair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() {
        return first;
    }

    public void setFirst(Object first) {
        this.first = first;
    }

    public Object getSecond() {
        return second;
    }

    public void setSecond(Object second) {
        this.second = second;
    }

    public static void main(String[] args) {
        NonGenericPair nonGenericPair = new NonGenericPair("Hello",5);
        String first = (String) nonGenericPair.getFirst();//강제형변환이 필요하다
        int second = (int) nonGenericPair.getSecond();//강제형변환이 필요하다

        NonGenericPair nonGenericPair2 = new NonGenericPair(1.2f,"안녕");
        float firstFloat = (float) nonGenericPair2.getFirst();//제네릭을 써주지않으면 형변환을 매번 해주어야한다.
        String secondFloat = (String) nonGenericPair2.getSecond();
    }
}
