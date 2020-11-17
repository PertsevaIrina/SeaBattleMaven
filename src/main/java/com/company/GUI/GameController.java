package com.company.GUI;

import com.company.Game;
import com.company.Logic.GameService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {
    public Game game;
    public GameView view;

    public GameController(GameView view, Game game) {
        this.view = view;
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("New game")) {
            Game game1 = new Game();
            GameView view = new GameView(game1);
            view.setVisible(true);



        }

        if (cmd.equals("Exit")) {
            System.exit(0);
        }

    }
}
