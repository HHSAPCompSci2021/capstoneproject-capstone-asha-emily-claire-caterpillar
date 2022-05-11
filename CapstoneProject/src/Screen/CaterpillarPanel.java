package Screen;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import Obstacle.Collectible;
import Obstacle.Obstacle;
import Obstacle.Predator;
import Player.Caterpillar;
import core.DrawingSurface;

/**
 * The screen during the caterpillar phase
 * @author Emily
 *
 */
public class CaterpillarPanel extends Screen{
	private DrawingSurface surface;
	private List<Predator> obstacles;
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
		obstacles = new ArrayList<Predator>();
		leaves = new ArrayList<Collectible>();
		caterpillar = new Caterpillar(20, DRAWING_HEIGHT/2);
		addRandompredator();
		addRandomCollectibles();
	}
	
	/**
	 * Adds obstacles to randomized locations to the screen
	 */
	private void addRandompredator() {
		for(int i = 0; i < 5; i++)
		{
			obstacles.add(new Predator((int)(Math.random()*(10))+DRAWING_WIDTH, 50, 5));
		}
	}
	
	/**
	 * Adds collectibles to  randomized locations to the screen
	 */
	private void addRandomCollectibles() {
		for(int i = 0; i < 5; i++)
		{
			leaves.add(new Collectible("leaf"));
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
		
		for(Predator o : obstacles)
		{
			o.draw();
		}
		sideScrolling();
		
		caterpillar.draw(surface);
		
		
		if (surface.isPressed(KeyEvent.VK_UP))
		{
			caterpillar.jump();
		}
		if(surface.isPressed(KeyEvent.VK_DOWN)) {
			caterpillar.dive();
		}
		
		caterpillar.act(DRAWING_HEIGHT/2);
		for(Predator o : obstacles)
		{
			if(o.getBounds().intersects(new Rectangle((int)caterpillar.getX(),(int)caterpillar.getY(), 64, 64)))
			{
				caterpillar.increaseCollisions();
				o.setX((Math.random()*(10))+DRAWING_WIDTH);
			}
		}
		
		if(caterpillar.getNumCollectible() == caterpillar.getNumCollectiblesNeedToEat())
		{
			nextScreen();
			return;
		}
		if(caterpillar.getTotalCollisions() == 3)
		{
			resetScreen();
		}
	}

	/**
	 * Implements the side scrolling effect, by adding features to the screen
	 */
	public void sideScrolling() {
		for(Predator o : obstacles)
		{
			o.moveByAmount(o.getSpeed(), 0);
			if(o.getX() < 0)
			{
				o.setX((Math.random()*(10))+DRAWING_WIDTH) ;
			}
		}
		for(Collectible c : leaves)
		{
			
		}
	}
}
