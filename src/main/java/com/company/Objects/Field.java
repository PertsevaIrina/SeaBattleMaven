package com.company.Objects;

import com.company.Objects.Cell;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private Cell[][] field;
    private int n, m;
    private List<Cell> listOfCells = new ArrayList<>(); //список клеток доступ для обстрела

    public Field() {
        n = m = 10;
        field = new Cell[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                field[i][j] = new Cell(j, i);
                listOfCells.add(field[i][j]);
            }
        }

    }

    public int getHeight() {
        return n;
    }

    public int getWidth() {
        return m;
    }

    public List<Cell> getListOfCells() {
        return listOfCells;
    }

    public Cell getCell(int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return new Cell(-1, -1);
        }
        return field[y][x];
    }

    public void removeCell(int index) {
        listOfCells.remove(index);

    }
    public void removeCell(Cell cell) {
       listOfCells.remove(cell);
    }

}
