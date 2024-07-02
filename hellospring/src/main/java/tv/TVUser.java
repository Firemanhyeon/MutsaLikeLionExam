package tv;

public class TVUser {
    public static void main(String[] args) {
//        STV stv = new STV();
//        stv.powerOn();
//        stv.soundDown();
//        stv.soundUp();
//        stv.powerOff();
//STV가 고장이나서 LTV로 바꾸면 user에서도 코드를 전부 바꿔줘야한다.(STV와 user의 결합도가 높다)
//        LTV ltv = new LTV();
//        ltv.powerOn();
//        ltv.soundDown();
//        ltv.soundUp();
//        ltv.powerOff();

        //tv라는 인터페이스를 생성해서 STV에서 상속받는다면 한줄만 바꾸면 LTV로도 쉽게 바꿀 수 있다.(결합도가 낮다)
        //근데 뒤에 STV()를 바꾸는것도 싫다. 이것을 바꾸는것을 SpringIOC에게 맡기는것

        //TV tv = new STV();
        TV tv = TVFactory.getTV(args[0]);//TVFactory를 가져와서 값에따라 다르게 생성자를 만든다.(결합도가 더 낮아짐) IoC와 관련있음. 흐름에따라 코드가 흐름을 제어한다.
        tv.powerOn();
        tv.powerOff();
        tv.soundDown();
        tv.soundUp();
    }
}
