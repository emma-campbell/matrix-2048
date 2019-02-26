package app.matrix.views.score;

import javax.swing.*;
import java.awt.*;

/**
 * ScoreCenter Class contains the JComponent ScoreBlock and BestScore, representing what their
 * name states, respectively. Because the dimensions of my game window are fixed with, The place
 * -ment of thse two can be hard coded (ish.... dependedent on where the whole 'ScoreKeeper'
 * class is).
 *
 * @author emma-campbell
 * @version 1.0.0
 * @since 2019-02-26
 */
public class ScoreCenter extends JComponent {

    private Point center;
    private ScoreBlock currScore;
    private BestScore best;

    /**
     * Constructor ScoreCenter object
     *
     * @param x x-axis location to begin drawing
     * @param y y-axis location to begin drawing
     */
    public ScoreCenter(int x, int y) {
        super();
        setCenter(x,y);
        currScore = new ScoreBlock(x-70, y-10);
        best = new BestScore(x+20, y-10);
        this.setPreferredSize(new Dimension(400, 70));
    }

    /**
     * Constructor ScoreCenter object
     *
     * @param center Point(x,y) location to begin drawing
     */
    public ScoreCenter(Point center) {
        super();
        setCenter(center);
    }

    /**
     * Sets the point on canvas to draw
     *
     * @param x x-axis location to begin drawing
     * @param y y-axis location to begin drawing
     */
    private void setCenter(int x, int y) {
        center = new Point(x,y);
    }

    /**
     * Sets the point on canvas to draw
     *
     * @param center Point(x,y) location to begin drawing
     */
    private void setCenter(Point center) {
        this.center = center;
    }

    /**
     * Add points to current score
     *
     * @param points total points earned (per move)
     */
    public void addPoints(int points) {
        currScore.add(points);
    }


    /**
     * Sets the best score if beaten
     *
     * @param score new best score
     */
    public void setBest(int score) {
        best.setBest(score);
    }

    /**
     * Sets the best score (if beaten) and clears the scoring from last round.
     */
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

/**
 * ScoreBlock class - shows the user their current score
 */
class ScoreBlock extends JComponent {

    private Point loc; //location of block
    private int score = 0; //score value

    /**
     * Constructor ScoreBlock object
     *
     * @param x x-axis location
     * @param y y-axis location
     */
    ScoreBlock(int x, int y) {
        loc = new Point(x,y);
    }

    /**
     * Constructor ScoreBlock object
     *
     * @param p point(x,y) location
     */
    public ScoreBlock(Point p) {
        loc = p;
    }

    /**
     * Adds points to total score
     *
     * @param points points to be added
     */
    void add(int points) {
        score += points;
        repaint(); //refresh scoreboard
    }

    /**
     * returns the value being displayed
     *
     * @return this.score
     */
    int get() {
        return score;
    }

    /**
     * Removes the score and sets the scoreboard back to 0
     */
    void clear() {
        score = 0;
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

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

/**
 * BestScore - JComponent shows the user their best score
 */
class BestScore extends JComponent {

    private Point loc;
    private int score = 0;

    /**
     * Constructor BestScore object
     * @param x x-axis location
     * @param y y-axis location
     */
    BestScore(int x, int y) {
        loc = new Point(x, y);
    }

    /**
     * Constructor BestScore object
     * @param loc point(x,y) location
     */
    public BestScore(Point loc) {
        this.loc = loc;
    }

    /**
     * Sets the new best score to display
     * @param score new score to display
     */
    void setBest(int score) {
        this.score = score;
    }

    /**
     * Returns the value displayed by BestScore object
     * @return current leader... best score
     */
    int get() {
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