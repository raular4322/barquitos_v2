import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseController extends MouseAdapter {
	private Controller controller;
	
	public MouseController(Controller controller) {
		this.controller = controller;
	}
	
	public void mousePressed(MouseEvent e) {
		this.controller.shoot(e.getY() / 40, e.getX() / 40);
	}
}
