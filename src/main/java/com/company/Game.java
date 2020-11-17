package com.company;

import com.company.Logic.GameService;
import com.company.Player.Player;

public class Game {
    private Player player1;
    private Player player2;
    private boolean step = true;

    public boolean getStep() {
        return step;
    }

    public void setStep(boolean step) {
        this.step = step;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Game() {
        GameService service = new GameService();

        this.player1 = new Player();
        this.player2 = new Player();

        service.setShips(player1.getField(), player1.getListOfShips());
        service.setShips(player2.getField(), player2.getListOfShips());


    }
}
