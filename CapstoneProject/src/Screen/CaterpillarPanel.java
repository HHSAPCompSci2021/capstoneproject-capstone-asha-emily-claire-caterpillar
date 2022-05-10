package Screen;

import java.util.List;

import Obstacle.Obstacle;
import core.DrawingSurface;

/**
 * The screen during the caterpillar phase
 * @author Emily
 *
 */
public class CaterpillarPanel extends Screen{
	private DrawingSurface surface;
	private List<Obstacle> obstacles;
	
	/**
	 * Constructs a CaterpillarPanel
	 * @param surface
	 */
	public CaterpillarPanel(DrawingSurface surface)
	{
		super(800,600);
		this.surface = surface;
		
	}
	/**
	 * Adds a predator to a randomize location to the screen
	 */
	public void addRandompredator() {
		
	}
	/**
	 * Clears the screen and restarts the phase
	 */
	public void resetScreen() {
		
	}
	/**
	 * Transitions to the next panel
	 */
	public void nextScreen() {
		surface.switchScreen(2);
	}
	/**
	 * Checks if a restart is needed (if the player lost this phase)
	 */
	public void needReset() {
		
	}
	/**
	 * Draws the screen
	 */
	public void draw() {
		
	}
	/**
	 * Implements the side scrolling effect, by adding features to the screen
	 */
	public void sideScrolling() {
		
	}
}
