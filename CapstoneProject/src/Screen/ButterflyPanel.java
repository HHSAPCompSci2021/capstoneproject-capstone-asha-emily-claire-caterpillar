package Screen;

import java.util.ArrayList;

import Obstacle.Obstacle;
import core.DrawingSurface;

public class ButterflyPanel extends Screen {
	
	private DrawingSurface surface;
	private ArrayList<Obstacle> obs;
	
	public ButterflyPanel(DrawingSurface s) {
		
		surface = s;
	}
	
	public void addRandomPredator() {
		
	}
	
	public void resetScreen() {
		
	}
	
	public boolean wonGame() {
		
		return false;
	}
	
	public void draw() {
		
	}
	
	public boolean needRestart() {
		
		return false;
	}
	
	public void sideScrolling() {
		
	}
	
}
