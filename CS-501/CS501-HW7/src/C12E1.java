/*******************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 9th Edition, Chapter 12, Exercise 1
 * 
 *******************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class C12E1 extends JFrame {
  private JButton jbt1, jbt2, jbt3, jbt4, jbt5, jbt6;

  public static void main(String[] args) {
    C12E1 frame = new C12E1();
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("C12E1");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  public C12E1() {
    // Create panel p1 add three buttons
    JPanel p1 = new JPanel();
    p1.setLayout(new FlowLayout());
    p1.add(jbt1 = new JButton("Button 1"));
    p1.add(jbt2 = new JButton("Button 2"));
    p1.add(jbt3 = new JButton("Button 3"));

    // Create Panel p2 and add three buttons
    JPanel p2 = new JPanel();
    p2.setLayout(new FlowLayout());
    p2.add(jbt4 = new JButton("Button 4"));
    p2.add(jbt5 = new JButton("Button 5"));
    p2.add(jbt6 = new JButton("Button 6"));

    // Place p1 and p2 in the frame
    setLayout(new FlowLayout());
    add(p1);
    add(p2);
  }
}
