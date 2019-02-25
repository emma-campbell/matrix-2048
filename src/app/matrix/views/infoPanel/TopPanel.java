package app.matrix.views.infoPanel;

import app.matrix.views.score.ScoreCenter;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {

    private JLabel title = new JLabel("MATRIX[]2048", SwingConstants.CENTER);
    private ScoreCenter score = new ScoreCenter(235, 8);

    public TopPanel() {
        super();
        this.setLayout(new GridLayout(2,1));
        this.setBackground(new Color(213, 202, 188));
        addComponents();
    }

    protected void addComponents() {

        //setting up title
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        this.add(title);
        //adding scoreboard
        this.add(score);
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        title.paint(g);
        score.paintComponent(g);
    }
}
