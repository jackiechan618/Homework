import java.util.*;

/************************************************************************************************
 * Code for Problem2 (Suduku), HW1
 * Auther:  Feng Chen
 * CWID:    10400586
 * Email:   fchen6@stevens.edu
 * 
 * Classes: this project contains 3 classes, the class Problem2_Sudoku_Main which is the main class, 
 * 			class ConstraintCondition which used to keep the constraint conditions,
 * 			class Variable which used to keep the variable. 
 * Input:   null
 * Output:  each statuses from start status to target status.
 * 
 *************************************************************************************************/

public class Problem2_Sudoku_Main {
	private List<ConstraintCondition> constraintConditionList = new ArrayList<>();
	private List<Variable> variableList = new ArrayList<>();
	private int[][] board;

	// Initial the variables	
	public void initial(int[][] board) {
		int rowIndex = 0, colIndex = 0;
		this.board = board;
		
		for (int i = 0; i < board.length; i++) {
			constraintConditionList.add(new ConstraintCondition());
		}
		
		for (int i = 0; i < board[0].length; i++) {
			constraintConditionList.add(new ConstraintCondition());
		}
		
		while (rowIndex < board.length) {
			colIndex = 0;
			
			while (colIndex < board[0].length) {
				constraintConditionList.add(new ConstraintCondition());
				colIndex += 3;
			}
			
			rowIndex += 3;
		}
		
		
		int value = 0;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					value = 511;
				} else {
					value = (int) Math.pow(2, board[i][j] - 1);
				}
				
				Variable tempValue = new Variable(constraintConditionList.get(18 + ((i / 3) * 3 + j / 3)), constraintConditionList.get(i), constraintConditionList.get(9 + j), value, i, j);
				variableList.add(tempValue);
				constraintConditionList.get(18 + ((i / 3) * 3 + j / 3)).initial(tempValue);
				constraintConditionList.get(i).initial(tempValue);
				constraintConditionList.get(9 + j).initial(tempValue);
			}
		}		
	}
	
	// Check whether the result is finished
	public boolean isValid(List<Variable> variableList) {
		boolean resultFlag = true;
		
		for (Variable v : variableList) {
			resultFlag &= v.finishFlag;
		}
		
		return resultFlag;
	}

	
	// Print the board	
	public void printSuduku(List<Variable> variableList, int[][] board) {
		for (Variable v : variableList) {
			board[v.x][v.y] = (int) (Math.log(v.value) / Math.log(2)) + 1;
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	// Main function
	public static void main(String[] args) {
		int[][] board = { 
				{0, 0, 3, 0, 2, 0, 6, 0, 0},
				{9, 0, 0, 3, 0, 5, 0, 0, 1}, 
				{0, 0, 1, 8, 0, 6, 4, 0, 0},
				{0, 0, 8, 1, 0, 2, 9, 0, 0}, 
				{7, 0, 0, 0, 0, 0, 0, 0, 8},
				{0, 0, 6, 7, 0, 8, 2, 0, 0}, 
				{0, 0, 2, 6, 0, 9, 5, 0, 0},
				{8, 0, 0, 2, 0, 3, 0, 0, 9}, 
				{0, 0, 5, 0, 1, 0, 3, 0, 0} 
		};

		Problem2_Sudoku_Main suduku = new Problem2_Sudoku_Main();
		suduku.initial(board);
		System.out.println("Constraint number is: " + suduku.constraintConditionList.size());
		System.out.println("Variable number is: " + suduku.variableList.size());
		
		while (!suduku.isValid(suduku.variableList)) {
			System.out.println("board status:");
			suduku.printSuduku(suduku.variableList, board);
			System.out.println(" ");
			
			for (Variable v : suduku.variableList) {
				v.variableToMesssage();
			}
			
			for (int i = 0; i < suduku.constraintConditionList.size(); i++) {
				suduku.constraintConditionList.get(i).messageToVariable(i);
			}
		}
	}
}
