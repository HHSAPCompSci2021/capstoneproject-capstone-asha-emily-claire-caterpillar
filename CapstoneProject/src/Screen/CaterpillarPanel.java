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
		System.out.println("HI");
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
		System.out.println("2");
		obstacles.add(new Obstacle("tree", (int)(Math.random()*5)+DRAWING_WIDTH, 50, 5));
	}

	/**
	 * Adds collectibles to  randomized locations to the screen
	 */
	private void addRandomCollectibles() {
		System.out.println("3");
		for(int i = 0; i < 5; i++)
		{
			leaves.add(new Collectible("leaf", "leaf", 5, DRAWING_WIDTH+(i*2), 20));
		}
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
		System.out.println("Why");
		surface.background(255,255,255);

		System.out.println("Work");
//		for(Element o : obstacles)
//		{
//			surface.image(surface.loadImage(o.getImage()), (float)(600 + o.getX()), (float)(600/2 - 120 + o.getY()), 64, 64);
//			//			o.draw();
//		}

//		for(Collectible c : leaves)
//		{
//			c.draw(surface, 64, 64);
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

		caterpillar.act(DRAWING_HEIGHT/2);
		//		for(Predator o : obstacles)
		//		{
		//			if(o.getBounds().intersects(new Rectangle((int)caterpillar.getX(),(int)caterpillar.getY(), 64, 64)))
		//			{
		//				caterpillar.increaseCollisions();
		////				o.setX((Math.random()*(10))+DRAWING_WIDTH);
		//			}
		//		}
		for(Collectible c : leaves) {
			Shape s = new Rectangle(c.getX(), c.getY(), 64, 64);
			if(caterpillar.playerDesignRect().intersects(s)) {
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
		//		for(Element o : obstacles)
		//		{
		//			o.moveByAmount(o.getSpeed(), 0);
		//			if(o.getX() < 0)
		//			{
		////				o.setX((Math.random()*(10))+DRAWING_WIDTH);
		//			}
		//		}
		for(Collectible c : leaves)
		{
			c.moveByAmount(-5, 0);
			if(c.getX() < 0)
			{
				c.moveByAmount(c.getX()+DRAWING_WIDTH, 0);
			}
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
		surface.switchScreen(3);
	}
}
