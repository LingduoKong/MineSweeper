package com.LingduoKong.app;

/**
 * Created by lingduokong on 2/20/16.
 */
public class GameData {

    private Cell[][] data;

    public GameData(int row, int col, String initCode) {
        data = new Cell[row][col];
        init(initCode);
    }

    private void init(String initCode) {
        for (int i = 0 ; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = new Cell(initCode);
            }
        }
    }

    public Cell getCell(int row, int col) {
        return data[row][col];
    }

    public void setCell(int row, int col, Cell cell) {
        data[row][col] = cell;
    }

    public Cell[][] getData() {
        return data;
    }
}


