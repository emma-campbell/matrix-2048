package app.matrix;

import javax.swing.*;
import app.matrix.*;

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
