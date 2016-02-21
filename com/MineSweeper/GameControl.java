package com.MineSweeper;

/**
 * Created by lingduokong on 2/20/16.
 */
public class GameControl implements GameFrame {

    final String MINE = "M";
    final String INITIATE = ".";
    final String ENPTY = "_";
    final String TOUCH = "TOUCH";

    GameData gameData;
    boolean isWin = false;
    boolean isLose = false;
    int row;
    int col;

    public GameControl() {}

    @Override
    public void start(int row, int col, int mineNumber) {
        this.row = row;
        this.col = col;
        gameData = new GameData(row, col, INITIATE);
        addMines(mineNumber);
        calcCellCode();
    }

    @Override
    public boolean isWin() {
        isWin = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Cell cell = gameData.getCell(i, j);
                if (cell.getCode().equals(MINE)) {
                    continue;
                } else if (!cell.isTouch()) {
                    isWin = false;
                }
            }
        }
        return isWin;
    }

    @Override
    public boolean isLose() {
        return isLose;
    }

    @Override
    public void NextStep(int x, int y, String action) throws IllegalArgumentException {
        if (x < 0 || x >= row || y < 0 || y >= col) {
            throw new IllegalArgumentException("beyond the scope");
        }
        Cell cell = gameData.getCell(x, y);
        if (cell.isTouch()) {
            throw new IllegalArgumentException("Can not be touched again");
        } else if (cell.getCode().equals(MINE)) {
            isLose = true;
        } else {
            expand(x, y);
        }
    }

    private void expand(int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return ;
        }
        Cell cell = gameData.getCell(x, y);
        if (cell.getCode().equals(MINE) || cell.isTouch()) {
            return;
        } else {
            cell.setTouch(true);
            if (cell.getCode().equals("0")) {
                expand(x - 1, y - 1);
                expand(x - 1, y);
                expand(x - 1, y + 1);
                expand(x, y - 1);
                expand(x, y + 1);
                expand(x + 1, y - 1);
                expand(x + 1, y);
                expand(x + 1, y + 1);
            }
        }
    }


    @Override
    public String[][] getCurStatus() {
        String[][] status = new String[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Cell cell = gameData.getCell(i, j);
                if (cell.isTouch()) {
                    status[i][j] = cell.getCode();
                } else {
                    status[i][j] = INITIATE;
                }
            }
        }
        return status;
    }

    private void addMines(int mineNum) {
        while (mineNum > 0) {
            int x = (int) (row * Math.random());
            int y = (int) (col * Math.random());
            Cell cell = gameData.getCell(x, y);
            if (cell.getCode().equals(MINE)) {
                continue;
            }
            cell.setCode(MINE);
            mineNum -= 1;
        }
    }

    private void calcCellCode() {
        Cell[][] cells = gameData.getData();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (cells[i][j].getCode().equals(MINE)) {
                    continue;
                }
                int count = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x < 0 || x >= row || y < 0 || y >= col) {
                            continue;
                        }
                        if (cells[x][y].getCode().equals(MINE)) {
                            count += 1;
                        }
                    }
                }
                cells[i][j].setCode(String.valueOf(count));
            }
        }
    }
}
