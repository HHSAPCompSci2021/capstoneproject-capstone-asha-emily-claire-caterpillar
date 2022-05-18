package Screen;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Obstacle.Collectible;
import Obstacle.Element;
import Obstacle.Obstacle;
import Obstacle.Predator;
import Player.Butterfly;
import Sound.SoundJLayer;
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
	
	private HealthBar h;
	
	
	//private boolean restart;
	
	/**
	 * Constructs a ButterflyPanel 
	 * @param s - a DrawingSurface to construct the panel on
	 */
	public ButterflyPanel(DrawingSurface s) {
		super(800,600);
		surface = s;
		//restart = false;
		b = new Butterfly(5, 100, 100, "img/Butterfly1.gif");
		obs = new ArrayList<Element>();
		//col = new ArrayList<Collectible>();
		int i = 0;
		addRandomElement();
		addRandomCollectible();
		
//		SoundJLayer soundToPlay = new SoundJLayer("audio/Butterfly Panel Music.mp3");
//		soundToPlay.play();
		
		//System.out.println(obs);
		h = new HealthBar(b);
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
				obs.add(new Predator("img/Predator.gif", 800 + (i * x), y, speed));
				//System.out.println(false);
	
			} else {
				obs.add(new Obstacle("img/Kite.gif", 800 + (i * x), y, speed));
				//System.out.println(true);
	
			}
			
		}	
	}
	
	/**
	 * Adds a number of collectables to random locations
	 */
	public void addRandomCollectible() {

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
			obs.add(new Collectible("flower", "img/Flower.gif", speed, 800 + (i * x), y));
			//System.out.println(false);
			
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
		
		h.draw(surface);
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
			
//			for(Collectible m : col) {
//				
//				if(m.collide(b.playerDesignRect())) {
//					System.out.print(true);
//					m.eat(b);
//					
//					//m.moveByAmount(m.getX() + DRAWING_WIDTH, 0);
//					
//				} else {
//					m.draw(surface, 64, 64);
//				}
//				
//					
//			}
			
			
			for(Element e : obs) {
				
				if(e instanceof Collectible) {
					if(e.collide(b.playerDesignRect())) {
						System.out.print(true);
						
						
						e.moveByAmount(e.getX() - DRAWING_WIDTH, 0);
						((Collectible) e).eat(b);
					} else {
						e.draw(surface);
					}
				} else {
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
		
	
		
		for(Element e : obs) {
			if(e.getX() > -64) { 
				e.move();
				
			} 
		}
		
		
	}
	

	
	

	
}
