package ch08;

public class Dimpl implements Dinter{
    @Override
    public void dInter() {
        System.out.println("d메소드구현");
    }

    @Override
    public void aMethod() {
        System.out.println("a메소드구현");
    }

    @Override
    public void same() {
        System.out.println("same메소드구현");
    }

    @Override
    public void cMethod() {
        System.out.println("c메소드구현");
    }

    @Override
    public void bMethod() {

    }
}
