package Screen;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Obstacle.Collectible;
import Obstacle.Element;
import Obstacle.Obstacle;
import Obstacle.Predator;
import Player.Butterfly;
import core.DrawingSurface;
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
	
	/*
	 * Array List of all of the collectibles that the player must try and collect
	 */
	private ArrayList<Collectible> col;
	
	/*
	 * The butterfly object that the player controls
	 */
	private Butterfly b;
	
	
	//private boolean restart;
	
	/**
	 * Constructs a ButterflyPanel 
	 * @param s - a DrawingSurface to construct the panel on
	 */
	public ButterflyPanel(DrawingSurface s) {
		super(800,600);
		surface = s;
		//restart = false;
		b = new Butterfly(5, 100, 100, "img/ButterflySprite1.gif");
		obs = new ArrayList<Element>();
		col = new ArrayList<Collectible>();
		int i = 0;
		addRandomElement();
		addRandomCollectable();
		//System.out.println(obs);
	}
	
	/**
	 * Adds a number of predators to random locations
	 */
	public void addRandomElement() {
		for(int i = 0; i < 15; i++) {
			int y = 0;
			//int y = (((int)(Math.random() * 301) + 100) / 10) * 10;
			//System.out.println(y);
			double choice = (Math.random());
			//System.out.println(choice);
			int x = (((int)(Math.random() * 200) + 800) / 10) * 10;
			
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
				obs.add(new Predator("img/Predator.gif", 800 + (i * x), y, 10));
				//System.out.println(false);
	
			} else {
				obs.add(new Obstacle("img/Kite.gif", 800 + (i * x), y, 10));
				//System.out.println(true);
	
			}
			
		}	
	}
	
	/**
	 * Adds a number of collectables to random locations
	 */
	public void addRandomCollectable() {

		for(int i = 0; i < 13; i++) {
			
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
	
			obs.add(new Collectible("flower", "img/Flower.gif", 10, 800 + (i * x), y));
			System.out.println(false);
			
		}	
	}
	
	/**
	 * Clears the screen when the phase needs to restart
	 */
	public void resetScreen() {
		
	}
	
	/**
	 * Checks if this phase is won
	 * @return boolean - if the phase is won
	 */
	public boolean wonGame() {
		
		return false;
	}
	
	/**
	 * Draws the screen for the phase
	 */
	public void draw() {
		
		surface.background(255,255,255);
		surface.fill(0);
		
		
		if(b.getIsAlive()) {
			//restart = false;
			if (surface.isPressed(KeyEvent.VK_UP) && b.getY() >= 0)
				b.moveByAmount(0, -10);
			if (surface.isPressed(KeyEvent.VK_DOWN) &&  b.getY() < 600 - 64)
				b.moveByAmount(0, 10);
			
			
			b.draw(surface);
			
			for(Element e : obs) {
				e.draw(surface);
			}
				
			sideScrolling();
			
			for(Collectible m : col) {
				
				if(m.collide(b.playerDesignRect())) {
					m.eat(b);
				} else {
					m.draw(surface, 64, 64);
				}
				
					
			}
			
			
			for(Element e : obs) {
				
				
				if(e.collide(b.playerDesignRect())) {
						b.increaseCollisions(e);
				} else {
					e.draw(surface);	
				}
									
						
			} 
			
		}	else {
			surface.text("Game Over", 380, 300);
		}
			


		
	}
	
	/**
	 * Checks if a restart of the phase is need
	 * @return boolean - if a restart is needed
	 */
	public void needRestart() {
		//restart = true;
	}
	
	/**
	 * Adds features to the screen in a side scrolling effect
	 */
	public void sideScrolling() {
		
		for(Collectible m : col) {
			if(m.getX() > -64) { 

				m.move();
				
				
			}
		}
		
		for(Element e : obs) {
			if(e.getX() > -64) { 
				e.move();
				
			} 
		}
		
		
	}
	

	
	

	
}
