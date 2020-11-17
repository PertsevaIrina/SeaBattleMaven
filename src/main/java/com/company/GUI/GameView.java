package com.company.GUI;

import com.company.Game;
import com.company.Logic.GameService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameView extends JFrame {
    private static final long serialVersionUID = 1L;
    private Game game;
    private GameController controller;
    private JMenuItem newGame;
    private JMenuItem exit;
    private Button button = new Button("Shot");
    private GameService gameService;

    public GameView(Game model) {
        this.game = model;
        this.buildUI();
        this.controller = new GameController(this, model);
        this.attachController();
        this.gameService = new GameService();
    }


    public void attachController() {
        this.newGame.addActionListener(this.controller);
        this.exit.addActionListener(this.controller);
    }

    private void buildUI() {
        this.setTitle("SeaBattle");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setBounds(400, 300, 800, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setLayout((LayoutManager) null);

        GUI_Field panelPlayerA = new GUI_Field(this.game, 0);
        panelPlayerA.setBounds(20, 31, 151, 151);
        this.getContentPane().add(panelPlayerA);

        GUI_Field panelPlayerB = new GUI_Field(this.game, 1);
        panelPlayerB.setBounds(190, 31, 151, 151);
        this.getContentPane().add(panelPlayerB);

//        ScoreField panelScore1 = new ScoreField(this.model, 0);
//        panelScore1.setBounds(370, 31, 90, 151);
//        panelScore1.setBackground(new Color(225, 225, 255));
//        this.getContentPane().add(panelScore1);
//
//        ScoreField panelScore2 = new ScoreField(this.model, 1);
//        panelScore2.setBounds(470, 31, 90, 151);
//        panelScore2.setBackground(new Color(225, 225, 255));
//        this.getContentPane().add(panelScore2);

        panel.add(button);
        this.add(panel);
        button.setBounds(20, 200, 50, 20);
        this.getContentPane().add(button);



        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 800, 21);
        this.getContentPane().add(menuBar);
        JMenu mnGame = new JMenu("Game");
        menuBar.add(mnGame);

        button.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gameService.gameShot(game);

                if (!(gameService.alive(game.getPlayer2())) && gameService.alive(game.getPlayer1()) ||
                        (gameService.alive(game.getPlayer2())) && !(gameService.alive(game.getPlayer1()))) {
//                    JMenu mn1;
//                    mn1 = new JMenu("WIN FIRST PLAYER");
//                    JMenu mn2;
//                    mn2 = new JMenu("WIN SECOND PLAYER");

                    boolean b = gameService.gameShot((game));
                    if (b) {
                        System.out.println("Выиграл первый игрок");
                        String message = "Выиграл игрок 1";
                        repaint();
                        JOptionPane.showMessageDialog(null,message);


//                        menuBar.add(mn1);

                    } else {
                        System.out.println("Выиграл второй игрок");
                        String message = "Выиграл игрок 2";
                        repaint();
                        JOptionPane.showMessageDialog(null,message);

//                        menuBar.add(mn2);

                    }


                }

                repaint();}
    });

        this.newGame = new JMenuItem("New game");
        mnGame.add(this.newGame);
        this.exit = new JMenuItem("Exit");
        mnGame.add(this.exit);

    }

    public class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }
}

