import javax.swing.*;
import app.matrix.views.GUI;

/**
 * Entrance point to the application
 *
 * @author emma-campbell
 * @version 1.0.0
 * @since 2019-02-26
 */
public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GUI();
            }
        });
    }
}
