public class Board {
	private Cell[][] board;
	private int size;
	
	public Board(int size) {
		this.board = new Cell[size][size];
		this.size = size;
		populate();
	}
	
	public Cell[][] getBoard() {
		return this.board;
	}
	
	public void setBoard(Cell[][] board) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.board[i][j] = board[i][j];
			}
		}
	}
	
	public int getSize() {
		return this.size;
	}
	
	public Cell getPosition(int x, int y) {
		return this.board[x][y];
	}
	
	public void setPosition(int x, int y, Cell cell) {
		this.board[x][y] = cell;
	}
	
	private void populate() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.board[i][j] = new Cell();
			}
		}
	}
	
	public String toString() {
		String result = "";
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board.length; j++) {
				result += " " + this.board[i][j];
			}
			result += "\n";
		}
		return result;
	}
}
