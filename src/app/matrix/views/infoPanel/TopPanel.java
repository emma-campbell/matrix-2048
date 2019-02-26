package app.matrix.views.infoPanel;

import app.matrix.views.score.ScoreCenter;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TopPanel extends JPanel {

    private JLabel title = new JLabel("MATRIX[]2048", SwingConstants.CENTER);
    private ScoreCenter score = new ScoreCenter(235, 8);

    public TopPanel() {
        super();
        this.setBackground(new Color(213, 202, 188));
        this.setLayout(new GridLayout(2, 1));
        addComponents();
    }

    public void reset() {
        score.reset();
    }

    public void addPoints(int points) {
        score.addPoints(points);
    }

    public void setBest(int score) {
        this.score.setBest(score);
    }

    protected void addComponents() {

        //setting up title

        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        this.add(title, BorderLayout.NORTH);

//        adding scoreboard
        this.add(score, BorderLayout.SOUTH);
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }
}
