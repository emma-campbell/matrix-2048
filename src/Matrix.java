import javax.swing.*;
import java.util.Random;
/**
 * @author emma-campbell
 * @version 1.0
 * @since 2019-02-16
 */
public class Matrix extends JComponent {

    private Random r = new Random();
    private MatrixCell[][] matrix = new MatrixCell[4][4];
    private static final int NULL = 0;

    /**
     * Constructor that initializes the game board with all empty slots, then places two
     * random tiles in random places
     */
    Matrix() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = new MatrixCell(NULL);
            }
        }
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
    int get(int i, int j) {
        return matrix[i][j].getValue();
    }

    /**
     * Sets the values of a cell at position i, j
     *
     * @param i index moving up and down
     * @param j index moving left to right
     * @param val integer value to set the cell to
     */
    void set(int i, int j, int val) {
        matrix[i][j].setValue(val);
    }

    /**
     * Move all cells to the left
     */
    void left() {
        slide(1);
        System.out.println("left");
    }

    /**
     * Moves all cells to the right
     */
    void right() {
        slide(2);
        System.out.println("right");
    }

    /**
     * Moves all cells up
     */
    void up() {
        slide(3);
        System.out.println("up");
    }

    /**
     * Moves all cells down
     */
    void down() {
        slide(4);
        System.out.println("down");
    }

    /**
     * Slides all ties to a given direction and combines equivalent pieces
     *
     * @param dir the direction the user moves the board (1 -left, 2 - right, 3 - up, 4 -
     *            down)
     */
    private void slide(int dir) {
        boolean cont = true;
        if (dir == 1) {
            for (MatrixCell[] row: matrix) {
                do {
                    for (int i = 0; i < row.length -1; i++) {
                        //if cell is not NULL
                        if (!(row[i].isNull())) {
                            if (row[i].getValue() == row[i+1].getValue()) {
                                row[i].dub();
                                row[i+1].clear();

                                int n = i + 1;

                                while (n < row.length - 1) {
                                    row[n].setValue(row[n + 1].getValue());
                                    row[n+1].clear();
                                    n += 1;
                                }
                                row[row.length -1].clear();
                            }
                        }
                        else {
                            int n = i+1;
                            while (n <= row.length - 1 && n != -1) {
                                if (row[n].getValue() == 0) {
                                    n += 1;
                                }
                                else if ((row[n].getValue() != row[i].getValue()) && (row[i].getValue() == 0)) {
                                    row[i].setValue(row[n].getValue());
                                    row[n].clear();
                                    n = -1;
                                }
                                else if (row[i].getValue() == row[n].getValue() && (row[i].getValue() != 0)){
                                    row[i].dub();
                                    row[n].clear();
                                    n = -1;
                                }
                            }
                        }
                    }
                } while (areDups(1, row));
            }
        }

        /*
         * when @param dir is equivalent to the integer 2, the user has slide to
         * the right.
         */
        if (dir == 2) {
            for (MatrixCell[] row : matrix) {
                do {
                    for (int i = row.length - 1; i > 0; i--) {
                        //if cell is not NULL
                        if (!(row[i].isNull())) {
                            if (row[i].getValue() == row[i - 1].getValue()) {
                                row[i].dub();
                                row[i - 1].clear();

                                int n = i - 1;

                                while (n > 0) {
                                    row[n].setValue(row[n - 1].getValue());
                                    row[n - 1].clear();
                                    n -= 1;
                                }

                            }
                        } else {
                            int n = i - 1;
                            while (n >= 0) {
                                if (row[n].getValue() == 0) {
                                    n -= 1;
                                } else if ((row[n].getValue() != row[i].getValue()) && (row[i].getValue() == 0)) {
                                    row[i].setValue(row[n].getValue());
                                    row[n].clear();
                                    n = -1;
                                }
                                else if (row[i].getValue() == row[n].getValue() && (row[i].getValue() != 0)){
                                    row[i].dub();
                                    row[n].clear();
                                    n = -1;
                                }
                            }
                        }
                    }
                } while (areDups(2, row));
            }
        }

        /*
         * when @param dir is equivalent to the integer 3, the user has slid to
         * top
         */
        if (dir == 3) {
            do { // while there are no duplicates  next to each other in the row
                int curr = 0;
                int next = 0;
                for (int j = matrix.length - 1; j > 0; j--) {
                    for (int i = 0; i < matrix[j].length - 1; i++) {
                        curr = matrix[i][j].getValue();
                        next = matrix[i][j].getValue();

                        if (!(matrix[i][j].isNull())) {

                            if (curr == next) {
                                matrix[i][j].dub();
                                matrix[i+1][j].clear();

                                int n = i + 1;
                                while (n < matrix[j].length - 1) {
                                    matrix[n][j].setValue(matrix[n+1][j].getValue());
                                    matrix[n+1][j].clear();
                                    n += 1;
                                }
                            }
                        }
                        else {
                            int n = i + 1;
                            while (n < matrix.length -1  && n >= 0) {
                                if (matrix[n][j].getValue() == 0) {
                                    n += 1;
                                }
                                else if (matrix[n][j].getValue() != matrix[i][j].getValue() && (matrix[n][j].getValue() != 0)) {
                                    matrix[i][j].setValue(matrix[n][j].getValue());
                                    matrix[n][j].clear();
                                    n = -1;
                                }
                                else if (matrix[n][j].getValue() == matrix[i][j].getValue() && (matrix[n][j].getValue() != 0)) {
                                    matrix[i][j].dub();
                                    matrix[n][j].clear();
                                    n = -1;
                                }
                            }
                        }
                    }
                }
            } while (areDups(3));
        }

        /*
         * when @param dir is equivalent to the integer 4, the user has slid to
         * bottom
         */
        if (dir == 4) {

            do {
                int curr = 0;
                int next = 0;

                for (int j = matrix.length - 1; j >= 0; j--) {
                    for (int i = matrix.length -1; i > 0; i--) {
                        curr = matrix[i][j].getValue();
                        next = matrix[i-1][j].getValue();

                        if (!(matrix[i][j].isNull())) {
                            if (curr == next) {
                                matrix[i][j].dub();
                                matrix[i-1][j].clear();

                                int n = i - 1;

                                while (n > 0) {
                                    matrix[n][j].setValue(matrix[n-1][j].getValue());
                                    matrix[n-1][j].clear();
                                    n -= 1;
                                }
                            }
                        }
                        else {
                            int n = i - 1;
                            while (n >= 0) {
                                if (matrix[n][j].isNull()) {
                                    n -= 1;
                                }
                                else if (!(matrix[n][j].isNull())) {
                                    matrix[i][j].setValue(matrix[n][j].getValue());
                                    matrix[n][j].clear();
                                    n = -1;
                                }
                                else if (matrix[n][j].getValue() != matrix[i][j].getValue() && (matrix[n][j].getValue() != 0)){
                                    matrix[i][j].dub();
                                    matrix[n][j].clear();
                                    n = -1;
                                }
                            }
                        }
                    }
                }
            } while(areDups(4));
        }

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
     * Method that sets the value to one for each of the cells. This method is mainly for
     * testing purposes
     *
     */
    void fill() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j].setValue(1);
            }
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
     * Method that determines if there are still duplicates going in a certain direction
     *
     * @param dir direction slide is going
     * @param row the row that slide is on
     * @return boolean true or false
     */
    private boolean areDups(int dir, MatrixCell[] row) {
        if (dir == 1 || dir == 2) {
            for (int i = row.length - 1; i > 0; i--) {
                if (row[i].getValue() == row[i - 1].getValue() && !(row[i].isNull())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param dir integer representing direction of travel
     * @return boolean true or false
     */
    private boolean areDups(int dir) {
        if (dir == 3 || dir == 4) {

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length - 1; j++) {
                    if (matrix[j][i].getValue() == matrix[j+1][i].getValue() && !(matrix[j][i].isNull())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Places a cell with a value of 2 or 0 where there is a null space in the matrix
     */
    void placeRandom() {

        int val = 2 * (r.nextInt(2) + 1);
        int i = (r.nextInt(4));
        int j = (r.nextInt(4));

        while (!(matrix[i][j]).isNull()) {
            i = (r.nextInt(4));
            j = (r.nextInt(4));
        }

        matrix[i][j] = new MatrixCell(val);
    }
}

/**
 * @author emma-campbell
 * @version 0.1
 * @since 2019-02-16
 */
class MatrixCell {

    private static final int NULL = 0;
    private int value;

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

}

