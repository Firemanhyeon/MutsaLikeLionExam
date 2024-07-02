package ch07;

public class Bus extends Car{

    public Bus(){
        System.out.println("bus생성자실행");
    }

    public Bus(String name){
        super(name);//부모생성자에 있기때문에 밑에꺼는 생략해도된다.
        //this.name = name;
        System.out.println("bus생성자(String name)실행");
    }
}
