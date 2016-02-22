package com.LingduoKong.app;

/**
 * Created by lingduokong on 2/20/16.
 */
public interface Solvable {

    public void solve(GameFrame game);

    public boolean touch(int x, int y, String action);

    public boolean isWin();

    public boolean isLose();

}
