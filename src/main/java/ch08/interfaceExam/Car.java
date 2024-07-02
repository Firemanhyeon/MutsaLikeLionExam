package ch08.interfaceExam;

public class Car implements Vehicle{

    private int speed;


    @Override
    public void accelerate(int speed) {
        this.speed +=speed;
        if(speed> MAX_SPEED){

        }
    }

    @Override
    public void decelarate(int speed) {

    }
}
