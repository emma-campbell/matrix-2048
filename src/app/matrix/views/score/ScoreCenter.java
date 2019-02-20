package app.matrix.views.score;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class ScoreCenter extends JComponent implements ActionListener {

    private Point center;
    private ScoreBlock currScore;
    private BestScore best;

    public ScoreCenter(int x, int y) {
        super();
        setCenter(x,y);
        currScore = new ScoreBlock(x-70, y-10);
        best = new BestScore(x+20, y-10);
    }

    public ScoreCenter(Point center) {
        super();
        setCenter(center);
    }

    public void setCenter(int x, int y) {
        center = new Point(x,y);
    }

    public void setCenter(Point center) {
        this.center = center;
    }

   @Override
   public void paintComponent(Graphics g) {
        super.paintComponent(g);
        currScore.paintComponent(g);
        best.paintComponent(g);
   }


   @Override
   public void  actionPerformed(ActionEvent e) {

   }
}

class ScoreBlock extends JComponent {

    private Point loc;
    private int score = 0;

    public ScoreBlock(int x, int y) {
        loc = new Point(x,y);
    }

    public ScoreBlock(Point p) {
        loc = p;
    }

    protected void add(int points) {
        score += points;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        //TODO add darker blue background later
        g.setColor(new Color(120, 202, 252));
        g.fillRect(loc.x, loc.y, 70, 50);


        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.BOLD, 12));
        g.drawString("SCORE", loc.x + 13, loc.y + 14);

        g.setFont(new Font("SansSerif", Font.BOLD, 24));
        g.drawString(String.valueOf(score), loc.x + 25, loc.y + 40);

    }
}

class BestScore extends JComponent {

    private Point loc;
    private int score = 0;

    public BestScore(int x, int y) {
        loc = new Point(x, y);
    }

    public BestScore(Point loc) {
        this.loc = loc;
    }

    protected void setBest(int score) {
        this.score = score;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //TODO add darker blue "border"
        g.setColor(new Color(120, 202, 252));
        g.fillRect(loc.x, loc.y, 70, 50);
        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.BOLD, 12));
        g.drawString("BEST", loc.x + 20, loc.y + 14);

        g.setFont(new Font("SansSerif", Font.BOLD, 24));
        g.drawString(String.valueOf(score), loc.x + 25, loc.y + 40);
    }
}