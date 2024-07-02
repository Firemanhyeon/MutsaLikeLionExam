package sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import sample.bean.Dice;
import sample.bean.Game;
import sample.bean.Player;

import java.util.List;

//@ComponentScan(basePackages = "sample")
@PropertySource({"classpath:game.properties"})
public class GameConfig {

    @Bean
    public Dice dice(@Value("${face}") int face){
        return new Dice(face);
    }

    @Bean
    public Player kang(Dice dice){
        Player player = new Player();
        player.setDice(dice);//dice를 주입하고 있는 코드 (설정자 방식으로 주입)
        player.setName("정호현");
        return player;
    }
    @Bean
    public Player kim(Dice dice){
        Player player = new Player();
        player.setDice(dice);//dice를 주입하고 있는 코드 (설정자 방식으로 주입)
        player.setName("kim");
        return player;
    }
    @Bean
    public Player hong(Dice dice){
        Player player = new Player();
        player.setDice(dice);//dice를 주입하고 있는 코드 (설정자 방식으로 주입)
        player.setName("hong");
        return player;
    }

    @Bean
    public Game game(List<Player> players){
        //return new Game(players);//setter 통해서 인젝션
        Game game = new Game();//setter를 통해서 인젝션
        game.setList(players);
        return game;
    }
}
