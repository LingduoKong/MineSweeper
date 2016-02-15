/**
 * Created by lingduokong on 2/13/16.
 *
 * It is a panel to show the current panel of the game.
 * It prints out the current panel with row and col numbers
 */

public class GamePanel {

    public final String UNTOUCH = "X";
    public final String BOMB = "M";
    public final String EMPTY = " ";

    int row, col;
    private Cell[][] panel;

    /**
     * It is the constructor of the panel which should be initialized by row and col number
     * @param row number of rows
     * @param col number of values
     */
    public GamePanel(int row, int col) {
        this.row = row;
        this.col = col;
        panel = new Cell[row][col];
        initPanel();
    }

    private void initPanel() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                panel[i][j] = new Cell(UNTOUCH);
            }
        }
    }

    /**
     * get the code of a cell
     * @param row
     * @param col
     * @return the string representing the state
     */
    public String getACellCode(int row, int col) {
        if (getACellTouchState(row, col)) {
            return panel[row][col].getRepresentCode();
        } else {
            return UNTOUCH;
        }
    }

    /**
     * set the cell at (row, col) position to code value
     * @param row
     * @param col
     * @param code
     */
    public void setACellCode(int row, int col, String code) {
        if (row < 0 || row >= this.row || col < 0 || col >= this.col) {
            System.out.println("Illegal arguments, please try again!");
            return;
        }
        panel[row][col].setRepresentCode(code);
    }

    /**
     * get whether the cell at (row, col) is touch or not
     * @param row
     * @param col
     * @return true for touched and false for untouched
     */
    public boolean getACellTouchState(int row, int col) {
        if (row < 0 || row >= this.row || col < 0 || col >= this.col) {
            System.out.println("Illegal arguments, please check!");
            System.exit(0);
        }
        return panel[row][col].isTouch();
    }

    /**
     * set the touch state of a cell at (row, col) to (state)
     * @param row
     * @param col
     * @param state
     */
    public void setACellTouchState(int row, int col, boolean state) {
        if (row < 0 || row >= this.row || col < 0 || col >= this.col) {
            System.out.println("Illegal arguments, please check!");
            System.exit(0);
        }
        panel[row][col].setTouch(state);
    }

    /**
     * print the panel to the terminal instead of using GUI
     */
    public void printPanel() {
        System.out.format("%3d ", 0);
        for (int i = 1; i <= row; i++) {
            System.out.format(" %2d", i);
        }
        System.out.println();
        for (int i = 0; i < row; i++) {
            System.out.format("%3d ", i + 1);
            for (int j = 0; j < col; j++) {
                System.out.print("  ");
                panel[i][j].print();
            }
            System.out.println();
        }
    }

    public String[][] getCurrentPanel() {
        String[][] result = new String[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = getACellCode(i,j);
            }
        }
        return result;
    }


    /**
     * It is a class to represent each cell.
     */
     class Cell {
        private String representCode;
        private boolean isTouch;

        /**
         * Constructor to create the cell
         * The touch state of the panel is false as default
         * @param representCode parse in UFT-8 code or just simple chars
         */
        Cell(String representCode) {
            this.representCode = representCode;
            isTouch = false;
        }

        public boolean isTouch() {
            return isTouch;
        }

        public void setTouch(boolean touch) {
            isTouch = touch;
        }

        public String getRepresentCode() {
            return representCode;
        }

        public void setRepresentCode(String representCode) {
            this.representCode = representCode;
        }

        /**
         * It prints the cell code according to its touch state
         */
        public void print() {
            if (!isTouch()) {
                System.out.print(UNTOUCH);
            } else {
                System.out.print(representCode);
            }
        }
    }


}
