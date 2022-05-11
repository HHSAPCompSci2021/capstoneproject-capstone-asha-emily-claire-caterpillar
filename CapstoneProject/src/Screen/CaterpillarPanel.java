package Screen;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import Obstacle.Collectible;
import Obstacle.Obstacle;
import Player.Caterpillar;
import core.DrawingSurface;

/**
 * The screen during the caterpillar phase
 * @author Emily
 *
 */
public class CaterpillarPanel extends Screen{
	private DrawingSurface surface;
	private List<Obstacle> obstacles;
	private List<Collectible> leaves; 
	private Caterpillar caterpillar; 
	

	/**
	 * Constructs a CaterpillarPanel
	 * @param surface
	 */
	public CaterpillarPanel(DrawingSurface surface)
	{
		super(800,600);
		this.surface = surface;
		obstacles = new ArrayList<Obstacle>();
		leaves = new ArrayList<Collectible>();
		addRandompredator();
		addRandomObstacles();
	}
	
	public void setup()
	{
		caterpillar = new Caterpillar(20, DRAWING_HEIGHT/2);
	}
	
	/**
	 * Adds obstacles to randomized locations to the screen
	 */
	private void addRandompredator() {
		for(int i = 0; i < 5; i++)
		{
			obstacles.add(new Obstacle((int)(Math.random()*(10))+DRAWING_WIDTH, 50));
		}
	}
	
	/**
	 * Adds collectibles to  randomized locations to the screen
	 */
	private void addRandomObstacles() {
		for(int i = 0; i < 5; i++)
		{
			obstacles.add(new Obstacle((int)(Math.random()*(10))+DRAWING_WIDTH, 50));
		}
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
//	public boolean needReset() {
//		
//	}
	
	/**
	 * Draws the screen
	 */
	public void draw() {
		surface.background(255,255,255);
		
//		for(Obstacle o : obstacles)
//		{
//			o.draw();
//		}
//		sideScrolling();
		
		caterpillar.draw(surface);
		
		
		if (surface.isPressed(KeyEvent.VK_UP))
		{
			caterpillar.jump();
		}
		if(surface.isPressed(KeyEvent.VK_DOWN)) {
			caterpillar.dive();
		}
		
		caterpillar.act(obstacles, DRAWING_HEIGHT/2);
		
		if(caterpillar.getNumCollectible() == 5)
		{
			nextScreen();
			return;
		}
		//need getter and setter for lots of fields
//		if(caterpillar.getTotalCollisions == 3)
//		{
//			resetScreen();
//		}
	}

	/**
	 * Implements the side scrolling effect, by adding features to the screen
	 */
//	public void sideScrolling() {
//		for(Obstacle o : obstacles)
//		{
//			o.moveByAmount(-5);
//			if(o.getX() < 0)
//			{
//				o.changeObstacleType();
//				o.setX((Math.random()*(10))+DRAWING_WIDTH) ;
//			}
//		}
//	}
}
