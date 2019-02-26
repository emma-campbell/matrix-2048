package app.matrix.views;

import app.matrix.gameplay.Game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame implements KeyListener {

    // Getting the keystrokes
    private final int up = KeyEvent.VK_UP;
    private final int down = KeyEvent.VK_DOWN;
    private final int left = KeyEvent.VK_LEFT;
    private final int right = KeyEvent.VK_RIGHT;

    private final int w = KeyEvent.VK_W;
    private final int s = KeyEvent.VK_S;
    private final int a = KeyEvent.VK_A;
    private final int d = KeyEvent.VK_D;

    private final double width = 500, height = 700;
    private Game game = new Game();

    public GUI() {

        super("Matrix [] 2048");
        setSize((int) width, (int) height);
        addComponents();
        this.setVisible(true);
        this.setResizable(false);
        addKeyListener(this);

    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.setColor(new Color(255, 217, 170));
        g.fillRect(0,0, (int)width, (int)height);
    }

    private void addComponents() {
        this.add(game, BorderLayout.CENTER);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        updateBoard(code);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void updateBoard(int e) {

        switch (e) {
            case s:
                game.swipeDown();
                break;
            case down:
                game.swipeDown();
                break;
            case w:
                game.swipeUp();
                break;
            case up:
                game.swipeUp();
                break;
            case a:
                game.swipeLeft();
                break;
            case left:
                game.swipeLeft();
                break;
            case d:
                game.swipeRight();
                break;
            case right:
                game.swipeRight();
                break;
        }
    }
}
