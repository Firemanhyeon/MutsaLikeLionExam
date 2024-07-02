package ch04;

public class QuequeExam {
    int[] queArray;//큐
    int front;//큐 첫번째요소를 가리키는 인덱스 출력할때의 인덱스
    int rear;//마지막요소 다음을 가리키는 인덱스 추가할때 추가할 인덱스
    int count;//큐에 저장된 횟수

    int maxSize;//최대사이즈


    public QuequeExam(int maxSize){
        this.maxSize=maxSize;//
        this.queArray = new int[maxSize];

        front=0;
        rear=0;
        count=0;
    }

    void enqueue(int value){
        if(count==maxSize){
            System.out.println("큐가 가득 찼습니다");
        }else{
            queArray[rear]=value;
            rear = (rear+1)%maxSize;//원형 큐 인덱스활용방법
            //rear++; 선형큐일때 구현
            count++;
        }
    }


    int dequeue(){
        if(count==0){
            System.out.println("큐가 비었어요");
            return -1;
        }else{
            int item = queArray[front];
            front = (front+1)%maxSize;//원형 큐 인덱스활용방법
            //front++ 선형큐면 이렇게 하면됨
            count--;//데이터가 나갔으니 --
            return item;
        }
    }

    int peek(){

        if(count==0){
            System.out.println("큐가 비었어요");
            return -1;
        }else{
            return queArray[front];
        }

    }
    boolean isempty(){
        if(count==0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        QuequeExam quequeExam = new QuequeExam(5);
        quequeExam.enqueue(1);
        quequeExam.enqueue(2);
        quequeExam.enqueue(3);
        quequeExam.enqueue(4);
        quequeExam.enqueue(5);
        System.out.println(quequeExam.dequeue());
        System.out.println(quequeExam.dequeue());
        quequeExam.enqueue(4);
        quequeExam.enqueue(5);
        quequeExam.enqueue(5);


    }
}
