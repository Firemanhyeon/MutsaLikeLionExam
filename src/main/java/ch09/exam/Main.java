package ch09.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException {
        Bank<Account> bank1 = new Bank();
        Banker banker = new Banker("은행원1" , "1111");
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1.입금하기 2.출금하기 3.계좌개설하기 4.통장 조회하기");
            int bank = sc.nextInt();
            if(bank==1){
                System.out.println("입금하실 계좌번호를 입력해주세요");
                String num = sc.next();
                try{
                    if(bank1.getInfo(num)==null) continue;
                    Account acc1 = bank1.getInfo(num);
                    System.out.println("입금할 금액을 입력하세요");
                    int money = sc.nextInt();
                    acc1.input(money);
                    System.out.println("입금 완료되었습니다 남은 잔액은 "+acc1.getLeft()+" 원 입니다");
                }catch (MyException e){
                    System.out.println("오류");
                    System.out.println(e.getMessage());
                    continue;
                }
                continue;
            }
            if (bank==2) {
                System.out.println("출금하실 계좌번호를 입력해주세요");
                String num = sc.next();
                try{
                    if(bank1.getInfo(num)==null) continue;
                    Account acc1 = bank1.getInfo(num);
                    System.out.println("출금할 금액을 입력하세요");
                    int money = sc.nextInt();
                    if(banker.access()){
                        acc1.output(money);
                    }else{
                        System.out.println("출금이 거절되었습니다");
                        continue;
                    }
                }catch (MyException e){
                    System.out.println("오류");
                    System.out.println(e.getMessage());
                    continue;
                }
            }else if(bank==3) {
                System.out.println("개설할 본인 이름을 입력하세요");
                String name = sc.next();
                if(banker.access1()){
                    System.out.println("계좌개설이 승인되었습니다.");
                    System.out.println("만드신 계좌번호는 " + bank1.make(name) + "입니다");
                }else{
                    System.out.println("계좌개설이 거절되었습니다");
                }
            }else if(bank==4){
                System.out.println("조회하실 계좌번호를 입력하세요(-빼고 숫자만)");
                String num = sc.next();
                Account ac2 = bank1.getInfo(num);
                System.out.println(ac2.getName()+"님의 잔고는 "+ac2.getLeft()+"입니다");
            }else{
                System.out.println("잘못입력하셨습니다 다시 입력하세요");
            }
        }
    }
}
