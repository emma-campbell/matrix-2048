import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author emma-campbell
 * @version 1.0
 * @since 2019-02-18
 *
 */
public class Game {

    private Matrix board = new Matrix();
    private int score;

    public Game() {
        this.start();
    }

    /**
     * Places two random pieces on the board and initializes the score to zero
     */
    private void start() {

        for (int i=0; i <= 1; i++) {
            board.placeRandom();
        }

        score = 0;
    }


    /**
     * Adds point from the previous move to the total score
     *
     * @param points integer representing the points from the previous move
     * @return void
     */
    private void updateScore(int points) {
        score += points;
    }


    /**
     * if swipeUp() is a valid move, game will move the matrix up
     *
     * @return void
     */
    private void swipeUp() {
        if (board.move(3)) {
            int points = board.up();
            board.placeRandom();
            board.print();
            updateScore(points);
        }
    }

    /**
     * if swipeDown() is a valid move, game moves the matrix, adds a new block, and updates score
     *
     * @return void
     */
    private void swipeDown() {
        if (board.move(4)) {
            int points = board.down();
            board.placeRandom();
            board.print();
            updateScore(points);
        }
    }

    /**
     * if swipeLeft() is a valid move, game moves the matrix, adds a new block, and updates score
     *
     * @return void
     */
    private void swipeLeft() {
        if (board.move(1)) {
            int points = board.left();
            board.placeRandom();
            board.print();
            updateScore(points);
        }
    }

    /**
     * if swipeRight() is a valid move, game will move the matrix, add a random tile, and update the score
     *
     * @return void
     */
    private void swipeRight() {
        if (board.move(2)) {
            int points = board.right();
            board.placeRandom();
            board.print();
            updateScore(points);
        }
    }

}
