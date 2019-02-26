package app.matrix.views.score;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class ScoreCenter extends JComponent {

    private Point center;
    private ScoreBlock currScore;
    private BestScore best;

    public ScoreCenter(int x, int y) {
        super();
        setCenter(x,y);
        currScore = new ScoreBlock(x-70, y-10);
        best = new BestScore(x+20, y-10);
        this.setPreferredSize(new Dimension(400, 70));
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

    public void addPoints(int points) {
        currScore.add(points);
    }


    public void setBest(int score) {
        best.setBest(score);
    }

    public void reset() {

        int bestval = best.get();
        int currval = currScore.get();

        if (bestval < currval) {
            best.setBest(currval);
            currScore.clear();
        }
        else {
            currScore.clear();
        }

    }

   @Override
   public void paintComponent(Graphics g) {
        super.paintComponent(g);
        currScore.paintComponent(g);
        best.paintComponent(g);
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

    public int get() {
        return score;
    }

    public void clear() {
        score = 0;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        //TODO add darker blue background later
        g.setColor(new Color(125, 115, 103));
        g.fillRect(loc.x, loc.y, 70, 50);

        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.BOLD, 12));
        g.drawString("SCORE", loc.x + 13, loc.y + 14);

        if (score < 10) {
            g.setFont(new Font("SansSerif", Font.BOLD, 24));
            g.drawString(String.valueOf(score), loc.x + 26, loc.y + 40);
        }
        else if (score > 10 && score < 100) {
            g.setFont(new Font("SansSerif", Font.BOLD, 22));
            g.drawString(String.valueOf(score), loc.x + 20, loc.y + 40);
        }
        else if (score > 100 && score < 1000) {
            g.setFont(new Font("SansSerif", Font.BOLD, 20));
            g.drawString(String.valueOf(score), loc.x + 14, loc.y + 40);
        }
        else if (score > 1000 && score < 10000) {
            g.setFont(new Font("SansSerif", Font.BOLD, 18));
            g.drawString(String.valueOf(score), loc.x + 10, loc.y + 40);
        }
        else if (score > 10000 && score < 100000) {
            g.setFont(new Font("SansSerif", Font.BOLD, 14));
            g.drawString(String.valueOf(score), loc.x + 12, loc.y + 38);
        }
        else {
            g.setFont(new Font("SansSerif", Font.BOLD, 22));
            g.drawString(String.valueOf(score), loc.x + 5, loc.y + 40);
        }
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

    public int get() {
        return score;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //TODO add darker blue "border"
        g.setColor(new Color(125, 115, 103));
        g.fillRect(loc.x, loc.y, 70, 50);

        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.BOLD, 12));
        g.drawString("BEST", loc.x + 20, loc.y + 14);

        if (score < 10) {
            g.setFont(new Font("SansSerif", Font.BOLD, 24));
            g.drawString(String.valueOf(score), loc.x + 26, loc.y + 40);
        }
        else if (score > 10 && score < 100) {
            g.setFont(new Font("SansSerif", Font.BOLD, 22));
            g.drawString(String.valueOf(score), loc.x + 20, loc.y + 40);
        }
        else if (score > 100 && score < 1000) {
            g.setFont(new Font("SansSerif", Font.BOLD, 20));
            g.drawString(String.valueOf(score), loc.x + 14, loc.y + 40);
        }
        else if (score > 1000 && score < 10000) {
            g.setFont(new Font("SansSerif", Font.BOLD, 18));
            g.drawString(String.valueOf(score), loc.x + 10, loc.y + 40);
        }
        else if (score > 10000 && score < 100000) {
            g.setFont(new Font("SansSerif", Font.BOLD, 14));
            g.drawString(String.valueOf(score), loc.x + 14, loc.y + 40);
        }
        else {
            g.setFont(new Font("SansSerif", Font.BOLD, 22));
            g.drawString(String.valueOf(score), loc.x + 5, loc.y + 40);
        }
    }
}