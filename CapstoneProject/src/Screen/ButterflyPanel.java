package Screen;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Obstacle.Obstacle;
import Player.Butterfly;
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
		Butterfly b = new Butterfly();
		
		surface.background(255,255,255);
		surface.fill(0);
		surface.text("butterfly", 100, 100);
		
	
//			if (surface.isPressed(KeyEvent.VK_LEFT) && 100 + b.getX() >= 0)
//				b.moveByAmount(-10, 0);
//			if (surface.isPressed(KeyEvent.VK_RIGHT) &&  100 + b.getX() < 750)
//				b.moveByAmount(10, 0);
			if (surface.isPressed(KeyEvent.VK_UP) && 600/2 - 64 + b.getY() >= 80)
				b.moveByAmount(0, -10);
			if (surface.isPressed(KeyEvent.VK_DOWN) && 600/2 - 64 + b.getY() < 470)
				b.moveByAmount(0, 10);
		
		
		surface.image(surface.loadImage(b.imageName()), (float)(100 + b.getX()), (float)(600/2 - 64 + b.getY()), 64, 64);
		System.out.println(b.getX() + " " + b.getY());

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
