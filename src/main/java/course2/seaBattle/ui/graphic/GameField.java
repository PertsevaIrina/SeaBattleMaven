package course2.seaBattle.ui.graphic;

import course2.seaBattle.model.Status;
import course2.seaBattle.model.Game;

import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {
    private Game game;
    private int player;
    private int h, w;
    private int cellSize;

    public GameField(Game game, int player, int cellSize) {
        this.game = game;
        this.player = player;
        this.cellSize = cellSize;
        h = (player == 0) ? game.getPlayer1().getField().getHeight() : game.getPlayer2().getField().getHeight();
        w = (player == 0) ? game.getPlayer1().getField().getWidth() : game.getPlayer2().getField().getWidth();
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // решетка
        for (int i = 0; i < h + 1; i++) {
            g.drawLine(0, i * cellSize, w * cellSize, i * cellSize);
        }
        for (int i = 0; i < w + 1; i++) {
            g.drawLine(i * cellSize, 0, i * cellSize, h * cellSize);
        }

        //элементы
        for (int j = 0; j < h; j++) {
            for (int i = 0; i < w; i++) {
                paintElement(g, i, j);
            }
        }
    }

    private Color ColorOfElement(Status state) {
        switch (state) {
            case EMPTY:
            case MISS:
                return new Color(59, 134, 153);
            case SHIP:
                return new Color(153, 105, 62);
            case INJURED:
                return new Color(150, 10, 15);

        }
        return Color.black;
    }


    private void paintElement(Graphics g, int i, int j) {
        Status state;
        if (player == 0) {
            state = game.getPlayer1().getField().getCell(i, j).getStatus();
        } else {
            state = game.getPlayer2().getField().getCell(i, j).getStatus();
        }
        g.setColor(ColorOfElement(state));
        g.fillRect(i * cellSize , j * cellSize , cellSize, cellSize);
        if (state == Status.MISS || state == Status.INJURED) {
            drawX(g, i, j);
        }

    }

    private void drawX(Graphics g, int i, int j) {
        g.setColor(Color.black);
        int a = cellSize / 10;
        g.drawLine(i * cellSize + a, j * cellSize + a, (i + 1) * cellSize - a, (j + 1) * cellSize - a);
        g.drawLine(i * cellSize + a, (j + 1) * cellSize - a, (i + 1) * cellSize - a, j * cellSize + a);
    }
}

