package com.github.semouse.patterns.observer.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DevilListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Come on, do it");
    }
}
