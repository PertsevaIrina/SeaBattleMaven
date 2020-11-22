package course2.seaBattle;

import course2.seaBattle.model.Game;
import course2.seaBattle.ui.consol.Interface;
import course2.seaBattle.ui.graphic.GameFrame;
import course2.seaBattle.model.GameService;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        GameService service = new GameService();
        Game game = new Game();
        GameFrame gf = new GameFrame(game, service);
        gf.setVisible(true);
    }

}

