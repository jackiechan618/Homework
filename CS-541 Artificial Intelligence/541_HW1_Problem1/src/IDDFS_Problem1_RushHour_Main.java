import java.util.*;

/******************************************************************************************************************
 * Code for Problem1 (Rush Hour), HW1, uising iterative-deepening depth-first search
 * Auther:  Feng Chen
 * CWID:    10400586
 * Email:   fchen6@stevens.edu
 * 
 * Classes: this project contains 2 classes, the class IDDFS_Problem1_RushHour_Main which is the main class, 
 * 			class IDDFS_Vehicle which used to keep the information of each vehicle.
 * Input:   null.
 * Output:  each statuses and the path from start status to target status.
 * 
 *******************************************************************************************************************/

public class IDDFS_Problem1_RushHour_Main {
	private List<char[][]> List = new ArrayList<>();
	private List<char[][]> tempList = new ArrayList<>();
	private boolean findFlag = false;

	// Initial function
	public void initial(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = '0';
			}
		}
	}
	
	
	public void bprint(List<IDDFS_Vehicle> vehicleList, char[][] board) {	
		for (IDDFS_Vehicle v : vehicleList) {
			if (v.tag.equals("H")) {
				for (int i = 0; i < v.length; i++) {
					board[v.row][v.col + i] = v.id;
				}
			} else {
				for (int i = 0; i < v.length; i++) {
					board[v.row + i][v.col] = v.id;
				}
			}
		}
	}
	
	
	public void resolveByIDDFS(List<IDDFS_Vehicle> vehicleList, int depth) {
		char[][] board = new char[6][6];

		if (depth > 0) {
			initial(board);
			bprint(vehicleList, board);

			if (board[2][5] == 'X') {
				findFlag = true;
				tempList.add(board);

				if (List.size() == 0) {
					List.addAll(tempList);
				}
			} else {
				for (int i = 0; i < vehicleList.size(); i++) {
					if (vehicleList.get(i).canMoveFoward(board)) {
						vehicleList.get(i).move("+");
						tempList.add(board);
						resolveByIDDFS(vehicleList, depth - 1);
						vehicleList.get(i).move("-");
						tempList.remove(tempList.size() - 1);
					}

					if (vehicleList.get(i).canMoveBackward(board)) {
						vehicleList.get(i).move("-");
						tempList.add(board);
						resolveByIDDFS(vehicleList, depth - 1);
						vehicleList.get(i).move("+");
						tempList.remove(tempList.size() - 1);
					}
				}
			}
		}
	}

	// Iterative-deepening depth-first search
	public void IDDFS(List<IDDFS_Vehicle> table) {
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			if (findFlag) {
				break;
			}
			
			resolveByIDDFS(table, i);
		}
		
		System.out.println("The Result is:");
		System.out.println();
		
		int index = 1;
		
		for (char[][] tmp : List) {
			System.out.println("Step" + String.valueOf(index));
			
			for (int i = 0; i < tmp.length; i++) {
				System.out.println(Arrays.toString(tmp[i]));
			}
			
			index++;
			System.out.println();
		}
	}



	
	// Main function
	public static void main(String[] args) {
		List<IDDFS_Vehicle> board = new ArrayList<>();
		board.add(new IDDFS_Vehicle('T', 0, 2, 2, "V"));
		board.add(new IDDFS_Vehicle('X', 2, 2, 2, "H"));
		board.add(new IDDFS_Vehicle('Z', 2, 4, 2, "V"));
		board.add(new IDDFS_Vehicle('I', 4, 4, 2, "V"));
		board.add(new IDDFS_Vehicle('O', 1, 3, 3, "H"));
		
		IDDFS_Problem1_RushHour_Main test = new IDDFS_Problem1_RushHour_Main();
		test.IDDFS(board);
	}
}
