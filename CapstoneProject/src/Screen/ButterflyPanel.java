package Screen;

import java.util.ArrayList;

import Obstacle.Obstacle;
import core.DrawingSurface;
/**
 * The screen during the Butterfly phase
 * @author Claire
 *
 */
public class ButterflyPanel extends Screen {
	
	private DrawingSurface surface;
	private ArrayList<Obstacle> obs;
	
	/**
	 * Constructs a ButterflyPanel 
	 * @param s - a DrawingSurface to construct the panel on
	 */
	public ButterflyPanel(DrawingSurface s) {
		super(800,600);
		surface = s;
	}
	
	/**
	 * Adds a predator to a random location
	 */
	public void addRandomPredator() {
		
	}
	
	/**
	 * Clears the screen when the phase needs to restart
	 */
	public void resetScreen() {
		
	}
	/**
	 * Checks if this phase is won
	 * @return boolean - if the phase is won
	 */
	public boolean wonGame() {
		
		return false;
	}
	
	/**
	 * Draws the screen for the phase
	 */
	public void draw() {
		
	}
	
	/**
	 * Checks if a restart of the phase is need
	 * @return boolean - if a restart is needed
	 */
	public boolean needRestart() {
		
		return false;
	}
	
	/**
	 * Adds features to the screen in a side scrolling effect
	 */
	public void sideScrolling() {
		
	}
	
}
