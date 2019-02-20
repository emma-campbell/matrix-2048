package app.matrix.views;

import app.matrix.views.infoPanel.TopPanel;
import app.matrix.views.score.ScoreCenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame implements ActionListener, KeyListener {

    private final double width = 485, height = 700;
    private TopPanel top = new TopPanel();

    public GUI() {

        setSize((int) width, (int) height);
        addComponents();
        this.setVisible(true);
        this.setResizable(false);

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

        this.setLayout(new GridLayout(4, 1));
        this.add(top);

    }
}
