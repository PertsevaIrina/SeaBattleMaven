package com.company.Objects;

import com.company.Enum.Status;

import java.util.List;

public class Ship {
    private int countOfDeck;
    private List<Cell> cellList;
   // private boolean alive;

    public Ship(int countOfDeck, List<Cell> cellList) {
        this.countOfDeck = countOfDeck;
        this.cellList = cellList;
        //alive = true;
    }

    public boolean isAlive(){
        for (Cell c : cellList) {
            if (c.getStatus() == Status.SHIP) {
                return true;
            }
        }
        return false;
    }

    public List<Cell> getCellList() {
        return cellList;
    }



}
