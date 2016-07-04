/****************************************************************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 9th Edition, Chapter 7, Exercise 24 (Sudoku Solutions)
 * 
 * Instruction: 
 * (1). Firstly, Click 'start' button, select level of difficulty or open txt file
 * 		to load the puzzle."
 * (2). when the puzzle begins,click the left mouse button in a blank zone to choose
 * 		a number you want,then click the right mouse button in the same blank zone to
 * 	 	fill the number."
 * (3). If you have filled all the blank zones you can click 'check' button to check
 *  	whether you solution is correct.
 * (4). If you cannot get a right answer, you can click 'solution1' button to see how
 * 	 	many solutions the puzzle has and the solution sample 1.
 * (5). If you want to see another solution,you also can click 'solution2' button to 
 * 		see solution sample 2 if it exists.
 * (6). Finally,if the interface crashed,please close the interface and execute 
 * 		program again.
 * (7). If you have any question, please click on the "help" button on the board.
 * 
 * (8). File “Sudoku_test.txt” contains a test case of getting input from .txt files
 * 
 *****************************************************************************************/

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class C7E24SudokuSolutions {
	Generator gen = new Generator();
	static Grid g[] = new Grid[81];
	final String help = "Project of HW8"
			+ '\n'
			+ "Name: Feng Chen"
			+ '\n'
			+ "CWID: 10400586"
			+ '\n'
			+ "Instruction:"
			+ '\n'
			+ "(1). Firstly, Click 'start' button, select level of difficulty or open txt file to load the puzzle."
			+ '\n'
			+ "(2). when the puzzle begins,click the left mouse button in a blank zone to choose a number you want,then click the right mouse button in the same blank zone to fill the number."
			+ '\n'
			+ "(3). If you have filled all the blank zones you can click 'check' button to check whether you solution is correct."
			+ '\n'
			+ "(4). If you cannot get a right answer, you can click 'solution1' button to see how many solutions the puzzle has and the solution sample 1."
			+ '\n'
			+ "(5). If you want to see another solution,you also can click 'solution2' button to see solution sample 2 if it exists."
			+ '\n'
			+ "(6). Finally,if the interface crashed, please close the interface and execute program again.";
	
	JMenuBar jmb = new JMenuBar();
	JMenu start = new JMenu("Start");
	JMenuItem check = new JMenuItem("Check");
	JMenuItem level1 = new JMenuItem("Hard Level");
	JMenuItem level2 = new JMenuItem("Normal Level");
	JMenuItem level3 = new JMenuItem("Easy Level");
	JMenuItem level4 = new JMenuItem("Get a puzzle from txt file");
	JMenuItem mhelp = new JMenuItem("Help");
	JMenuItem GS = new JMenuItem("solution1");
	JMenuItem NS = new JMenuItem("Solution2");
	int solutionNum = 0;

	static int solution1[][] = new int[9][9];
	static int solution2[][] = new int[9][9];

	static void GetSolution(int[][] solution) {
		solution1 = solution;
	}

	int temp[][] = new int[9][9];

	JFrame frame = new JFrame("Sudoku");

	class Grid {
		int x;
		int y;
		PopMenu pm;
		JLabel cb;
		final String chooser[] = { "   ", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		int index;
		int editable;

		class PopMenu {
			JPopupMenu pop;
			JRadioButtonMenuItem radio[];
			ButtonGroup bg;

			PopMenu(int a) {
				pop = new JPopupMenu();
				RadioListener rl = new RadioListener();
				bg = new ButtonGroup();
				radio = new JRadioButtonMenuItem[10];
				radio[0] = new JRadioButtonMenuItem(" ");
				radio[0].addActionListener(rl);
				radio[0].setMnemonic(KeyEvent.VK_0);
				radio[0].setEnabled(true);
				bg.add(radio[0]);
				pop.add(radio[0]);
				for (int i = 1; i < 10; i++) {
					radio[i] = new JRadioButtonMenuItem(
							new Integer(i).toString());
					radio[i].addActionListener(rl);
					radio[i].setMnemonic(KeyEvent.VK_0 + i);
					bg.add(radio[i]);
					pop.add(radio[i]);
				}
				radio[a].setSelected(true);
			}

		}

		class RadioListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 10; i++) {
					if (pm.radio[i].isSelected()) {
						index = i;
						break;
					}			
				}
			}
		}

		class MyListener extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				if (editable == 1) {
					if (e.getButton() == MouseEvent.BUTTON1) {
						pm.pop.setLocation(e.getXOnScreen(), e.getYOnScreen());
						pm.pop.setVisible(true);
						pm.pop.setEnabled(true);
					} else if (e.getButton() == MouseEvent.BUTTON3) {
						pm.pop.setVisible(false);
						cb.setText(chooser[index]);
						gen.ini[x][y] = index;
					}
				}
			}
		}

		Grid(int a) {
			editable = 1;
			index = a;
			cb = new JLabel(chooser[a]);
			pm = new PopMenu(index);
			MyListener l = new MyListener();
			cb.addMouseListener(l);
			cb.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(Color.black),
					BorderFactory.createEmptyBorder(10, 10, 10, 10)));
			cb.setBounds(1, 1, 1, 1);
		}

		void set(int a) {
			index = a;
			cb.setText(chooser[a]);
		}

		int get() {
			return index;
		}

		void seteditable(int a) {
			editable = a;
			if (a == 0)
				cb.setForeground(Color.red);
			if (a == 1)
				cb.setForeground(Color.black);
		}
	}

	class CheckListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (gen.check()) {
				JOptionPane.showMessageDialog(frame,
						"Congratulation, you get a Correct Solution", "check",
						JOptionPane.OK_OPTION);
			} else {
				JOptionPane.showMessageDialog(frame,
						"Wrong result, please check your answer ", "check",
						JOptionPane.OK_OPTION);
			}
		}
	}

	class LevelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == level1) {
				go(3);
			} else if (e.getSource() == level2) {
				go(4);
			} else if (e.getSource() == level3) {
				go(5);
			} else if (e.getSource() == level4) {
				go(1);
			}
		}
	}

	class HelpListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, help, "Help",
					JOptionPane.OK_OPTION);
		}
	}

	class GSListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int count = search(gen.ini, 0);
			JOptionPane.showMessageDialog(frame,
					" The puzzle has  " + count + "  solutions.",
					"Number of sulutions", JOptionPane.OK_OPTION);
			search(gen.ini, 1);
		}
	}

	class NSListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (search(gen.ini, 0) == 1 || search(gen.ini, 0) == 0) {
				JOptionPane.showMessageDialog(frame, " No more solutions ",
						"Second of sulutions", JOptionPane.OK_OPTION);
			}
			if (search(gen.ini, 0) > 1) {
				search(gen.ini, 2);
			}
		}
	}

	C7E24SudokuSolutions() {
		init();
	}

	void init() {
		frame.setJMenuBar(jmb);
		jmb.add(start);
		jmb.add(check);

		jmb.add(GS);
		jmb.add(NS);
		jmb.add(mhelp);
		HelpListener hl = new HelpListener();
		mhelp.addActionListener(hl);
		CheckListener checkl = new CheckListener();
		check.addActionListener(checkl);
		GSListener GS1 = new GSListener();
		GS.addActionListener(GS1);
		NSListener NS1 = new NSListener();
		NS.addActionListener(NS1);
		start.add(level1);
		start.add(level2);
		start.add(level3);
		start.add(level4);
		LevelListener nl = new LevelListener();
		level1.addActionListener(nl);
		level2.addActionListener(nl);
		level3.addActionListener(nl);
		level4.addActionListener(nl);
		JPanel base = new JPanel(new GridLayout(3, 3));
		frame.getContentPane().add(base, BorderLayout.CENTER);
		for (int i = 0; i < 9; i++) {
			JPanel p = new JPanel(new GridLayout(3, 3));
			for (int k = 0; k < 3; k++) {
				g[(i % 3) * 3 + k + 27 * (i / 3)] = new Grid(0);
				p.add(g[(i % 3) * 3 + k + 27 * (i / 3)].cb);
			}
			for (int k = 9; k < 12; k++) {
				g[(i % 3) * 3 + k + 27 * (i / 3)] = new Grid(0);
				p.add(g[(i % 3) * 3 + k + 27 * (i / 3)].cb);
			}
			for (int k = 18; k < 21; k++) {
				g[(i % 3) * 3 + k + 27 * (i / 3)] = new Grid(0);
				p.add(g[(i % 3) * 3 + k + 27 * (i / 3)].cb);
			}
			p.setBorder(BorderFactory.createLineBorder(Color.red));
			base.add(p);
		}
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				g[i * 9 + j].x = i;
				g[i * 9 + j].y = j;
			}
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	void goSulution(int[][] sulutions) {
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				if (sulutions[i][j] == 0) {
					g[i * 9 + j].cb.setText("  ");
					g[i * 9 + j].seteditable(1);
					g[i * 9 + j].pm.radio[0].setSelected(true);
				} else {
					g[i * 9 + j].cb.setText(g[0].chooser[sulutions[i][j]]);
					g[i * 9 + j].seteditable(0);
				}
	}

	void go(int level) {
		if (level == 3 || level == 4 || level == 5) {
			gen.go(level);
		} else if (level == 1) {
			try {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					java.io.File file = fileChooser.getSelectedFile();

					Scanner input = new Scanner(file);

					while (input.hasNext()) {
						for (int i = 0; i < 9; i++)
							for (int j = 0; j < 9; j++)
								gen.ini[i][j] = input.nextInt();
					}
					input.close();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				if (gen.ini[i][j] == 0) {
					g[i * 9 + j].cb.setText("  ");
					g[i * 9 + j].seteditable(1);
					g[i * 9 + j].pm.radio[0].setSelected(true);
				} else {
					g[i * 9 + j].cb.setText(g[0].chooser[gen.ini[i][j]]);
					g[i * 9 + j].seteditable(0);
				}
	}

	/** Obtain a list of free cells from the puzzle */
	public static int[][] getFreeCellList(int[][] grid) {
		int[][] tempList = new int[81][2];
		int numberOfFreeCells = 0;

		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				if (grid[i][j] == 0) {
					tempList[numberOfFreeCells][0] = i;
					tempList[numberOfFreeCells][1] = j;
					numberOfFreeCells++;
				}

		int[][] freeCellList = new int[numberOfFreeCells][2];
		for (int i = 0; i < numberOfFreeCells; i++) {
			freeCellList[i][0] = tempList[i][0];
			freeCellList[i][1] = tempList[i][1];
		}

		return freeCellList;
	}

	/**
	 * Search for up to 2 solutions. This method returns the number of solutions
	 * found. Possible return values are 0, 1, 2, and 3.
	 */
	public static int search(int[][] grid, int index) {
		int[][] freeCellList = getFreeCellList(grid); 		
		int k = 0; 
		int count = 0; 
		boolean done = false;		

		while (!done) {
			int i = freeCellList[k][0];
			int j = freeCellList[k][1];
			if (grid[i][j] == 0)
				grid[i][j] = 1; 

			if (isValid(i, j, grid)) {
				if (k + 1 == freeCellList.length) { 
					count++;
					if (count == 1) { 
						solution1 = grid;
						
						if (index == 1) {
							index = 1;
							int tempInt = 0;
							String tempString;
							String solutionString = "";
							
							for (int i1 = 0; i1 < 9; i1++) {
								for (int j1 = 0; j1 < 9; j1++) {
									tempInt = solution1[i1][j1];
									tempString = tempInt + " ";
									solutionString = solutionString + tempString;
									if (j1 == 8) {
										solutionString = solutionString + " \n";
									}
								}
							}
														
							String str1 = "If you want to try it again, please press start button on the main board and then choose the level, thanks";
							JOptionPane.showMessageDialog(null, "Sample solution 1: " + " \n" + solutionString + " \n" + str1);
						}
					}
					if (count == 2) { 
						solution2 = grid;
						
						if (index == 2) {
							int tempInt = 0;
							String tempString;
							String solutionString = "";
							
							for (int i1 = 0; i1 < 9; i1++) {
								for (int j1 = 0; j1 < 9; j1++) {
									tempInt = solution1[i1][j1];
									tempString = tempInt + " ";
									solutionString = solutionString
											+ tempString;
									if (j1 == 8) {
										solutionString = solutionString + " \n";
									}
								}

							}
							
							String str2 = "If you want to try it again, please press start button on the main board and then choose the level, thanks";
							JOptionPane.showMessageDialog(null, "Sample solution 2: " + " \n" + solutionString + " \n" + str2);
						}
					}
					
					if (grid[i][j] < 9) {
						grid[i][j] = grid[i][j] + 1; 														
					} else { 
						while (grid[i][j] == 9) {
							grid[i][j] = 0; 
							if (k == 0) {
								done = true;
								return count;
							}
							k--; 
							i = freeCellList[k][0];
							j = freeCellList[k][1];
						}

						grid[i][j] = grid[i][j] + 1; 
					}
				
				} else {
					k++;
				}
			} else if (grid[i][j] < 9) {
				grid[i][j] = grid[i][j] + 1; 
			} else { 
				while (grid[i][j] == 9) {
					grid[i][j] = 0; 
					if (k == 0) {
						done = true;
						return count;
					}
					k--; 
					i = freeCellList[k][0];
					j = freeCellList[k][1];
				}

				grid[i][j] = grid[i][j] + 1;
			}
		}
		
		return count; 
	}
	
	/** Check whether grid[i][j] is valid in the grid */
	public static boolean isValid(int i, int j, int[][] grid) {
		for (int column = 0; column < 9; column++) {
			if (column != j && grid[i][column] == grid[i][j]) {
				return false;
			}
		}

		for (int row = 0; row < 9; row++) {
			if (row != i && grid[row][j] == grid[i][j]) {
				return false;
			}
		}

		for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
			for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
				if (row != i && col != j && grid[row][col] == grid[i][j]) {
					return false;
				}
			}
		}

		return true; 
	}

	/** Check whether the fixed cells are valid in the grid */
	public static boolean isValid(int[][] grid) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid[i][j] < 0 || grid[i][j] > 9 || (grid[i][j] != 0 && !isValid(i, j, grid))) {
					return false;
				}
			}
		}
		return true; 
	}

	public static void main(String args[]) {
		C7E24SudokuSolutions sudoku0 = new C7E24SudokuSolutions();
		String tipStr = "Please press Start button on the main board and then choose the level to start Sudoku, thanks";
		JOptionPane.showMessageDialog(null, tipStr);
	}
}



