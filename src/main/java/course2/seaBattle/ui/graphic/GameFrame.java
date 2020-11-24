package course2.seaBattle.ui.graphic;

import course2.seaBattle.model.Game;
import course2.seaBattle.model.GameService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
    private Game game;
    private GameService gameService;
    private Button buttonShot;
    private Button buttonGame;
    private JLabel jl;
    private int cellSize = 40;

    public GameFrame(Game game, GameService service) {
        this.game = game;
        this.gameService = service;
        setup();
    }

    private void setup() {
        this.setTitle("SeaBattle");
        jl = new JLabel("Turn player 1");
        buttonShot = new Button("Shot");
        buttonGame = new Button("New Game");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        this.setResizable(false);

        GameField gameField1 = new GameField(this.game, 0, cellSize);
        int f1W = gameField1.getW() * cellSize + 1;
        int f1H = gameField1.getH() * cellSize + 1;
        gameField1.setBounds(20, 50, f1W, f1H);
        this.add(gameField1);

        GameField gameField2 = new GameField(this.game, 1, cellSize);
        int f2W = gameField2.getW() * cellSize + 1;
        int f2H = gameField2.getH() * cellSize + 1;
        gameField2.setBounds(f1W + 40, 50, f2W, f2H);
        this.add(gameField2);

        this.setBounds(400, 300, f1W + f2W + 70, Math.max(f1H, f2H) + 100);
        panel.add(buttonShot);
        panel.add(buttonGame);
        buttonShot.setBounds(20, 200, 70, 20);
        buttonGame.setBounds(20, 200, 70, 20);
        panel.add(jl);
        this.add(panel);


        buttonShot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gameService.gameShot(game);
                if (game.getStep()) {
                    jl.setText("Turn player 1");
                } else {
                    jl.setText("Turn player 2");
                }
                if (!gameService.alive(game.getPlayer1()) || !gameService.alive(game.getPlayer2())) {
                    if (gameService.gameShot((game))) {
                        jl.setText("Player 1 wins");
                    } else {
                        jl.setText("Player 2 wins");
                    }
                }
                repaint();
            }
        });

        buttonGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                game = new Game();
                newGame();
            }
        });

    }

    private void newGame() {
//        this = new GameFrame(new Game(), gameService);
        GameFrame gf = new GameFrame(new Game(), gameService);
        gf.setVisible(true);
        dispose();
//        setup();
    }
}

