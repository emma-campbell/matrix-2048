package app.matrix.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class ScoreKeeper extends JComponent implements ActionListener {
    private Point center;

    public ScoreKeeper(int x, int y) {
        super();
        setCenter(x,y);
    }

    public ScoreKeeper(Point center) {
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
        g.setColor(new Color(120,202, 252));
        g.fillRect(center.x - 30, center.y - 10, 60, 40);
        g.fillRect(center.x + 40, center.y - 10, 60, 40);
//        g.setColor(Color.WHITE);
//        g.drawString("SCORE", center.x - 20, center.y - 8);
   }

//   public void

   @Override
   public void  actionPerformed(ActionEvent e) {

   }
}

class ScoreBlock extends JComponent {
    private Point loc;

    public ScoreBlock(int x, int y) {
        loc = new Point(x,y);
    }
}