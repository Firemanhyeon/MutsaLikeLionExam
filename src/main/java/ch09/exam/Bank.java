package ch09.exam;

import java.util.ArrayList;
import java.util.List;

public class Bank<T extends Account> {
    private String name ;
    private List<T> list = new ArrayList<T>() ;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }
    public String make(String name) throws MyException {
            String str = "";
            boolean check = true;
            str = String.valueOf((int)(1+Math.random()*2));
            System.out.println(str);
            for(int i=0;i<list.size();i++){
                if(list.get(i).getNumber().equals(str)){
                    make(name);
                    check=false;
                    break;
                }
            }
            if(check){
                Account account = new Account(str,name,0);
                list.add((T) account);
                return str;
            }
            return "";
    }
    public Account getInfo(String num)throws MyException{
        boolean chk=false;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getNumber().equals(num)){
                chk=true;
                return list.get(i);
            }
        }
        if(!chk){
            System.out.println("계좌정보가 없습니다.");
        }
        return null;
    }
}
