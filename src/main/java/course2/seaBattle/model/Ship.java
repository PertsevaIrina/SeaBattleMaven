package course2.seaBattle.model;

import java.util.List;

public class Ship {
    private int countOfDeck;
    private List<Cell> cellList;

    public Ship(int countOfDeck, List<Cell> cellList) {
        this.countOfDeck = countOfDeck;
        this.cellList = cellList;
    }

    public void setCellList(List<Cell> cellList) {
        this.cellList = cellList;
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
