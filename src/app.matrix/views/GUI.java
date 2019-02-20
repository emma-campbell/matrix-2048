import javax.swing.*;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame implements ActionListener, KeyListener {

    private Dimension dim = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    private final double width = dim.getWidth(), height = dim.getHeight();

    private JLabel title = new JLabel("MATRIX[]2048");

    private JPanel view = new JPanel();
    private JPanel status = new JPanel();

    private JLabel scrLabel = new JLabel("SCORE");
    private JButton score = new JButton();

    private JLabel maxLabel = new JLabel("BEST");
    private JButton maxScore = new JButton();


    public GUI() {

        setSize((int)width, (int)height);
        addComponents();

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

        this.add(title, BorderLayout.NORTH);

        score.add(scrLabel, BorderLayout.NORTH);
        maxScore.add(maxLabel, BorderLayout.NORTH);

        status.add(score);
        status.add(maxScore);

        view.add(title, BorderLayout.NORTH);
        view.add(status, BorderLayout.NORTH);

        this.add(status, BorderLayout.NORTH);

    }
}
