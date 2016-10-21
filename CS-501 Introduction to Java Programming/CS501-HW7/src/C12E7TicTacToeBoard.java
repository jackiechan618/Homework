/*******************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 9th Edition, Chapter 12, Exercise 7
 * 
 *******************************************/

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;

public class C12E7TicTacToeBoard extends JFrame {
private ImageIcon x = new ImageIcon("image/X.jpg");
private ImageIcon o = new ImageIcon("image/O.jpg");



public static void main(String[] args) {
    C12E7TicTacToeBoard frame = new C12E7TicTacToeBoard();
    frame.setTitle("C12E7TicTacToeBoard");
    frame.setSize(200, 200);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(3);
    frame.setVisible(true);
  }

public C12E7TicTacToeBoard() {
    setLayout(new GridLayout(3, 3));

    for (int i = 0; i < 9; i++) {
        int mode = (int) (Math.random() * 3.0);
        if (mode == 0)
            add(new JLabel(this.x));
        else if (mode == 1)
            add(new JLabel(this.o));
        else
            add(new JLabel());
    }
 }
}