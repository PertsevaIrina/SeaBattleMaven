package com.company.Player;

import com.company.Objects.Field;
import com.company.Objects.Ship;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Field field;
    private List<Ship> listOfShips = new ArrayList<>();

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
