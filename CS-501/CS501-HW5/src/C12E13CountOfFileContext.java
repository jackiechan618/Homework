/*******************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 10th Edition, Chapter 12, Exercise 13
 * 
 *******************************************/

import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public final class C12E13CountOfFileContext {
	public static void main(String[] args) {
		File selectedFile = null;
		Scanner fileScanner = null;
		int charsCount = 0;
		int wordsCount = 0;
		int linesCount = 0;
		try {
			JFileChooser chooser = new JFileChooser();
			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				selectedFile = chooser.getSelectedFile();
				fileScanner = new Scanner(selectedFile);
			}
			while (fileScanner != null && fileScanner.hasNextLine()) {
				linesCount++;
				String line = fileScanner.nextLine();
				Scanner lineScanner = new Scanner(line);
				while (lineScanner.hasNext()) {
					wordsCount++;
					String word = lineScanner.next();
					charsCount = charsCount + word.length();
				}
				lineScanner.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			JOptionPane.showMessageDialog(null, "Count of chars: " + charsCount
					+ " \n Count of words: " + wordsCount
					+ " \n Count of lines: " + linesCount);
		}

		if (fileScanner != null) {
			fileScanner.close();
		}
	}
}
