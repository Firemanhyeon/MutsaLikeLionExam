package ch09.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banker {
    private String name;
    private String id;



    public Banker(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean access(){
        System.out.println("1. 출금 승인 2.출금 거절");
        Scanner scanner = new Scanner(System.in);
        int num= scanner.nextInt();
        if(num==1){
            return true;
        }else{
            return false;
        }
    }
    public boolean access1(){
        System.out.println("1.통장개설 승인 2.통장개설 거절");
        Scanner scanner = new Scanner(System.in);
        int num= scanner.nextInt();
        if(num==1){
            return true;
        }else{
            return false;
        }
    }


}
