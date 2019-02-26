package app.matrix.views.infoPanel;

import app.matrix.views.score.ScoreCenter;

import javax.swing.*;
import java.awt.*;

/**
 * Top Panel can be considered a 'wrapper' for the title and score board. I decided to make
 * this a seperate panel from the game, mianly in part that keeping classes seperate is
 * more benefical to me organizationally.
 *
 * @author emma-campbell
 * @version 1.0.0
 * @since 2019-02-26
 */
public class TopPanel extends JPanel {

    private JLabel title = new JLabel("MATRIX[]2048", SwingConstants.CENTER);
    private ScoreCenter score = new ScoreCenter(235, 8);

    /**
     * Constructor
     */
    public TopPanel() {
        super();
        this.setBackground(new Color(213, 202, 188));
        this.setLayout(new GridLayout(2, 1));
        addComponents();
    }

    /**
     * Resets the score board
     */
    public void reset() {
        score.reset();
    }

    /**
     * Adds points to the score
     * @param points points to be added
     */
    public void addPoints(int points) {
        score.addPoints(points);
    }

    /**
     * Sets a new best score
     * @param score new best score to be set
     */
    public void setBest(int score) {
        this.score.setBest(score);
    }

    /**
     * Adds the title and the score to the panel
     */
    private void addComponents() {

        //setting up title

        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        this.add(title, BorderLayout.NORTH);

        // adding score board
        this.add(score, BorderLayout.SOUTH);
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }
}
