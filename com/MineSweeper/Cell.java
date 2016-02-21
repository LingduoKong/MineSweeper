package com.MineSweeper;

/**
 * Created by lingduokong on 2/20/16.
 */

public class Cell {
    private boolean isTouch;
    private String code;
    public Cell(String code) {
        this.code  = code;
    }

    public boolean isTouch() {
        return isTouch;
    }

    public void setTouch(boolean touch) {
        isTouch = touch;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
