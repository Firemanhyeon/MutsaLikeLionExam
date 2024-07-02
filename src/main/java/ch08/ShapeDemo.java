package ch08;

public class ShapeDemo {
    public static void main(String[] args) {
        삼각형 triangle = new 삼각형(10, 5);
        System.out.println("삼각형의 너비: " + triangle.너비계산());

        사각형 rectangle = new 사각형(10, 20);
        System.out.println("사각형의 너비: " + rectangle.너비계산());
    }
}