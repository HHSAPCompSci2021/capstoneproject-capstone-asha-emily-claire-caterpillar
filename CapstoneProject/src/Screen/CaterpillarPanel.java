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
	 * @param surface - the Drawing Surface
	 */
	public CaterpillarPanel(DrawingSurface surface)
	{

		super(800,600);
		this.surface = surface;
		obstacles = new ArrayList<Element>();
		leaves = new ArrayList<Collectible>();
		
	}

	/**
	 * Set up the caterpillar panel
	 */
	public void setup()
	{
		PImage p = surface.loadImage("img/Caterpillar.gif");
		obs = new PImage[6];
		obs[0] = surface.loadImage("img/Mole.png");
		obs[1] = surface.loadImage("img/Centi.png");
		obs[2] = surface.loadImage("img/Bottle.png");
		obs[3] = surface.loadImage("img/Robin.png");
		obs[4] = surface.loadImage("img/Spider.png");
		obs[5] = surface.loadImage("img/Rock.png");
		ground = surface.loadImage("img/cBackground.gif");
		
		caterpillar = new Caterpillar(7, 20, DRAWING_HEIGHT/2, p);
		health = new HealthBar(caterpillar);
		leaf = surface.loadImage("img/Leaf.gif");
		addRandompredator();
		addRandomCollectibles();
		
	}

	/**
	 * Adds obstacles to randomized locations to the screen
	 */
	private void addRandompredator() {
		int choice = (int)(Math.random()*6);
		System.out.println(choice);

		if(choice == 0) {	//mole
			obstacles.add(new Predator(obs[0], DRAWING_WIDTH, DRAWING_HEIGHT/2-40, 10, 140, 200));
		} else if(choice == 1) {	//centipede
			obstacles.add(new Predator(obs[1], DRAWING_WIDTH, DRAWING_HEIGHT/2-10, 10, 80, 350));
		} else if(choice == 2) { //bottle
			obstacles.add(new Obstacle(obs[2], DRAWING_WIDTH, DRAWING_HEIGHT/4, 10, 50, 200));
		} else if(choice == 3) { //Robin
			obstacles.add(new Predator(obs[3], DRAWING_WIDTH, DRAWING_HEIGHT/2-40, 10, 64, 64));
		} else if(choice == 4){ //spider
			obstacles.add(new Predator(obs[4], DRAWING_WIDTH, 0, 10, 90, DRAWING_HEIGHT/2+30));
		} else { //rock
			obstacles.add(new Obstacle(obs[5], DRAWING_WIDTH, DRAWING_HEIGHT/2+10, 10, 75, 60));
		}


	}

	/**
	 * Adds collectibles to  randomized locations to the screen
	 */
	private void addRandomCollectibles() {
		for(int i = 0; i < 2; i++)
		{
			int rnd = (int) (Math.random()*300)+200;
			leaves.add(new Collectible("leaf", leaf, 10, DRAWING_WIDTH+(i*DRAWING_WIDTH-5),rnd));
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
				int rnd = (int) (Math.random()*300)+200;
				c.moveByAmount(c.getX()+DRAWING_WIDTH, rnd-c.getY());
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
		if(obstacles.size() == 0)
		{
			addRandompredator();
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
				int rnd = (int) (Math.random()*300)+200;
				c.moveByAmount(c.getX()+DRAWING_WIDTH, rnd-c.getY());
			}
		}
	}


	/**
	 * Clears the screen and restarts the phase
	 */
	public void resetScreen() {
		surface.reset("c");
		surface.switchScreen(6);
	}
	/**
	 * Transitions to the next panel
	 */
	public void nextScreen() {
		surface.switchScreen(7);
	}
}