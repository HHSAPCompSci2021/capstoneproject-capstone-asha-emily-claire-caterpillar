package Screen;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import Obstacle.Collectible;
import Obstacle.Element;
import Obstacle.Obstacle;
import Obstacle.Predator;
import Player.Caterpillar;
import Sound.SoundJLayer;
import asha.shapes.Rectangle;
import asha.shapes.Shape;
import core.DrawingSurface;
import processing.core.PImage;

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
	private HealthBar health; 
	private PImage ground;
	private PImage[] obs;
	private boolean screenShown;


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
		
		health = new HealthBar(caterpillar);
		addRandompredator();
		addRandomCollectibles();

		//		SoundJLayer soundToPlay = new SoundJLayer("audio/Caterpillar Panel.mp3");
		//		soundToPlay.play();
	}

	/**
	 * Set up the caterpillar panel
	 */
	public void setup()
	{
		PImage p = surface.loadImage(surface.getDesign());
		obs = new PImage[4];
		obs[0] = surface.loadImage("img/Mole.png");
		obs[1] = surface.loadImage("img/Centi.png");
		obs[2] = surface.loadImage("img/Kite.gif");
		obs[3] = surface.loadImage("img/Predator.gif");

		caterpillar = new Caterpillar(7, 20, DRAWING_HEIGHT/2, p);
		ground = surface.loadImage("img/cBackground.gif");
		screenShown = true;
	}

	/**
	 * Adds obstacles to randomized locations to the screen
	 */
	private void addRandompredator() {
		double choice = (int)(Math.random()*4);
		System.out.println(choice);

		if(choice == 0) {	//mole
			obstacles.add(new Predator("img/Mole.png", DRAWING_WIDTH, 400, 10, 64, 64));
		} else if(choice == 1) {	//centipede
			obstacles.add(new Predator("img/Centi.png", DRAWING_WIDTH, 150, 10, 64, 64));
		} else if(choice == 2) { //kite
			obstacles.add(new Obstacle("img/Kite.gif", DRAWING_WIDTH, 60, 10));
		} else if(choice == 3) { //predator
			obstacles.add(new Predator("img/Predator.gif", DRAWING_WIDTH, 100, 10, 64, 64));
		}


	}

	/**
	 * Adds collectibles to  randomized locations to the screen
	 */
	private void addRandomCollectibles() {
		for(int i = 0; i < 2; i++)
		{
			leaves.add(new Collectible("leaf", "img/Leaf.gif", 5, DRAWING_WIDTH+(i*DRAWING_WIDTH-5), DRAWING_HEIGHT/2+(i*50)));
		}
	}


	/**
	 * Draws the screen
	 */
	public void draw() {
		surface.background(255,255,255);
		
		surface.image(ground, 0, 0, 800, 600);

		for(Element o : obstacles)
		{
			
			o.draw(surface);
		}

		for(Collectible c : leaves)
		{
			c.draw(surface);
		}

		//health.draw(surface);
		caterpillar.draw(surface);
		sideScrolling();

		if (surface.isPressed(KeyEvent.VK_UP))
		{
			caterpillar.jump();
		}
		if(surface.isPressed(KeyEvent.VK_DOWN)) {
			caterpillar.dive();
		}

		caterpillar.act(DRAWING_HEIGHT/2);
		for(int i = 0; i < obstacles.size(); i++)
		{
			Element o = obstacles.get(i);
			o.move();
			if(o.collide(caterpillar.playerDesignRect()))
			{
				caterpillar.increaseCollisions(o);
				obstacles.remove(o);
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
		for(int i = 0; i < obstacles.size(); i++)
		{
			Element o = obstacles.get(i);
			if(o.getX() < o.getBounds().getWidth())
			{
				obstacles.remove(0);
				addRandompredator();
			}
//			if(o.getX() == DRAWING_WIDTH/2)
//			{
//				addRandompredator();
//			}
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
	 * Returns the status of the screen; showing or not
	 * @return true if caterpillar screen is showing; false otherwise
	 */
	public boolean getScreenStat()
	{
		return screenShown;
	}

	/**
	 * Clears the screen and restarts the phase
	 */
	public void resetScreen() {
		surface.switchScreen(6);
	}
	/**
	 * Transitions to the next panel
	 */
	public void nextScreen() {
		surface.switchScreen(7);
		screenShown = false;
	}
}
