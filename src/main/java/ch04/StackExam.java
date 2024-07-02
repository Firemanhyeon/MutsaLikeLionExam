package ch04;

public class StackExam {
    int[] stack ;//스택
    int pointer ; //현재가르키고있는 요소

    int size; // 크기

    public  StackExam(int maxSize){
        this.stack = new int[maxSize];
        this.size = maxSize;
        this.pointer=-1;//-1로 선언해서 처음 넣을때 0번부터 넣을 수 있게한다.
    }
    void push(int num){
    // 배열크기 이상으로 들어왔을때의 예외처리해줘야함
        if(isFull()){//값이 가득찬경우
            System.out.println("스택이 가득 찼습니다.");
        }else{ //가득차지않은경우
            pointer++;
            stack[pointer] = num;
        }
    }
    int popMethod(){
        //스택에 더이상 데이터가 있는지없는지 예외체크
            if(isEmpty()){
                System.out.println("스택이 비었습니다.");
                return -1;
            }else{
                int pop = stack[pointer];
                pointer--;
                return pop;
            }

    }

    int peekMethod(){

        //스택에 더이상 데이터가 있는지없는지 예외체크
            if(isEmpty()){
                System.out.println("스택이 비었습니다.");
                return -1;
            }else{
                int pop = stack[pointer];
                return pop;
            }

    }

    boolean isEmpty(){
        if(pointer==-1){

            return true;
        }else{
            return false;
        }
    }

    //스택이 가득 찼는지 확인하는 메서드

    boolean isFull(){
        if(pointer>=size-1){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        StackExam stackExam = new StackExam(5);
        stackExam.push(1);
        stackExam.push(2);
        stackExam.push(3);
        stackExam.push(3);
        stackExam.push(3);
        stackExam.push(3);
        System.out.println(stackExam.popMethod());
        System.out.println(stackExam.popMethod());
        System.out.println(stackExam.peekMethod());
        System.out.println(stackExam.popMethod());
        System.out.println(stackExam.popMethod());
        System.out.println(stackExam.popMethod());
        System.out.println(stackExam.popMethod());
        System.out.println(stackExam.popMethod());
        System.out.println(stackExam.isEmpty());
    }
}
