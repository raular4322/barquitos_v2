import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends Canvas implements PropertyChangeListener {
	private Board board;
	private Graphics2D g2d;
	
	public View(Board board) {
		this.board = board;
	}
	
	public void paint(Graphics g) {
		this.g2d = (Graphics2D) g;
		
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillRect(0, 0, board.getSize() * 50, board.getSize() * 50);
		
		for (int i = 0; i < board.getSize(); i++) {
			for (int j = 0; j < board.getSize(); j++) {
				g2d.setColor(board.getPosition(i, j).getColor());
				g2d.fillRect(j * 40, i * 40, 38, 38);
			}
		}
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		repaint();
	}
}