class Generator {
	static int ini[][] = new int[9][9];
	static int ok[][] = new int[9][9];
	static int numMask[][][] = new int[10][9][9]; 
	static int numIni = 0;
	static int count = 0;
	static int level = 3;
	static Random r = new Random();

	void go(int level) {
		numIni = 0;
		count = 0;
		this.level = level;
		String a[] = { "000000000", "000000000", "000000000", "000000000",
				"000000000", "000000000", "000000000", "000000000",
				"000000000", };
		init(a);

		fill(0);
		c2(ini, ok);
		filtering(9 - level);

	}

	void setIni(int[][] solution) {
		ini = solution;
	}

	static boolean check() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (ok[i][j] != ini[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	static void filtering(int a) {
		int base = 1;
		for (int m = 0; m < 3; m++)
			for (int n = 0; n < 3; n++) {
				base = 1;
				int x, y;
				while (base <= a) {
					x = r.nextInt();
					y = r.nextInt();
					x = x > 0 ? x : -x;
					y = y > 0 ? y : -y;
					x = x % 3;
					y = y % 3;
					if (ini[x + 3 * m][y + 3 * n] != 0) {
						ini[x + 3 * m][y + 3 * n] = 0;
						base++;
					}
				}
			}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < 9; k++) {
					numMask[i][j][k] = 0;
				}
			}
		}
		
