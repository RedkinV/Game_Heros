package ru.geekbrains.java2.game_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeroFrame extends JFrame {


    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();

    private JLabel instructions = new JLabel("Выберите по 3 война в команду.");

    private JLabel team1Label = new JLabel("Набери команду: ");
    private JComboBox team1ComboBox;
    private JButton team1ChooseBtn = new JButton("Зачислить");
    private JTextField team1List = new JTextField(20);
    private JTextArea textT1=new JTextArea("");

    private JLabel team2Label = new JLabel("Набери команду: ");
    private JComboBox team2ComboBox;
    private JButton team2ChooseBtn = new JButton("Зачислить");
    private JTextField team2List = new JTextField(20);
    private JTextArea textT2=new JTextArea("");

    private JButton fightBtn = new JButton("Fight!");
    private JTextField resultsTextField = new JTextField(13);

    Game_1 game1 =new Game_1();



    public HeroFrame(String nameFrame) {


        panel1.setPreferredSize(new Dimension(300,50));
        panel1.add(team1Label);
        team1ComboBox = new JComboBox(game1.getAllTeamNames(game1.getTeam1Arr()));
        panel1.add(team1ComboBox);
        ChooseButtonListener1 cbl1 = new ChooseButtonListener1();
        team1ChooseBtn.addActionListener(cbl1);
        panel1.add(team1ChooseBtn);
        panel1.add(team1List);
        panel1.add(textT1);
        panel1.setBorder(BorderFactory.createTitledBorder("Team1"));

        panel2.add(team2Label);
        team2ComboBox = new JComboBox(game1.getAllTeamNames(game1.getTeam2Arr()));
        panel2.add(team2ComboBox);
        ChooseButtonListener2 cbl2 = new ChooseButtonListener2();
        team2ChooseBtn.addActionListener(cbl2);
        panel2.add(team2ChooseBtn);
        panel2.add(team2List);
        panel2.add(textT2);
        panel2.setBorder(BorderFactory.createTitledBorder("Team2"));

        FightButtonListener fbl= new FightButtonListener();
        fightBtn.addActionListener(fbl);
        panel3.add(fightBtn);
        panel3.add(resultsTextField);
        panel3.setBorder(BorderFactory.createTitledBorder("Results"));


        this.setTitle(nameFrame);
        this.add(panel1, BorderLayout.WEST);
        this.add(panel2, BorderLayout.EAST);
        this.add(panel3, BorderLayout.SOUTH);
    }



    class ChooseButtonListener1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            textT1.setText(Integer.toString(team1ComboBox.getSelectedIndex()));
            Hero teamMember=game1.getTeam1Arr()[team1ComboBox.getSelectedIndex()];
            if (game1.addMember(teamMember, game1.getTeam1())) {
                team1List.setText(team1List.getText() + team1ComboBox.getSelectedItem() + ", ");
                textT1.setText("ok");
            } else textT1.setText("команда заполнилась. мест нет");

        }
    }
    class ChooseButtonListener2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            textT2.setText(Integer.toString(team2ComboBox.getSelectedIndex()));
            Hero teamMember=game1.getTeam2Arr()[team2ComboBox.getSelectedIndex()];
            if (game1.addMember(teamMember, game1.getTeam2())) {
                team2List.setText(team2List.getText() + team2ComboBox.getSelectedItem() + ", ");
                textT2.setText("ok");
            } else textT2.setText("команда заполнилась. мест нет");

        }
    }

    class FightButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //resultsTextField.setText(String.valueOf(game1.areTeamsFull()));
            if (!game1.areTeamsFull()) {
                resultsTextField.setText("Сперва заполни команды!");
            } else {
                game1.begin();
                resultsTextField.setText("Поехали!");
                for (Hero t1: game1.getTeam1()) {
                   resultsTextField.setText(resultsTextField.getText()+t1.info()+"   ");

                }

                for (Hero t2: game1.getTeam2()) {
                    resultsTextField.setText(resultsTextField.getText()+t2.info()+"   ");
                }

            }

        }
    }

}
