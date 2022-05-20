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
	private PImage leaf;
	private PImage[] obs;


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
	 * Set up the caterpillar panel
	 */
	public void setup()
	{
		PImage p = surface.loadImage("img/Caterpillar.gif");
		obs = new PImage[4];
		obs[0] = surface.loadImage("img/Mole.png");
		obs[1] = surface.loadImage("img/Centi.png");
		obs[2] = surface.loadImage("img/Kite.gif");
		obs[3] = surface.loadImage("img/Predator.gif");
		ground = surface.loadImage("img/cBackground.gif");
		
		caterpillar = new Caterpillar(7, 20, DRAWING_HEIGHT/2, p);
		health = new HealthBar(caterpillar);
		obstacles = new ArrayList<Element>();
		leaves = new ArrayList<Collectible>();
		leaf = surface.loadImage("img/Leaf.gif");
		
		addRandompredator();
		addRandomCollectibles();
	}

	/**
	 * Adds obstacles to randomized locations to the screen
	 */
	private void addRandompredator() {
		int choice = (int)(Math.random()*4);
		System.out.println(choice);

		if(choice == 0) {	//mole
			Element mole = new Predator(obs[0], DRAWING_WIDTH, DRAWING_HEIGHT/2-40, 10, 200, 200);
			obstacles.add(mole);
			mole.resizeBounds((int)mole.getX()+30, (int)mole.getY(), 140, 200); 
		} else if(choice == 1) {	//centipede
			obstacles.add(new Predator(obs[1], DRAWING_WIDTH, DRAWING_HEIGHT/2-10, 10, 80, 350));
		} else if(choice == 2) { //kite
			obstacles.add(new Obstacle(obs[2], DRAWING_WIDTH, 60, 10));
		} else if(choice == 3) { //predator
			obstacles.add(new Predator(obs[3], DRAWING_WIDTH, 100, 10, 64, 64));
		}


	}

	/**
	 * Adds collectibles to  randomized locations to the screen
	 */
	private void addRandomCollectibles() {
		for(int i = 0; i < 2; i++)
		{
			leaves.add(new Collectible("leaf", leaf, 5, DRAWING_WIDTH+(i*DRAWING_WIDTH-5), DRAWING_HEIGHT/2+(i*50)));
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
			o.draw1(surface);
//			surface.rect((float)o.getBounds().getX(), (float)o.getBounds().getY(), (float)o.getBounds().getWidth(), (float)o.getBounds().getHeight());
		}

		for(Collectible c : leaves)
		{
			c.draw1(surface);
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
			System.out.println("here: " + caterpillar.getTotalCollisions());
			resetScreen();
			caterpillar.setTotalCollisions(0);
			caterpillar.setCollectiblesEaten(0);
			return;
		}
	}

	/**
	 * Implements the side scrolling effect, by adding features to the screen
	 */
	public void sideScrolling() {
		for(int i = 0; i < obstacles.size(); i++)
		{
			Element o = obstacles.get(i);
			if(o.getX() < -o.getBounds().getWidth())
			{
				obstacles.remove(0);
				addRandompredator();
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
		
		surface.switchScreen(6);
	}
	/**
	 * Transitions to the next panel
	 */
	public void nextScreen() {
		surface.switchScreen(7);
	}
}