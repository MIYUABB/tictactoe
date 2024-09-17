import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    Random rand = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    boolean playing = true;

    TicTacToe() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
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
        button_panel.setBackground(new Color(120,100,250));

        for(int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Helvetica", Font.BOLD, 75));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

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
        buttons[a].setForeground(Color.yellow);
        buttons[b].setForeground(Color.yellow);
        buttons[c].setForeground(Color.yellow);
        player1_turn = false;
            
    }

    public void oWins(int a, int b, int c) {
        textField.setText("oWins");
        buttons[a].setForeground(Color.yellow);
        buttons[b].setForeground(Color.yellow);
        buttons[c].setForeground(Color.yellow);
        playing = false;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (playing) {
                    if (player1_turn) {
                        if (Objects.equals(buttons[i].getText(), "")) {
                            buttons[i].setForeground(Color.BLUE);
                            buttons[i].setText("X");
                            player1_turn = false;
                            textField.setText("O Turn");
                            check();
                        }
                    } else {
                        if (Objects.equals(buttons[i].getText(), "")) {
                            buttons[i].setForeground(Color.GREEN);
                            buttons[i].setText("O");
                            player1_turn = true;
                            textField.setText("X Turn");
                            check();
                        }
                    }
                }
            }
        }
    }
}

