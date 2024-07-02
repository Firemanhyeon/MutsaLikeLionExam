package ch07;

public class DiceTest {
    public static void main(String[] args) {
        Dice dice = new Dice(6);
        dice.roll();
        System.out.println(dice.getEye());
    }
}
