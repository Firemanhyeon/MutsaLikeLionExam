package ch12.IO.ObjectStream;

import java.io.*;

public class ObjectStreamExam {
    public static void main(String[] args) {
        //객체를 파일에 저장
//        Person person = new Person("John Doe", 22);
//
//        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));){
//            oos.writeObject(person);
//        }catch(IOException e){
//            e.printStackTrace();
//        }


        //파일에서 객체를 읽어오기
        Person readPerson=null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"))){
            readPerson = (Person)ois.readObject();

        }catch (IOException e){

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(readPerson.toString());

    }
}
