package course2.seaBattle.model;

import course2.seaBattle.model.Field;
import course2.seaBattle.model.Ship;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Field field;
    private List<Ship> listOfShips = new ArrayList<Ship>();

    public Player() {
        this.field = new Field();
    }

    public Field getField() {
        return field;
    }

    public List<Ship> getListOfShips() {
        return listOfShips;
    }
}
