public class Board {
	private Boat[][] board;
	private int size;
	
	public Board(int size) {
		this.board = new Boat[size][size];
		this.size = size;
	}
	
	public Boat[][] getBoard() {
		return this.board;
	}
	
	public void setBoard(Boat[][] board) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.board[i][j] = board[i][j];
			}
		}
	}
	
	public int getSize() {
		return this.size;
	}
}
