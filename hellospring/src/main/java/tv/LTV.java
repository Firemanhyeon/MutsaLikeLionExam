package tv;

public class LTV implements TV{
    //기능 끄다 켜다 볼륨up down
    @Override
    public void powerOn(){
        System.out.println("LTV를 켭니다");
    }
    @Override
    public void powerOff(){
        System.out.println("LTV를 끕니다");
    }
    @Override
    public void soundDown(){
        System.out.println("LTV소리를 낮춥니다");
    }
    @Override
    public void soundUp(){
        System.out.println("LTV소리를 높입니다.");
    }
}
