package sample.bean;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Game {
    private List<Player> list;

    public Game(List<Player> list) {//생성자를 통해서 인젝션
        this.list = list;
        System.out.println("게임생성자실행");
    }

    public Game() {
        System.out.println("게임 디폴트 생성자 실행");
    }

    public List<Player> getList() {
        return list;
    }

    public void setList(List<Player> list) {
        this.list = list;
    }

    public void play(){
        for(Player p : list){
            p.play();
        }
    }
}
