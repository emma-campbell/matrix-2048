import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author emma-campbell
 * @version 1.0
 * @since 2019-02-18
 *
 */
public class Game implements KeyListener {

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

    private void play() {
        while (board.movesRemaining()) {

        }
    }

    /**
     * Adds point from the previous move to the total score
     *
     * @param points integer representing the points from the previous move
     */
    private void updateScore(int points) {
        score += points;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char dir = e.getKeyChar();

        if (dir == 'w' || e.getKeyCode() == 38) { //if user inputs up
            if (board.move(3)) {
                System.out.println("valid");
                int points = board.up();
                board.placeRandom();
                board.print();
                updateScore(points);

            }
            else {
                System.out.println("invalid");
            }
        }

        if (dir == 'a' || e.getKeyCode() == 37) { //if user inputs left
            if (board.move(1)) {
                System.out.println("valid");
                int points = board.left();
                board.placeRandom();
                board.print();
                updateScore(points);
            }
            else {
                System.out.println("invalid");
            }
        }

        if (dir == 's' || e.getKeyCode() == 40) { //if user inputs down
            if (board.move(4)) {
                System.out.println("valid");
                int points = board.down();
                board.placeRandom();
                board.print();
                updateScore(points);
            }
            else {
                System.out.println("invalid");
            }
        }

        if (dir == 'd' || e.getKeyCode() == 39) { //if user inputs right
            if (board.move(2)) {
                System.out.println("valid");
                int points = board.right();
                board.placeRandom();
                board.print();
                updateScore(points);
            }
            else {
                System.out.println();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
