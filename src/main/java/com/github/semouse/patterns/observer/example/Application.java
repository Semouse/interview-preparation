package com.github.semouse.patterns.observer.example;

import javax.swing.*;
import java.awt.*;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        SwingUtilities.invokeLater(application::go);
    }

    private void go() {
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(200, 100));
        frame.pack();
        frame.setVisible(true);

        JLabel label = new JLabel("Test label");
        frame.getContentPane().add(label);

        JButton button = new JButton("Should I do it");
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
        frame.getContentPane().add(BorderLayout.CENTER, button);
    }
}
