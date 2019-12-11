import java.awt.*;

public class Cell {
	private Boat boat;
	private Color color;
	
	public Cell() {
		this.color = Colors.HIDDEN;
	}
	
	public Boat getBoat() {
		return boat;
	}
	
	public void setBoat(Boat boat) {
		this.boat = boat;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public String toString() {
		String result = "";
		
		if (this.boat == null) {
			result = " ";
		} else {
			result = this.boat.toString();
		}
		
		return result;
	}
}
