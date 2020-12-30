package course2.seaBattle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import course2.seaBattle.model.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SerializeService {
    private Gson gson = new Gson();

    public void serialize(Game game) {
        try {
            FileWriter fw = new FileWriter("game.json");
            gson.toJson(game, fw); //записывает серил объекта
            fw.close();
        } catch (IOException io) { //ошибка на запись в файл
            io.printStackTrace(); //вывод ошибки
        }
    }

    public Game deserialize() {
        Game g = new Game();
        try {
            FileReader fr = new FileReader("game.json");
            StringBuilder sb = new StringBuilder();//считать в строку
            int c;
            while ((c = fr.read()) != -1) {
                sb.append((char) c);
            }
            fr.close();
            String json = sb.toString(); //записываем
            Type type = new TypeToken<Game>() {
            }.getType();
            g = gson.fromJson(json, type);
        } catch (IOException io) {
            io.printStackTrace();
        }
        getSerializeList(g.getPlayer1());
        getSerializeList(g.getPlayer2());
        return g;
    }

    private void getSerializeList(Player player) {
        List<Cell> list = new ArrayList<>();
        Field field = player.getField();
        for (int i = 0; i < field.getWidth(); i++) {
            for (int j = 0; j < field.getHeight(); j++) {
                if (field.getCell(i, j).getStatus() == Status.EMPTY || field.getCell(i, j).getStatus() == Status.SHIP) {
                    list.add(field.getCell(i, j));
                }
            }
        }
        field.setListOfCells(list);
        for (Ship s : player.getListOfShips()) {
            List<Cell> list1 = new ArrayList<>();
            for (Cell c : s.getCellList()) {
                list1.add(field.getCell(c.getX(), c.getY()));
            }
            s.setCellList(list1);
        }
    }
}
