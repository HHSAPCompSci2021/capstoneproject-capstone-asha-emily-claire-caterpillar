package Screen;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Obstacle.Collectible;
import Obstacle.Element;
import Obstacle.Obstacle;
import Obstacle.Predator;
import Player.Butterfly;
import Sound.SoundJLayer;
import core.DrawingSurface;
import processing.core.PImage;
/**
 * The screen during the Butterfly phase
 * @author Claire
 *
 */
public class ButterflyPanel extends Screen {
	
	/*
	 * DrawingSurface where the panels are being made
	 */
	private DrawingSurface surface;
	
	/*
	 * Array List of all of the elements that the player must avoid
	 */
	private ArrayList<Element> obs;
	
	private ArrayList<Element> obs1;
	
	/*
	 * Array List of all of the collectibles that the player must try and collect
	 */
	private ArrayList<Collectible> col;
	
	/*
	 * The butterfly object that the player controls
	 */
	private Butterfly b;
	
	private HealthBar h;
	
	private ArrayList<PImage> img;
	private PImage p;
	

	
	/**
	 * Constructs a ButterflyPanel 
	 * @param s - a DrawingSurface to construct the panel on
	 */
	public ButterflyPanel(DrawingSurface s) {
		super(800,600);
		surface = s;
		
		
//		SoundJLayer soundToPlay = new SoundJLayer("audio/Butterfly Panel Music.mp3");
//		soundToPlay.play();
	
		
	}
	
	public void setup() {
		

		p = surface.loadImage("img/Butterfly1.gif");
		
		obs = new ArrayList<Element>();
		obs1 = new ArrayList<Element>();
		col = new ArrayList<Collectible>();
		img = new ArrayList<PImage>();
		
		addRandomElement(obs);
		addRandomCollectible(col);

		b = new Butterfly(5, 100, 100, p);
		h = new HealthBar(b);
		
		
	}
	
	/**
	 * Adds a number of predators to random locations
	 */
	public void addRandomElement(ArrayList<Element> a) {
		for(int i = 0; i < 20; i++) {
			int y = 0;
			//int y = (((int)(Math.random() * 301) + 100) / 10) * 10;
			//System.out.println(y);
			double choice = (Math.random());
			//System.out.println(choice);
			int x = (((int)(Math.random() * 200) + 800) / 10) * 10;
			double speed = 10 + (i * 0.5);
			if(choice >= 0.9) {
				y = 64;
			} else if(choice >= 0.7) {
				y = 128;
			} else if(choice >= 0.5) {
				y = 256;
			} else if(choice >= 0.3) {
				y = 384;
			} else {
				y = 512;
			} 
		
			
			if(choice >= 0.5) {
				a.add(new Predator("img/Predator.gif", 800, y, speed));
				//img.add(createImage());
				//return new Predator("img/Predator.gif", 800, y, 10);
				//System.out.println(false);
				
				
	
			} else {
				a.add(new Obstacle("img/Kite.gif", 800, y, speed));
				//return new Obstacle("img/Kite.gif", 800, y, 10);
				//System.out.println(true);
	
			}
			
		}	
	}
	
	/**
	 * Adds a number of collectables to random locations
	 */
	public void addRandomCollectible(ArrayList<Collectible> a) {

		for(int i = 0; i < 7; i++) {
			
			double speed = 10 + (i * 0.5);
			
			double choice = (Math.random());
			int y = 0; 
			
			if(choice >= 0.9) {
				y = 0;
			} else if(choice >= 0.7) {
				y = 192;
			} else if(choice >= 0.4) {
				y = 320;
			} else  {
				y = 448;
			} 
			
			int x = (((int)(Math.random() * 200) + 400) / 10) * 10;
			
			//Was this supposed to be added to the collectible array instead of obs
			col.add(new Collectible("flower", "img/Flower.gif", speed, 800 + (i * x), y));
			//System.out.println(false);
			
		}	
	}
	
	
	/**
	 * Draws the screen for the phase
	 */
	public void draw() {
		//System.out.println(true);
		surface.background(255,255,255);
		surface.fill(0);
		
		h.draw(surface);
		if(b.getIsAlive()) {
			//restart = false;
			if (surface.isPressed(KeyEvent.VK_UP) && b.getY() >= 0)
				b.moveByAmount(0, -10);
			if (surface.isPressed(KeyEvent.VK_DOWN) &&  b.getY() < 600 - 64)
				b.moveByAmount(0, 10);
			
			
			b.draw(surface);
	
			//int i = 0;
			boolean next = true;

			
			while(obs.size() > 0 && next) {
				next = false;
				obs.get(0).draw(surface);
				sideScrolling(obs.get(0));
				
				if(obs.get(0).getX() < 0) {
					next = true;
					obs.remove(0);
				}
			}
			
			boolean wow = true;

			
			
			while(col.size() > 0 && wow) {
				wow = false;
				col.get(0).draw(surface);
				sideScrolling(col.get(0));
				
				if(col.get(0).getX() < 0) {
					wow = true;
					col.remove(0);
				}
			}
		
			
			
			for(Element e : obs) {
				e.draw(surface);
			}
			
			for(Collectible c : col) {
				c.draw(surface);
			}
				
			//sideScrolling();
			
			
			for(Element e : obs) {
				
				
					if(e.collide(b.playerDesignRect())) {
						if(e instanceof Predator) {
							b.increaseCollisions((Predator)e);
						} else {
							e.moveByAmount(e.getX() - 64, DRAWING_HEIGHT);
							b.increaseCollisions((Obstacle)e);
						}
						
					} else {
						e.draw(surface);	
					}						
						
			} 
			
			for(Collectible c : col) {
				if(c instanceof Collectible) {
					if(c.collide(b.playerDesignRect())) {
						System.out.print(true);
						
						
						c.moveByAmount(c.getX() - DRAWING_WIDTH, 0);
						((Collectible) c).eat(b);
					} else {
						c.draw(surface);
					}
				}
			}
			
			
			
		}	else {
			resetScreen();
		}
			
		if(b.getNumCollectible() == b.getNumCollectiblesNeedToEat())
		{
			nextScreen();
			return;
		}
		
		
	}

	
	public void resetScreen() {
		surface.switchScreen(5);
	}
	
	public void nextScreen() {
		surface.switchScreen(7);
	}
	
	/**
	 * Adds features to the screen in a side scrolling effect
	 */
	public void sideScrolling(Element e) {
		
		
		if(e.getX() > -64) { 
			e.move();
////		
//		for(Collectible c : col) {
//			if(c.getX() > -64) { 
//				c.move();
//				
//			} 
//		}
//		
//		
//		for(Element e : obs) {
//			if(e.getX() > -64) { 
//				e.move();
//				
//			} 
		}
		
		
	}
	

	
	

	
}
