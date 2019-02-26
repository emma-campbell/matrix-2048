package app.matrix.gameplay;

import javax.swing.*;
import java.awt.Point;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

/**
 * @author emma-campbell
 * @version 1.0
 * @since 2019-02-16
 */
class Matrix extends JPanel {

    private Random r = new Random();
    private MatrixCell[][] matrix = new MatrixCell[4][4];

    private static final int NULL = 0;
    private int width, height;
    private Point loc;

    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = true;

    private boolean valid = false;

    /**
     * Constructor that initializes the game board with all empty slots, then places two
     * random tiles in random places
     */
    Matrix(int width, int height) {

        super();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = new MatrixCell(NULL);
            }
        }

        this.width = width;
        this.height = height;

    }

    /**
     * Creates a NEW instance of MatrixCell[][] and copys the values of matrix to it for
     * comparison
     *
     * @return a copy of the private array matrix, used to determine if the move was valid
     * or not
     */
    private MatrixCell[][] createCopy() {
        MatrixCell[][] newArr = new MatrixCell[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                newArr[i][j] = new MatrixCell(get(i,j));
            }
        }

        return newArr;
    }

    /**
     * Returns the integer value of an individual cell, accessed by parameters
     * i and j, representing the row and column indices.
     *
     * @param i represents the row in the matrix
     * @param j represents the col in the matrix
     * @return integer value of matrix cell
     *
     */
    private int get(int i, int j) {
        return matrix[i][j].getValue();
    }

    /**
     * Sets the values of a cell at position i, j
     *  @param i index moving up and down
     * @param j index moving left to right
     * @param val integer value to set the cell to
     */
    private void set(int i, int j, int val) {
        matrix[i][j].setValue(val);
    }

    /**
     * Moves the tiles on the board
     */
    private int move() {
        int points = 0;

        MatrixCell[][] copy = createCopy(); //copy to compare if move was valid


        if (up) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    if (get(i, j) == 0 && get(i+1, j) != 0) {
                        set(i, j, get(i+1, j));
                        set(i+1, j, 0);
                    }
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    if (get(i, j) == 0 && get(i+1, j) != 0) {

                        set(i, j, get(i+1, j));
                        set(i+1, j, 0);
                    }
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    if (get(i, j) ==  get(i+1, j) && get(i+1, j) != 0) {
                        set(i, j, 2 * get(i, j));
                        points += get(i, j);
                        set(i+1, j, 0);
                    }
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    if (get(i, j) ==  0 && get(i+1, j) != 0) {
                        set(i, j, get(i+1, j));
                        set(i+1, j, 0);
                    }
                }
            }
        }

        else if (down) {

            for (int i = 3; i > 0; i--) {
                for (int j = 0; j < 4; j++) {
                    if (get(i, j) == 0 && get(i-1, j) != 0) {
                        set(i, j, get(i-1, j));
                        set(i-1, j, 0);
                    }
                }
            }

            for (int i =3; i > 0; i--) {
                for (int j = 0; j < 4; j++) {
                    if (get(i, j) == 0 && get(i-1, j) != 0) {
                        set(i, j, get(i-1, j));
                        set(i-1, j, 0);
                    }
                }
            }

            for (int i = 3; i > 0; i--) {
                for (int j = 0; j < 4; j++) {
                    if (get(i, j) == get(i-1, j) && get(i-1, j) != 0) {
                        set(i, j, 2 * get(i, j));
                        points += get(i, j);
                        set(i-1, j, 0);
                    }
                }
            }

            for (int i = 3; i > 0; i--) {
                for (int j = 0; j < 4; j++) {
                    if (get(i, j) == 0 && get(i - 1, j) != 0) {
                        set(i, j, get(i - 1, j));
                        set(i-1, j, 0);
                    }
                }
            }
        }


        else if (left) {

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (get(i, j) == 0 && get(i, j + 1) != 0) {
                        set(i, j, get(i, j + 1));
                        set(i, j + 1, 0);
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (get(i, j) == 0 && get(i, j + 1) != 0) {
                        set(i, j, get(i, j + 1));
                        set(i, j + 1, 0);
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (get(i, j) == get(i, j + 1) && get(i, j + 1) != 0) {
                        set(i, j, 2 * get(i, j));
                        points += get(i, j);
                        set(i, j + 1, 0);
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (get(i, j) == 0 && get(i, j + 1) != 0) {
                        set(i, j, get(i, j + 1));
                        set(i, j + 1, 0);
                    }
                }
            }
        }

        else if (right) {

            for (int i = 0; i < 4; i++) {
                for (int j = 3; j > 0; j--) {
                    if (get(i, j) == 0 && get(i, j- 1) != 0) {
                        set(i, j, get(i, j-1));
                        set(i, j-1, 0);
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 3; j > 0; j--) {
                    if (get(i, j) == 0 && get(i, j- 1) != 0) {
                        set(i, j, get(i, j-1));
                        set(i, j-1, 0);
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 3; j > 0; j--) {
                    if (get(i, j) == get(i, j- 1) && get(i, j-1) != 0) {
                        set(i, j, 2 * get(i, j-1));
                        points += get(i,j);
                        set(i, j-1, 0);
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 3; j > 0; j--) {
                    if (get(i, j) == 0 && get(i, j- 1) != 0) {
                        set(i, j, get(i, j-1));
                        set(i, j-1, 0);
                    }
                }
            }
        }

        if (compareArr(copy)) {
            valid = true;
            System.out.println("Valid move");
        }
        else {
            valid = false;
            System.out.println("Invalid move");
            matrix = copy;
        }

        return points;
    }

    boolean getValid() {return valid;}

    private boolean compareArr(MatrixCell[][] other) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                int val1 = matrix[i][j].getValue();
                int val2 = other[i][j].getValue();

                if (val1 != val2) {
                    return true;
                }
            }
        }

        return false;
    }


    int up() {
        up = true;
        down = false;
        left = false;
        right = false;

        return move();
    }

    int down() {
        up = false;
        down = true;
        left = false;
        right = false;

        return move();
    }

    int left() {
        up = false;
        down = false;
        left = true;
        right = false;

        return move();
    }

    int right() {
        up = false;
        down = false;
        left = false;
        right = true;

        return move();
    }

    /**
     *
     * @return int number of null tiles
     */
    public int countNull() {

        int empty = 0;

        for (int i = 0; i < 4; i ++) {
            for (int j = 0; j < 4; j++) {
                if (get(i, j) == 0) {
                    empty += 1;
                }
            }
        }

        return empty;
    }

    /**
     *
     * @return boolean representing if it is possible to continue
     */
    protected boolean movesRemaining() {

        boolean moves = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (get(i, j) == get(i+1, j)) {
                    moves = true;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (get(i,j) == get(i, j+1)) {
                    moves = true;
                }
            }
        }

        if (countNull() > 0) {
            moves = true;
        }
        else if (countNull() == 0 && !moves) {
            moves = false;
        }

        return moves;
    }

    /**
     * Prints a formatted version of the matrix
     */
    void print() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d\t", matrix[i][j].getValue());
            }
            System.out.println();
        }
    }

    /**
     * Replaces each cell of the board with a new cell of value null
     */
    void clear() {
        for (int i = 0; i <= matrix.length - 1; i++) {
            for (int j = 0; j <= matrix[i].length - 1; j ++) {
                matrix[i][j] = new MatrixCell(NULL);
            }
        }
    }

    /**
     *
     * @param dir integer representing direction of travel
     * @return boolean true or false
     */
    private boolean areDups(int dir) {

        if (dir == 1 || dir == 2) {
            for (int i = 3; i > 0; i--) {
                for (int j = 0; j < 3; j++) {
                    if (matrix[i][j].getValue() == matrix[i - 1][j].getValue() && !(matrix[i][j].isNull())) {
                        return true;
                    }
                }
            }
        }

        if (dir == 3 || dir == 4) {

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length - 1; j++) {
                    if (matrix[j][i].getValue() == matrix[j+1][i].getValue() && !(matrix[j][i].isNull())) {
                        return true;
                    }
                }
            }
        }

        return false; //if it doesn't find any duplicates, return false.
    }

    /**
     * Places a cell with a value of 2 or 0 where there is a null space in the matrix
     */
    void placeRandom() {
        boolean placed = false;

        while (!placed) {

            int val = 2 * (r.nextInt(2) + 1);
            int i = (r.nextInt(4));
            int j = (r.nextInt(4));

            if (matrix[i][j].isNull()) {
                matrix[i][j] = new MatrixCell(val);
                System.out.println("Piece placed");
                return;
            }

        }

    }

    /**
     *
     * @return
     */
    public boolean hasWon() {
        int max = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (get(i,j) > max ) {
                    max = get(i,j);
                }
            }
        }

        return max >= 2048;
    }

    /* OVERRIDEN METHODS */

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.setColor(new Color(3, 29, 68));
        g.fillRect(loc.x,loc.y, width, height);
    }

    void drawBoard(Graphics g, int x, int y) {

        loc = new Point(x, y);
        int temp = x;

        this.paintComponents(g);

        for (MatrixCell[] row : matrix) {
            //for each row
            for (MatrixCell cell : row) {
                cell.drawCell(g, x + 12, y + 22);
                x += 90;
            }

            x = temp;
            y += 112;
        }

    }

}

