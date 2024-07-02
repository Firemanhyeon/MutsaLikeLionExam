package ch08;

public class TemplateMethodPatternDemo {
    public static void main(String[] args) {
        //템플릿메소드
        //차와 커피는 만드는과정은 비슷하지만 중간단계는 다르다. 그래서
        //공통되는 작업만 부모클래스에서 정의하고 일부단계를 서브클래스에서 구현하도록 하는것.
        //알고리즘의 구조를 부모메소드에 정의한다.final로
        BeverageRecipe tea = new Tea();
        tea.prepareRecipe();

        BeverageRecipe coffee = new Coffee();
        coffee.prepareRecipe();
    }
}
