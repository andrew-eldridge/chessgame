/*
    Graphical user interface
 */

package chess;

import javax.swing.*;
import java.awt.*;

public class GUI {

    // Initialize chess.GUI
    public GUI() {
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chess");
        frame.pack();
        frame.setVisible(true);
    }

}
