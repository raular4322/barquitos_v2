public class Boat {
	private int size;
	private int lives;
	
	public Boat(int size) {
		this.size = size;
		this.lives = size + 1;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getLives() {
		return this.lives;
	}
	
	public void hit() {
		if (this.lives > 0) {
			this.lives -= 1;
		}
	}
	
	public String toString() {
		return this.size + "";
	}
}