		numIni = 0;
		
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				if (ini[i][j] != 0) {
					numIni++;
					for (int m = 0; m < 9; m++) {
						numMask[ini[i][j]][i][m] = numMask[ini[i][j]][m][j] = 1;
					}
					for (int m = 0; m < 3; m++) {
						for (int n = 0; n < 3; n++) {
							numMask[ini[i][j]][i / 3 * 3 + m][j / 3 * 3 + n] = 1;
						}
					}
				}
	}

	static void fill(int whole) {
		if (numIni == 81) {
			count++;
			return;
		}
		int i = whole / 9;
		int j = whole % 9;
		if (ini[i][j] == 0) {
			int houxuan[] = new int[10];
			int l = 0;
			for (int num = 1; num < 10; num++)
				if (numMask[num][i][j] == 0) {
					houxuan[l] = num;
					l++;
				}

			int ll = l - 1;
			
			while (ll >= 1) {
				int biao = r.nextInt();
				biao = biao > 0 ? biao : -biao;
				biao = biao % ll;
				int c = houxuan[biao];
				houxuan[biao] = houxuan[ll];
				houxuan[ll] = c;
				ll--;
			}
			
			for (int k = 0; k < l; k++) {
				int num = houxuan[k];
				int iini[][] = new int[9][9];
				int inumMask[][][] = new int[10][9][9];
				int inumIni = numIni;
				c2(ini, iini);
				c3(numMask, inumMask);
				ini[i][j] = num;
				numIni++;
				updata(num, i, j);
				fill((whole + 1) % 81);
				
				if (count == 1) {
					return;
				}
				
				c2(iini, ini);
				c3(inumMask, numMask);
				numIni = inumIni;
			}
		} else
			fill((whole + 1) % 81);
	}

	static void init(String a[]) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < 9; k++) {
					numMask[i][j][k] = 0;
				}
			}
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				ini[i][j] = (int) (a[i].charAt(j) - '0');
				if (ini[i][j] != 0) {
					numIni++;
					for (int m = 0; m < 9; m++) {
						numMask[ini[i][j]][i][m] = numMask[ini[i][j]][m][j] = 1;
					}
					for (int m = 0; m < 3; m++) {
						for (int n = 0; n < 3; n++) {
							numMask[ini[i][j]][i / 3 * 3 + m][j / 3 * 3 + n] = 1;
						}
					}
				}
			}
		}
	}

	static void updata(int num, int i, int j) 
	{
		for (int k = 0; k < 9; k++) {
			if (numMask[num][i][k] == 0) {
				numMask[num][i][k] = 1;
			}
			if (numMask[num][k][j] == 0) {
				numMask[num][k][j] = 1;
			}
		}
		for (int m = 0; m < 3; m++) {
			for (int n = 0; n < 3; n++) {
				if (numMask[num][i / 3 * 3 + m][j / 3 * 3 + n] == 0) {
					numMask[num][i / 3 * 3 + m][j / 3 * 3 + n] = 1;
				}
			}
		}
	}

	static void c2(int a[][], int b[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				b[i][j] = a[i][j];
			}
		}
	}

	static void c3(int a[][][], int b[][][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				for (int k = 0; k < a[0][0].length; k++) {
					b[i][j][k] = a[i][j][k];
				}
			}
		}
	}
}