package Screen;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import Obstacle.Collectible;
import Obstacle.Element;
import Obstacle.Obstacle;
import Obstacle.Predator;
import Player.Caterpillar;
import asha.shapes.Rectangle;
import asha.shapes.Shape;
import core.DrawingSurface;

/**
 * The screen during the caterpillar phase
 * @author Emily
 *
 */
public class CaterpillarPanel extends Screen{
	private DrawingSurface surface;
	private List<Element> obstacles;
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
		obstacles = new ArrayList<Element>();
		leaves = new ArrayList<Collectible>();
		caterpillar = new Caterpillar(5, 20, DRAWING_HEIGHT/2, surface.getDesign());
		addRandompredator();
		addRandomCollectibles();
	}

	/**
	 * Adds obstacles to randomized locations to the screen
	 */
	private void addRandompredator() {
		obstacles.add(new Predator("img/Predator.gif", (int)(Math.random()*5)+DRAWING_WIDTH, 200, 5));
	}

	/**
	 * Adds collectibles to  randomized locations to the screen
	 */
	private void addRandomCollectibles() {
		for(int i = 0; i < 2; i++)
		{
			leaves.add(new Collectible("leaf", "img/Leaf.gif", 5, DRAWING_WIDTH+(i*100), DRAWING_HEIGHT/2));
		}
	}


	/**
	 * Draws the screen
	 */
	public void draw() {
		surface.background(255,255,255);

		for(Element o : obstacles)
		{
			o.draw(surface);
		}

		for(Collectible c : leaves)
		{
			c.draw(surface);
		}

		caterpillar.draw(surface);
		sideScrolling();

		//y of highest point 177.49999999999997
		if (surface.isPressed(KeyEvent.VK_UP))
		{
			caterpillar.jump();
		}
		
		//y of lowest point 422.5
		if(surface.isPressed(KeyEvent.VK_DOWN)) {
			caterpillar.dive();
		}

		System.out.println(caterpillar.getY());
		caterpillar.act(DRAWING_HEIGHT/2);
		for(Element o : obstacles)
		{
			o.move();
			if(o.collide(caterpillar.playerDesignRect()))
			{
				caterpillar.increaseCollisions(o);
				o.moveByAmount(o.getX()+DRAWING_WIDTH, 10);
			}
		}
		for(Collectible c : leaves) {
			c.move();
			if(c.collide(caterpillar.playerDesignRect())) {
				c.moveByAmount(c.getX()+DRAWING_WIDTH, 10);
				c.eat(caterpillar);
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
		for(Element o : obstacles)
		{
			if(o.getX() < -64)
			{
				o.moveByAmount(o.getX()+DRAWING_WIDTH, 0);
			}
		}
		for(Collectible c : leaves)
		{
			if(c.getX() < -64)
			{
				c.moveByAmount(c.getX()+DRAWING_WIDTH, 0);
			}
		}
	}


	/**
	 * Clears the screen and restarts the phase
	 */
	public void resetScreen() {
		surface.switchScreen(0);
	}
	/**
	 * Transitions to the next panel
	 */
	public void nextScreen() {
		surface.switchScreen(4);
	}
}
