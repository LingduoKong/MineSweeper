package com.MineSweeper;

/**
 * Created by lingduokong on 2/20/16.
 */
public class Test {

    public static void main(String[] args) {
        TerminalGamePanel gamePanel = new TerminalGamePanel(5, 5, 5);
        gamePanel.display();
        while (gamePanel.getAction()) {
            gamePanel.display();
        }
    }
}
