package app.matrix.views;

import app.matrix.gameplay.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * GUI class serves as the user interface and listener for key bindings so that the user may
 * input different key values (w,s,a,d or up, down, left, right)
 *
 * @author emma-campbell
 * @version 1.0.0
 * @since 2019-02-26
 */
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

    /**
     * Constructor
     */
    public GUI() {
        super("Matrix [] 2048");
        setSize((int) width, (int) height);
        addComponents();
        this.setVisible(true);
        this.setResizable(false); //window is fixed (to make graphic implementation easier)
        addKeyListener(this); //to get user inut
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.setColor(new Color(255, 217, 170));
        g.fillRect(0,0, (int)width, (int)height);
    }

    /**
     * Adds the main panel to the frame
     */
    private void addComponents() {
        this.add(game, BorderLayout.CENTER);
    }

    /* OVERRIDDEN KEYLISTENER METHODS */

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

    /* OTHER */

    /**
     * Take in user key input w, s, a, d or up, down, left, right (two cases for this reason)
     * Tells the game which was to 'swipe' the tiles
     *
     * @param e KeyEvent.getKeyCode();
     */
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
