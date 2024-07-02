package ch10.innerInterface;

public class Smartphone {

    public interface Camera{
        void takePhoto();
    }

    public class BasicCamera implements Camera{
        public void takePhoto() {
            System.out.println("사진을찍습니다");
        }
    }

    public void activeCamera(){
        Camera camera = new BasicCamera();
        camera.takePhoto();
    }


    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone();
        smartphone.activeCamera();
    }
}
