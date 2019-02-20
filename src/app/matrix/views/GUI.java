package app.matrix.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame implements ActionListener, KeyListener {

    private final double width = 500, height = 500;
    private ScoreKeeper score = new ScoreKeeper((int)((1.0/4.0) * width), (int)((1.0/5.0) * height));

    private JLabel title = new JLabel("MATRIX[]2048", SwingConstants.CENTER);

    public GUI() {

        setSize((int) width, (int) height);
        addComponents();
        this.setVisible(true);

    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void addComponents() {

        title.setVerticalAlignment(SwingConstants.NORTH);

        title.setFont(new Font("SansSerif", Font.PLAIN, 24));
        this.add(title);
        this.add(score);

    }
}
