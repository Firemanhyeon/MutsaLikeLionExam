package ch07;

public class Lotto {
    private int[] num = new int[45];

    public void insert(){
        for(int i=0;i<num.length;i++){
            num[i]=i+1;
        }
    }
    public void combine(){
        for(int i=0;i<100;i++){
            int ran = (int)(Math.random()*45);
            int ran1=(int)(Math.random()*45);
            int temp = num[ran];
            num[ran]=num[ran1];
            num[ran1]=temp;
        }
    }
    public void getNum(){
        for(int i=0;i<6;i++){
            System.out.println(num[i]);
        }
    }
}
