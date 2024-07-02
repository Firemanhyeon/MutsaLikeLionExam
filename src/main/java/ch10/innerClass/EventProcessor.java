package ch10.innerClass;

public class EventProcessor {

    public void processEvent(String event) {

        class EventHandler{
            public void handle(){
                System.out.println("처리중인이벤트: "+event);
            }
        }

        EventHandler handler = new EventHandler();
        handler.handle();
    }


    public static void main(String[] args) {
        EventProcessor processor = new EventProcessor();
        processor.processEvent("이벤트");
    }
}
