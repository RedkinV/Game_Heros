package ru.geekbrains.java2.game_gui;

import javax.swing.*;
import java.awt.*;

public class TeamPanel extends JPanel {
    private JPanel panel=new JPanel();
    private JLabel team1Label=new JLabel("Team 1");
    private JComboBox team1ComboBox=new JComboBox();
    private JButton team1ChooseBtn=new JButton("Choose");
    private JTextField team1List=new JTextField(13);

    public TeamPanel() {
        //panel.setLayout(new BorderLayout());
        panel.add(team1Label);
        panel.add(team1ComboBox);
        //team1ChooseBtn.setBounds(500, 500, 200, 100);
        panel.add(team1ChooseBtn);
        panel.add(team1List);
        panel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        panel.setBackground(Color.ORANGE);
        //panel.setOpaque(true);
    }
}
