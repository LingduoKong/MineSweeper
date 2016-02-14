import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by lingduokong on 2/13/16.
 */
public class Game {

    private GamePanel gamePanel;
    private String[][] panelValues;
    private HashSet<Integer> bombs;
    private int size;
    private int bombNum;
    private int touchNum;

    /**
     * Create a game instance to play.
     *
     * @param size It is the size of the whole panel
     * @param bombNum It is the total number of bombs in this panel
     */
    public Game(int size, int bombNum) {
        this.size = size;
        this.bombNum = bombNum;
    }

    /**
     * this is the entrance of the game
     */
    public void start() {
        gamePanel = new GamePanel(size, size);
        bombs = new HashSet<>();
        touchNum = 0;
        generateBombs(bombNum);
        panelValues = new String[size][size];
        setGamePanelValues();
        tips();
    }

    /*
    generate bombs randomly
     */
    private void generateBombs(int bombNum) {
        while (bombNum > 0) {
            int pos = generateABomb();
            if (bombs.add(pos)) {
                bombNum -= 1;
            }
        }
    }

    /*
     * generate the hidden value of each cell
     */
    private void setGamePanelValues() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (bombs.contains(i * size + j)) {
                    panelValues[i][j] = gamePanel.BOMB;
                    continue;
                }
                int count = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x < 0 || y < 0 || x >= size || y >= size || x == i && y == j) {
                            continue;
                        }
                        if (bombs.contains(x * size + y)) {
                            count += 1;
                        }
                    }
                }
                panelValues[i][j] = "" + count;
            }
        }
    }

    private int generateABomb() {
        int x = (int) (Math.random() * size);
        int y = (int) (Math.random() * size);
        return x * size + y;
    }

    public boolean isWin() {
        return touchNum + 1 == size * size - bombs.size();
    }

    public boolean isLose(int row, int col) {
        return panelValues[row][col].equals(gamePanel.BOMB);
    }

    private void showBombs() {
        for (int i : bombs) {
            int row = i / size;
            int col = i % size;
            gamePanel.setACellTouchState(row, col, true);
            gamePanel.setACellCode(row, col, gamePanel.BOMB);
        }
        gamePanel.printPanel();
    }

    private void tips() {
        gamePanel.printPanel();
        int row = 0, col = 0;
        while (true) {
            if (row > 0 && col > 0) {
                break;
            }
            if (row == 0) {
                System.out.println("Please input row number you want to touch:");
            } else {
                System.out.println("Please input col number you want to touch:");
            }
            Scanner in = new Scanner(System.in);
            String num = in.nextLine();
            if (Pattern.matches("[1-9][0-9]*", num)) {
                int inputNumber = Integer.parseInt(num);
                if (inputNumber > size) {
                    System.out.println("Illegal Input. Please try again");
                } else if (row == 0) {
                    row = inputNumber;
                } else {
                    col = inputNumber;
                }
            } else {
                System.out.println("Illegal Input. Please try again");
            }
        }
        System.out.println("touch " + row + ", " + col);

        if (go(row - 1, col - 1) != 0) {
            return;
        }
        tips();
    }


    private int go(int row, int col) {
        if (gamePanel.getACellTouchState(row, col)) {
            System.out.println("Cannot be touched again!");
            return 0;
        } else if (isLose(row, col)) {
            showBombs();
            System.out.println("Sorry. You touch a bomb!");
            return -1;
        } else if (isWin()) {
            System.out.println("Cong. Win! You are so smart!");
            return 1;
        } else {
            touch(row, col);
        }
        return 0;
    }

    private int touch(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size || gamePanel.getACellTouchState(row, col)) {
            return 0;
        }
        touchNum += 1;
        if (!panelValues[row][col].equals("0")) {
            gamePanel.setACellTouchState(row, col, true);
            gamePanel.setACellCode(row, col, panelValues[row][col]);
            return touchNum;
        }
        gamePanel.setACellTouchState(row, col, true);
        gamePanel.setACellCode(row, col, gamePanel.EMPTY);
        touch(row - 1, col);
        touch(row + 1, col);
        touch(row, col + 1);
        touch(row, col - 1);
        return touchNum;
    }

    private void printHiddenValues() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(panelValues[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int solver() {

        gamePanel = new GamePanel(size, size);
        bombs = new HashSet<>();
        touchNum = 0;
        generateBombs(bombNum);
        panelValues = new String[size][size];
        setGamePanelValues();


        int c = 0, l = 0;
        while (true) {

            int flag = go(c, l);
            if (flag > 0) {
                System.out.println("Solved");
                return 1;
            } else if (flag < 0) {
                System.out.println("Fail");
                return 0;
            }

            double[][] panel = new double[size][size];
            for (double[] doubles : panel) {
                Arrays.fill(doubles, 1);
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    String code = gamePanel.getACellCode(i, j);
                    if (code.equals(gamePanel.EMPTY) || !code.equals(gamePanel.UNTOUCH)) {
                        panel[i][j] = -1;
                    } else if (code.equals(gamePanel.UNTOUCH)) {
                        continue;
                    } else {
                        int surBombNum = Integer.parseInt(code);
                        int unTouchNum = 0;
                        for (int x = i - 1; x <= i + 1; x++) {
                            for (int y = j - 1; y <= j + 1; j++) {
                                if (x < 0 || x >= size || y < 0 || y >= size || x == i && y == j) {
                                    continue;
                                } else if (panel[i][j] != -1) {
                                    unTouchNum += 1;
                                }
                            }
                        }
                        for (int x = i - 1; x <= i + 1; x++) {
                            for (int y = j - 1; y <= j + 1; j++) {
                                if (x < 0 || x >= size || y < 0 || y >= size
                                        || x == i && y == j || panel[i][j] == -1) {
                                    continue;
                                } else {
                                    panel[i][j] *= surBombNum * 1.0 / unTouchNum;
                                }
                            }
                        }
                    }
                }
            }


            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(size, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (panel[o1 / size][o1 % size] > panel[o2 / size][o2 % size]) {
                        return -1;
                    } else if (panel[o1 / size][o1 % size] < panel[o2 / size][o2 % size]) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    maxHeap.add(i * size + j);
                }
            }

            int max = maxHeap.poll();
            c = max / size;
            l = max % size;
        }

    }

}
