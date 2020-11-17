package com.company.GUI;

import com.company.Enum.Status;
import com.company.Game;
import com.company.Objects.Ship;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class ScoreField extends JPanel {
    private static final long serialVersionUID = 1L;
    private Game game;
    private int ships;
    private int player;

    public ScoreField(Game model, int player) {
        this.game = model;
        this.player = player;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[] m = new int[4];

        int i;
        for (i = 0; i < 0; ++i) {
            m[i] = 0;
        }

        this.ships = 0;
        Iterator<Ship> var4;
        if (player == 0) {
            var4 = game.getPlayer1().getListOfShips().iterator();

        } else {
            var4 = game.getPlayer2().getListOfShips().iterator();
        }

        while (var4.hasNext()) {

            Ship ship = var4.next();
            if (ship.isAlive()) {
                ++m[ship.getCellList().size() - 1];
                ++this.ships;
            }
        }
        for (i = 0; i < 4; ++i) {
            for (int j = 0; j < i + 1; ++j) {
                g.setColor(Color.gray);
                g.fillRect(j * 15 + 10, i * 15 + 5, 13, 13);
            }

            g.setColor(Color.black);
            g.drawString(String.valueOf(m[i]), 75, i * 15 + 16);
        }


        String st = "Alive: ".concat(String.valueOf(this.ships));
        g.drawString(st, 25, 100);

    }
}

