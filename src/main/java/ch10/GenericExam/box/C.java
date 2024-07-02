package ch10.GenericExam.box;

public class C <T,C> extends Box<T> {
    private C color;
    public C(T content , C color){
        super(content);
        this.color = color;
    }
    public C getColor(){
        return color;
    }

    @Override
    public String toString() {
        return "C{" +
                "color=" + color +
                '}'+"containing " + getContent();
    }
}
