/*******************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 10th Edition, Chapter 6, Exercise 18
 * 
 *******************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class C6E18PasswordChecking extends JPanel implements ActionListener {
	private static String OK = "ok";
	private JFrame controllingFrame; 
	private JPasswordField passwordField;

	public C6E18PasswordChecking(JFrame f) {
		controllingFrame = f;

		passwordField = new JPasswordField(10);
		passwordField.setActionCommand(OK);
		passwordField.addActionListener(this);

		JLabel label = new JLabel("Enter the password: ");
		label.setLabelFor(passwordField);

		JComponent buttonPane = createButtonPanel();

		// Lay out everything.
		JPanel textPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		textPane.add(label);
		textPane.add(passwordField);

		add(textPane);
		add(buttonPane);
		
		JOptionPane.showMessageDialog(controllingFrame,
                "The password you entered must satisfy three conditions :\n"
              + "(1). must have at least eight characters.\n"
              + "(2). consists of only letters and digits.\n"
              + "(3). must contain at least two digits.");
	}

	protected JComponent createButtonPanel() {
		JPanel p = new JPanel(new GridLayout(0, 1));
		JButton okButton = new JButton("OK");
		okButton.setActionCommand(OK);
		okButton.addActionListener(this);
		p.add(okButton);
		return p;
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		// Process the password.
		if (OK.equals(cmd)) { 
			char[] input = passwordField.getPassword();
			if (isPasswordCorrect(input)) {
				JOptionPane.showMessageDialog(controllingFrame,
						"Success! You typed the eligible password.");
			} else {
				JOptionPane
						.showMessageDialog(
								controllingFrame,
								"Invalid password, please try again. Your password must satisfy three conditions :\n"
										+ "(1). must have at least eight characters.\n"
										+ "(2). consists of only letters and digits.\n"
										+ "(3). must contain at least two digits.",
								"Error Message", JOptionPane.ERROR_MESSAGE);
			}

			// Zero out the possible password, for security.
			Arrays.fill(input, '0');

			passwordField.selectAll();
			resetFocus();
		}
	}

	private static boolean isPasswordCorrect(char[] input) {
		boolean isCorrect = true;

		if (input.length < 8) {
			isCorrect = false;
		} else {
			char c;
			int count = 0;
			for (int i = 0; i < input.length - 1; i++) {
				c = input[i];
				if (!Character.isLetterOrDigit(c)) {
					isCorrect = false;
				} else if (Character.isDigit(c)) {
					count++;
				}
			}
			if (count < 2) {
				isCorrect = false;
			}
		}

		return isCorrect;
	}

	// Must be called from the event dispatch thread.
	protected void resetFocus() {
		passwordField.requestFocusInWindow();
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("C6E18PasswordChecking");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		final C6E18PasswordChecking newContentPane = new C6E18PasswordChecking(frame);
		
		// content panes must be opaque
		newContentPane.setOpaque(true); 
		frame.setContentPane(newContentPane);

		frame.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				newContentPane.resetFocus();
			}
		});

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}
}
