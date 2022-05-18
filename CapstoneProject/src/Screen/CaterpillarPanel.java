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
	private PImage sky;


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
	}
	
	/**
	 * Adds obstacles to randomized locations to the screen
	 */
	private void addRandompredator() {
		obstacles.add(new Predator("img/Predator.gif", (int)(Math.random()*5)+DRAWING_WIDTH, 450, 5));
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
				System.out.println("here");
				c.moveByAmount(c.getX()+DRAWING_WIDTH, 10);
				c.eat(caterpillar);
				System.out.println(caterpillar.getNumCollectible());
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
		surface.switchScreen(4);
	}
	/**
	 * Transitions to the next panel
	 */
	public void nextScreen() {
		surface.switchScreen(5);
	}
}
