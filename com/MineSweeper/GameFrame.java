package com.MineSweeper;

/**
 * Created by lingduokong on 2/20/16.
 */
public interface GameFrame {

    void start(int row, int col, int mineNumber);

    boolean isWin();

    boolean isLose();

    void NextStep(int x, int y, String action);

    String[][] getCurStatus();
}
