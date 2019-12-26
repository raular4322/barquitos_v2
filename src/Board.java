public class Board {
	private Cell[][] board;
	private int size;
	
	public Board(int size) {
		this.board = new Cell[size][size];
		this.size = size;
		populate();
	}
	
	public int getSize() {
		return this.size;
	}
	
	public Cell getPosition(int x, int y) {
		return this.board[x][y];
	}
	
	private void populate() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.board[i][j] = new Cell();
			}
		}
	}
	
	public String toString() {
		String result = "";
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				result += " " + this.board[i][j].toString();
			}
			result += "\n";
		}
		return result;
	}
}
