package com.company.Console;

import com.company.Objects.Field;
import com.company.Game;

public class Interface {
    public static void draw(Game game) {
        draw(game.getPlayer1().getField());
        draw(game.getPlayer2().getField());
    }

    public static void draw(Field field) {
        System.out.println(fieldToString(field));
    }

    private static String fieldToString(Field field) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i = 0; i < field.getWidth() ; i++) {
            sb.append("|").append(i);

        }
        sb.append("|\n");
        for (int i = 0; i < field.getHeight(); i++) {
            sb.append(i);
            for (int j = 0; j < field.getWidth(); j++) {
                sb.append("|");
                switch (field.getCell(j, i).getStatus()) {
                    case SHIP:
                        sb.append("o");
                        break;
                    case MISS:
                        sb.append("*");
                        break;
                    case EMPTY:
                        sb.append(" ");
                        break;
                    case INJURED:
                        sb.append("x");
                        break;
                }
            }

            sb.append("|\n");

        }
        return sb.toString();
    }
}
