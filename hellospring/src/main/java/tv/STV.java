package tv;

public class STV implements TV{
    //기능 끄다 켜다 볼륨up down
    @Override
    public void powerOn(){
        System.out.println("STV를 켭니다");
    }
    @Override
    public void powerOff(){
        System.out.println("STV를 끕니다");
    }
    @Override
    public void soundDown(){
        System.out.println("STV소리를 낮춥니다");
    }
    @Override
    public void soundUp(){
        System.out.println("STV소리를 높입니다.");
    }
}
