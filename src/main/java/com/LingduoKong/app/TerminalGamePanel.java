package com.LingduoKong.app;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by lingduokong on 2/20/16.
 */
public class TerminalGamePanel implements PanelFrame {

    GameControl gameControl;

    public TerminalGamePanel(int row, int col, int mineNum) {
        gameControl = new GameControl();
        gameControl.start(row, col, mineNum);
    }

    @Override
    public void display() {
        String[][] panel = gameControl.getCurStatus();
        for (int i = 0; i < panel.length; i++) {
            for (int j = 0; j < panel[0].length; j++) {
                System.out.format("%3s", panel[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public boolean getAction() {
        int row = 0;
        int col = 0;
        Scanner scanner = new Scanner(System.in);
        while (row * col == 0) {
            if (row == 0) {
                System.out.println("Please enter row number:");
                String s = scanner.nextLine();
                if (Pattern.matches("[1-9][0-9]*", s)) {
                    row = Integer.parseInt(s);
                }
            } else {
                System.out.println("Please enter col number:");
                String s = scanner.nextLine();
                if (Pattern.matches("[1-9][0-9]*", s)) {
                    col = Integer.parseInt(s);
                }
            }
        }
        gameControl.NextStep(row - 1, col - 1, "TOUCH");
        if (gameControl.isLose()) {
            display();
            System.out.println("Sorry, you touch a bomb!");
            return false;
        } else if (gameControl.isWin()) {
            display();
            System.out.println("Cong! You win!");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void showAll() {
        Cell[][] finalResult = gameControl.gameData.getData();
        for (int i = 0; i < finalResult.length; i++) {
            for (int j = 0; j < finalResult[0].length; j++) {
                System.out.format("%3s", finalResult[i][j].getCode());
            }
            System.out.println();
        }
    }
}
