import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Controller extends Frame {
	private Board board;
	private View view;
	private MouseController mouseController;
	private PropertyChangeSupport support;
	
	public Controller(int boardSize, int[] boatsNumber) {
		this.board = new Board(boardSize);
		
		this.mouseController = new MouseController(this);
		
		this.view = new View(board);
		view.addMouseListener(mouseController);
		
		this.support = new PropertyChangeSupport(this);
		this.support.addPropertyChangeListener(view);
		
		this.add(this.view);
		this.setSize(board.getSize() * 40 + 15, board.getSize() * 40 + 38);
		this.setVisible(true);
		
		placeBoats(boatsNumber);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}
	
	public void placeBoats(int[] boatsNumber) {
		int trys = 0;
		
		for (int i = 0; i < boatsNumber.length; i++) {
			for (int j = 0; j < boatsNumber[i]; ) {
				Boat boat = new Boat(i);
				
				if (placeBoat(boat)) {
					System.out.println(this.board.toString());
					System.out.println("-------------------------");
					j++;
				}
				
				trys += 1;
				if (trys > 100) {
					j++;
				}
			}
		}
	}
	
	public Boolean placeBoat(Boat boat) {
		boolean result = false;
		
		Random rX = new Random();
		Random rY = new Random();
		Random rOrientation = new Random();
		
		int x = rX.nextInt(this.board.getSize());
		int y = rY.nextInt(this.board.getSize());
		int orientation = rOrientation.nextInt(2);
		
		if (orientation == 0 && inBounds(x, boat.getSize()) && freeHorizontal(x, y, boat.getSize())) {
			for (int i = x - boat.getSize(); i <= x; i++) {
				this.board.getPosition(i, y).setBoat(boat);
				result = true;
			}
		}
		
		if (orientation == 1 && inBounds(y, boat.getSize()) && freeVertical(x, y, boat.getSize())) {
			for (int i = y - boat.getSize(); i <= y; i++) {
				this.board.getPosition(x, i).setBoat(boat);
				result = true;
			}
		}
		
		return result;
	}
	
	public Boolean inBounds(int coord, int size) {
		return coord - size >= 0;
	}
	
	public Boolean freeVertical(int x, int y, int size) {
		boolean result = true;
		
		for (int i = y - size; i <= y; i++) {
			if (this.board.getPosition(x, i).getBoat() != null) {
				result = false;
			}
		}
		
		return result;
	}
	
	public Boolean freeHorizontal(int x, int y, int size) {
		boolean result = true;
		
		for (int i = x - size; i <= x; i++) {
			if (this.board.getPosition(i, y).getBoat() != null) {
				result = false;
			}
		}
		
		return result;
	}
	
	public void shoot(int x, int y) {
		Cell shotCell = board.getPosition(x, y);
		
		if (shotCell.getColor() == Colors.HIDDEN) {
			if (shotCell.getBoat() == null) shotCell.setColor(Colors.MISS);
			else {
				shotCell.getBoat().hit();
				shotCell.setColor(Colors.HIT);
			}
			
			checkSinkBoats();
			support.firePropertyChange("board", 0, board);
		}
	}
	
	public void checkSinkBoats() {
		boolean noBoatAlive = true;
		
		for (int i = 0; i < this.board.getSize(); i++) {
			for (int j = 0; j < this.board.getSize(); j++) {
				Boat boat = this.board.getPosition(i, j).getBoat();
				
				if (boat != null && boat.getLives() == 0) {
					this.board.getPosition(i, j).setColor(Colors.SINK);
				}
				if(boat != null && boat.getLives() > 0) {
					noBoatAlive = false;
				}
			}
		}
		
		if(noBoatAlive) {
			gameOver();
		}
	}
	
	public void gameOver() {
		for (int i = 0; i < this.board.getSize(); i++) {
			for (int j = 0; j < this.board.getSize(); j++) {
				shoot(i, j);
			}
		}
	}
}
