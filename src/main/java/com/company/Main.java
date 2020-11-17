package com.company;

import com.company.Console.Interface;
import com.company.GUI.GameView;
import com.company.Logic.GameService;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        GameService service = new GameService();
        Game game = new Game();
        Interface.draw(game);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (Throwable var3) {
            var3.printStackTrace();
        }
        GameView view = new GameView(game);
        view.setVisible(true);
    }

}

