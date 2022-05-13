package Screen;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

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
	
	private DrawingSurface surface;
	private ArrayList<Element> obs;
	private Butterfly b;
	private boolean restart;
	
	/**
	 * Constructs a ButterflyPanel 
	 * @param s - a DrawingSurface to construct the panel on
	 */
	public ButterflyPanel(DrawingSurface s) {
		super(800,600);
		surface = s;
		restart = false;
		b = new Butterfly(5, 100, 100, "img/ButterflySprite1.gif");
		obs = new ArrayList<Element>();
		int i = 0;
		while ( i < 5) {
			addRandomElement();
			i++;
		}
		//System.out.println(obs);
	}
	
	/**
	 * Adds a predator to a random location
	 */
	public void addRandomElement() {
		int y = (((int)(Math.random() * 301) + 100) / 10) * 10;
		//System.out.println(y);
		double choice = (Math.random());
		//System.out.println(choice);

		if(choice >= 0.5) {
			obs.add(new Predator("img/Predator.gif", 600, y, 10));
			System.out.println(false);

		} else {
			obs.add(new Obstacle("img/Flower.gif", 600, y, 10));
			System.out.println(true);

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
			restart = false;
			if (surface.isPressed(KeyEvent.VK_UP) && 600/2 - 64 + b.getY() >= 80)
				b.moveByAmount(0, -10);
			if (surface.isPressed(KeyEvent.VK_DOWN) && 600/2 - 64 + b.getY() < 470)
				b.moveByAmount(0, 10);
			
			
			b.draw(surface);
			
			for(Element e : obs) {
				e.draw(surface);
			}
				
			
			boolean done = true;
			for(Element e : obs) {
				if(600 + e.getX() > -64 && done) { 
						done = false;
						if(e.collide(b.playerDesignRect())) {
							b.increaseCollisions(e);
						}
						e.move();
						e.draw(surface);
						
					} else {
						done = true;
					}
				}
		}	else {
			surface.text("Game Over", 380, 300);
		}
			
			
		//}
		
		
	
		
		
		
		
//		
//		if(b.keepPlaying()) 
//			s
		//System.out.println(b.getX() + " " + b.getY());
		
		//surface.image(surface.loadImage(obs.get(0).getImage()), (float)(600 + obs.get(0).getX()), (float)(600/2 - 120 + obs.get(0).getY()), 64, 64);

//		
//		for(Predator l : obs) {
//		//boolean game = false;
//		
//			
//			if(600 + l.getX() > -20) { 
//				if(b.intersect(l.getRectangle())) {
//					surface.text("GAME OVER", 100, 100);
//				}
//				l.moveByAmount(l.getSpeed(), 0);
//				surface.image(surface.loadImage(l.getImage()), (float)(600 + l.getX()), (float)(600/2 - 120 + obs.get(i).getY()), 64, 64);
//				
//
//			} else {
//				if(b.intersect(obs.get(i+1).getRectangle())) {
//					surface.text("GAME OVER", 100, 100);
//				}
//				if(600 + obs.get(i+1).getX() > -20)  {
//					obs.get(i+1).moveByAmount(obs.get(i + 1).getSpeed(), 0);
//					surface.image(surface.loadImage(obs.get(i+1).getImage()), (float)(600 + obs.get(i+1).getX()), (float)(600/2 + 100 + obs.get(i+1).getY()), 64, 64);
//					
//				} else
//					done = true;
//			}
//		}
		
		
		
		
		


		
	}
	
	/**
	 * Checks if a restart of the phase is need
	 * @return boolean - if a restart is needed
	 */
	public void needRestart() {
		restart = true;
	}
	
	/**
	 * Adds features to the screen in a side scrolling effect
	 */
	public void sideScrolling() {
		
	}
	

	
}
