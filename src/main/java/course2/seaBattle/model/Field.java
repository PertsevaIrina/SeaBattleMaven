package course2.seaBattle.model;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private Cell[][] cells;
    private int n, m;
    private transient List<Cell> listOfCells = new ArrayList<Cell>(); //список клеток доступ для обстрела

    public Field(int n, int m) {
        this.m = m;
        this.n = n;
    }


    public Field() {
        m = n = 10;
    }

    public int getHeight() {
        return n;
    }

    public int getWidth() {
        return m;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public void setListOfCells(List<Cell> listOfCells) {
        this.listOfCells = listOfCells;
    }

    public List<Cell> getListOfCells() {
        return listOfCells;
    }

    //нет такой ячейки или ошибка
    public Cell getCell(int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return null;
        }
        return cells[y][x];
    }

    public void removeCell(int index) {
        listOfCells.remove(index);

    }

    public void removeCell(Cell cell) {
        listOfCells.remove(cell);
    }

}
