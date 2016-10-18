public class IDDFS_Vehicle {
	char id;
	int col;
	int row;
	int length;
	String tag;

	IDDFS_Vehicle(char id, int row, int col, int length, String tag) {
		this.id = id;
		this.col = col;
		this.row = row;
		this.length = length;
		this.tag = tag;
	}

	public boolean canMoveFoward(char[][] board) {
		if (tag.equals("H")) {
			if (col + length >= board[0].length || board[row][col + length] != '0')
				return false;
		} else {
			if (row - 1 < 0 || board[row - 1][col] != '0')
				return false;
		}
		return true;
	}

	public boolean canMoveBackward(char[][] board) {
		if (tag.equals("H")) {
			if (col - 1 < 0 || board[row][col - 1] != '0') {
				return false;
			}
		} else {
			if (row + length >= board.length || board[row + length][col] != '0') {
				return false;
			}
		}
		return true;
	}

	public void move(String direction) {
		if (tag.equals("H")) {
			if (direction.equals("+")) {
				col++;
			} else {
				col--;
			}
		} else {
			if (direction.equals("+")) {
				row--;
			} else {
				row++;
			}
		}
	}
}
