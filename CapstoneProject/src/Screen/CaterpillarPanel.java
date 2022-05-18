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
		caterpillar = new Caterpillar(7, 20, DRAWING_HEIGHT/2, surface.getDesign());
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
		ground = surface.loadImage("img/ground.gif");
		screenShown = true;
	}

	/**
	 * Adds obstacles to randomized locations to the screen
	 */
	private void addRandompredator() {
//		int y = 0;
//		double choice = (int)(Math.random()*7);
//		//System.out.println(choice);
//		int x = (((int)(Math.random() * 200) + 800) / 10) * 10;
//		double speed = 10 + (i * 0.5);
//		if(choice >= 0.9) {
//			y = 64;
//		} else if(choice >= 0.7) {
//			y = 128;
//		} else if(choice >= 0.5) {
//			y = 256;
//		} else if(choice >= 0.3) {
//			y = 384;
//		} else {
//			y = 512;
//		} 
//
//		if(choice >= 0.5) {
//			obstacles.add(new Predator("img/Predator.gif", 800 + (i * x), y, speed));
//			//System.out.println(false);
//
//		} else {
//			obstacles.add(new Obstacle("img/Kite.gif", 800 + (i * x), y, speed));
//			//System.out.println(true);
//
//		}

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
		surface.image(ground, 0, DRAWING_HEIGHT/2+32, 800, 600);

		for(Element o : obstacles)
		{
			o.draw(surface);
		}

		for(Collectible c : leaves)
		{
			c.draw(surface);
		}

		health.draw(surface);
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
				o.moveByAmount(DRAWING_WIDTH, 0);
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
		surface.switchScreen(4);
	}
	/**
	 * Transitions to the next panel
	 */
	public void nextScreen() {
		surface.switchScreen(5);
		screenShown = false;
	}
}