/**
 * @author emma-campbell
 * @version 1.0
 * @since 2019-02-16
 */

class MatrixCell extends JComponent {

    private static final int HEIGHT = 100, WIDTH = 80;
    private static final int NULL = 0;
    private int value;
    private Point loc;

    /**
     * Creates a new cell
     * @param value Integer value to be displayed by the cell
     */
    MatrixCell(int value) {
        this.value = value;
    }

    /**
     * Returns the value of the cell
     * @return the integer value of the cell
     */
    int getValue() { return this.value; }

    /**
     *
     * @param value Integer value of the cell
     */
    void setValue(int value) { this.value = value; }

    /**
     * Doubles the value of the cell
     */
    void dub() { this.value *= 2; }

    /**
     * Resets the value of the cell to NULL (0)
     */
    void clear() { this.value = NULL; }

    /**
     * Returns whether or not the value of the cell is equal to NULL (0)
     *
     * @return boolean true or false
     */
    boolean isNull() { return value == NULL; }

    @Override
    public void paintComponent(Graphics g) {

        switch (value) {
            case 0:
                g.setColor(new Color(4, 57, 94));
                break;
            case 2:
                g.setColor(new Color(112, 162, 136));
                g.setFont(new Font("SansSerif", Font.BOLD, 48));
                break;
            case 4:
                g.setColor(new Color(218, 183, 133));
                g.setFont(new Font("SansSerif", Font.BOLD, 48));
                break;
            case 8:
                g.setColor(new Color(213, 137, 111));
                g.setFont(new Font("SansSerif", Font.BOLD, 48));
                break;
            case 16:
                g.setColor(new Color(186, 63, 29));
                g.setFont(new Font("SansSerif", Font.BOLD, 42));
                break;
            case 32:
                g.setColor(new Color(69, 123, 157));
                g.setFont(new Font("SansSerif", Font.BOLD, 42));
                break;
            case 64:
                g.setColor(new Color(146, 173, 148));
                g.setFont(new Font("SansSerif", Font.BOLD, 42));
                break;
            case 128:
                g.setColor(new Color(26, 147, 111));
                g.setFont(new Font("SansSerif", Font.BOLD, 36));
                break;
            case 256:
                g.setColor(new Color(240, 200, 8));
                g.setFont(new Font("SansSerif", Font.BOLD, 32));
                break;
            case 512:
                g.setColor(new Color(240, 135, 0));
                g.setFont(new Font("SansSerif", Font.BOLD, 32));
                break;
            case 1024:
                g.setColor(new Color(217, 61, 57));
                g.setFont(new Font("SansSerif", Font.BOLD, 28));
                break;
            case 2048:
                g.setColor(new Color(101, 222, 241));
                g.setFont(new Font("SansSerif", Font.BOLD, 28));
                break;
        }

        g.fillRect(loc.x,loc.y, WIDTH, HEIGHT);

        g.setColor(Color.WHITE);

        if (value != 0) {
            if (value < 10) {
                g.drawString(String.valueOf(value), loc.x + 23, loc.y + 64);
            }
            else if (value > 10 && value < 50){
                g.drawString(String.valueOf(value), loc.x + 16, loc.y + 64);
            }
            else if (value > 50 && value < 100){
                g.drawString(String.valueOf(value), loc.x + 14, loc.y + 64);
            }
            else if (value > 100 && value < 150) {
                g.drawString(String.valueOf(value), loc.x + 4, loc.y + 60);
            }
            else if (value > 150 && value < 1000){
                g.drawString(String.valueOf(value), loc.x + 6 , loc.y + 60);
            }
            else {
                g.drawString(String.valueOf(value), loc.x, loc.y + 60);
            }
        }

    }

    void drawCell(Graphics g, int x, int y) {
        loc = new Point(x, y);
        this.paintComponent(g);
    }
}

