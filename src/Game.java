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


}
