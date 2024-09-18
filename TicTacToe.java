import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    Random rand = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JPanel menu_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton replayButton = new JButton("Replay");
    JButton homeButton = new JButton("Home");
    boolean player1_turn;
    boolean playing = true;


    TicTacToe() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,800);
        frame.getContentPane().setBackground(new Color(0,10,20));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(0,0,0));
        textField.setForeground(new Color(255, 255,255));
        textField.setFont(new Font("Helvetica", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));

        menu_panel.setLayout(new GridLayout(1,2));

        for(int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Helvetica", Font.BOLD, 75));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setRolloverEnabled(false);
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }


        homeButton.setFont(new Font("Helvetica", Font.BOLD, 25));
        homeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        homeButton.setBackground(Color.WHITE);
        homeButton.setForeground(Color.BLACK);
        homeButton.addActionListener(this);
        menu_panel.add(homeButton);

        replayButton.setFont(new Font("Helvetica", Font.BOLD, 25));
        replayButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        replayButton.setBackground(Color.WHITE);
        replayButton.setForeground(Color.BLACK);
        replayButton.addActionListener(this);
        menu_panel.add(replayButton);


        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        frame.add(menu_panel, BorderLayout.SOUTH);


        firstTurn();
    }

    private void firstTurn() {

        if(rand.nextInt(2) == 0) {
            player1_turn = true;
            textField.setText("X turn");
        }
        else {
            player1_turn = false;
            textField.setText("O turn");
        }
    }

    public void check() {

        if(
             (Objects.equals(buttons[0].getText(), "X")) &&
             (Objects.equals(buttons[1].getText(), "X")) &&
             (Objects.equals(buttons[2].getText(), "X"))
        ){
            xWins(0,1,2);
        }
        if(
                (Objects.equals(buttons[3].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[5].getText(), "X"))
        ){
            xWins(3,4,5);
        }
        if(
                (Objects.equals(buttons[6].getText(), "X")) &&
                (Objects.equals(buttons[7].getText(), "X")) &&
                (Objects.equals(buttons[8].getText(), "X"))
        ){
            xWins(6,7,8);
        }
        if(
                (Objects.equals(buttons[0].getText(), "X")) &&
                (Objects.equals(buttons[3].getText(), "X")) &&
                (Objects.equals(buttons[6].getText(), "X"))
        ){
            xWins(0,3,6);
        }
        if(
                (Objects.equals(buttons[1].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[7].getText(), "X"))
        ){
            xWins(1,4,7);
        }
        if(
                (Objects.equals(buttons[2].getText(), "X")) &&
                (Objects.equals(buttons[5].getText(), "X")) &&
                (Objects.equals(buttons[8].getText(), "X"))
        ){
            xWins(2,5,8);
        }
        if(
                (Objects.equals(buttons[0].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[8].getText(), "X"))
        ){
            xWins(0,4,8);
        }
        if(
                (Objects.equals(buttons[2].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[6].getText(), "X"))
        ){
            xWins(2,4,6);
        }
        if(
                (Objects.equals(buttons[0].getText(), "O")) &&
                (Objects.equals(buttons[1].getText(), "O")) &&
                (Objects.equals(buttons[2].getText(), "O"))
        ){
            oWins(0,1,2);
        }
        if(
                (Objects.equals(buttons[3].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[5].getText(), "O"))
        ){
            oWins(3,4,5);
        }
        if(
                (Objects.equals(buttons[6].getText(), "O")) &&
                (Objects.equals(buttons[7].getText(), "O")) &&
                (Objects.equals(buttons[8].getText(), "O"))
        ){
            oWins(6,7,8);
        }
        if(
                (Objects.equals(buttons[0].getText(), "O")) &&
                (Objects.equals(buttons[3].getText(), "O")) &&
                (Objects.equals(buttons[6].getText(), "O"))
        ){
            oWins(0,3,6);
        }
        if(
                (Objects.equals(buttons[1].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[7].getText(), "O"))
        ){
            oWins(1,4,7);
        }
        if(
                (Objects.equals(buttons[2].getText(), "O")) &&
                (Objects.equals(buttons[5].getText(), "O")) &&
                (Objects.equals(buttons[8].getText(), "O"))
        ){
            oWins(2,5,8);
        }
        if(
                (Objects.equals(buttons[0].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[8].getText(), "O"))
        ){
            oWins(0,4,8);
        }
        if(
                (Objects.equals(buttons[2].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[6].getText(), "O"))
        ){
            oWins(2,4,6);
        }
    }

    public void xWins(int a, int b, int c) {
        textField.setText("xWins");
        buttons[a].setForeground(new Color(0,0,255));
        buttons[b].setForeground(new Color(0,0,255));
        buttons[c].setForeground(new Color(0,0,255));
        playing = false;
    }

    public void oWins(int a, int b, int c) {
        textField.setText("oWins");
        buttons[a].setForeground(new Color(255, 0, 0));
        buttons[b].setForeground(new Color(255, 0, 0));
        buttons[c].setForeground(new Color(255, 0, 0));
        playing = false;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (playing) {
                    if (player1_turn) {
                        if (Objects.equals(buttons[i].getText(), "")) {
                            buttons[i].setForeground(new Color(113, 113, 239));
                            buttons[i].setText("X");
                            player1_turn = false;
                            textField.setText("O Turn");
                            check();
                        }
                    } else {
                        if (Objects.equals(buttons[i].getText(), "")) {
                            buttons[i].setForeground(new Color(239, 113, 113));
                            buttons[i].setText("O");
                            player1_turn = true;
                            textField.setText("X Turn");
                            check();
                        }
                    }
                }
            }
        }
        if (e.getSource() == replayButton) {
            for (int i = 0; i < 9; i++) {
                buttons[i].setText("");
            }
            firstTurn();
            playing = true;
        }
    }
}

