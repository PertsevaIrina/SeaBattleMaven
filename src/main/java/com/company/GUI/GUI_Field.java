package com.company.GUI;

import com.company.Enum.Status;
import com.company.Game;
import com.company.Player.Player;

import java.awt.*;

public class GUI_Field extends PanelField {
    private static final long serialVersionUID = 553977695177508456L;

    private int player;

    public GUI_Field(Game game, int player) {
        super(game);
        this.player = player;
    }

    private Color getColorByStateElement(Status state) {
        switch (state) {
            case EMPTY:
                return Color.CYAN;
            case SHIP:
                return new Color(153,51,0);
            case INJURED:
                return new Color(153,255,255);
            case MISS:
                return Color.black;
        }
        return Color.black;
    }


    @Override
    protected void paintElement(Graphics g, int i, int j) {
        Status state;
        if (player == 0) {
             state = game.getPlayer1().getField().getCell(i, j).getStatus();
        } else {
            state = game.getPlayer2().getField().getCell(i, j).getStatus();
        }
        g.setColor(getColorByStateElement(state));
        if (state == Status.MISS) {
            g.setColor(Color.CYAN);
            g.fillRect(i * 15 + 1, j * 15 + 1, 15, 15);
            g.setColor(Color.black);
            g.fillRect(i * 15 + 6, j * 15 + 6, 4, 4);
        } else {
            g.fillRect(i * 15 + 1, j * 15 + 1, 15, 15);
        }

    }
}

