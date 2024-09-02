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

    TicTacToe() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(0,10,20));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(120,100,250));
        textField.setForeground(new Color(255, 255,255));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
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
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 75));
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
             (buttons[0].getText()=="X") &&
             (buttons[1].getText()=="X") &&
             (buttons[2].getText()=="X")
        ){

        }

    }

    public void xWins(int a, int b, int c) {

    }

    public void oWins(int a, int b, int c) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if(player1_turn) {
                    if(buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.ORANGE);
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("O Turn");
                        check();
                    }
                }
                else {
                    if(buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.CYAN);
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
