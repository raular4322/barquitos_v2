public class Boat {
	private int value;
	private int size;
	private int status;
	
	public Boat(int value, int size) {
		this.value = value;
		this.size = size;
		this.status = 0;
	}
	
	public Boat(int value, int size, int status) {
		this.value = value;
		this.size = size;
		this.status = status;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
}
