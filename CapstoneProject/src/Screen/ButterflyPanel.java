package Screen;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

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
	private ArrayList<Predator> obs;
	private Butterfly b;
	
	/**
	 * Constructs a ButterflyPanel 
	 * @param s - a DrawingSurface to construct the panel on
	 */
	public ButterflyPanel(DrawingSurface s) {
		super(800,600);
		surface = s;
		b = new Butterfly();
		obs = new ArrayList<Predator>();
		obs.add(new Predator(600, -100, 5));
		obs.add(new Predator(600, -100, 7));
		obs.add(new Predator(600, 250, 8));
		obs.add(new Predator(600, 250, 10));
		obs.add(new Predator(600, -100, 7));
		obs.add(new Predator(600, 250, 10));
		obs.add(new Predator(600, 250, 10));
		obs.add(new Predator(600, -100, 7));
	





	}
	
	/**
	 * Adds a predator to a random location
	 */
	public void addRandomPredator() {
		
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
		
		
//		
//		if (surface.isPressed(KeyEvent.VK_LEFT) && 100 + b.getX() >= 0)
//			b.moveByAmount(-10, 0);
//		if (surface.isPressed(KeyEvent.VK_RIGHT) &&  100 + b.getX() < 750)
//			b.moveByAmount(10, 0);
		if (surface.isPressed(KeyEvent.VK_UP) && 600/2 - 64 + b.getY() >= 80)
			b.moveByAmount(0, -10);
		if (surface.isPressed(KeyEvent.VK_DOWN) && 600/2 - 64 + b.getY() < 470)
			b.moveByAmount(0, 10);
		
		
		if(b.keepPlaying()) 
			surface.image(surface.loadImage(b.imageName()), (float)(100 + b.getX()), (float)(600/2 - 64 + b.getY()), 64, 64);
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
		
		boolean done = true;
		for(Predator l : obs) {
		//boolean game = false;
		
			
			if(600 + l.getX() > -64 && done) { 
				done = false;
				if(b.intersect(l.getRectangle())) {
				//	final long startTime = System.currentTimeMillis();
				//	if(startTime + 30 == System.currentTimeMillis())
					b.hitObstacle();
				}
				l.moveByAmount(l.getSpeed(), 0);
				surface.image(surface.loadImage(l.getImage()), (float)(600 + l.getX()), (float)(600/2 - 120 + l.getY()), 64, 64);
	
			} else {
				done = true;
			}
		}
		
		
		


		
	}
	
	/**
	 * Checks if a restart of the phase is need
	 * @return boolean - if a restart is needed
	 */
	public boolean needRestart() {
		
		return false;
	}
	
	/**
	 * Adds features to the screen in a side scrolling effect
	 */
	public void sideScrolling() {
		
	}
	

	
}
