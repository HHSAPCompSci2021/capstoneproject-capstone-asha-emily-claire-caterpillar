package Player;

import asha.shapes.Rectangle;
import core.DrawingSurface;

/**
 * Represents the player during the butterfly phase.
 * @author Claire
 *
 */
public class Butterfly extends Player{
	
	private DrawingSurface surface;
	private double xVol, yVol;
	private String image;
	private Rectangle r;
	private int numHits;
	
	/**
	 * Constructs a Butterfly
	 */
	public Butterfly() {
		//Asha: Edited this part to allow program to compile. Feel free to change it
		super(5, 50, 500);
		image = "img/ButterflySprite1.gif";
		r = new Rectangle();
	}
	
	/**
	 * Constructs a Butterfly with a default velocity
	 * @param xv - horizontal velocity
	 * @param yv - vertical velocity 
	 */
	public Butterfly(double xv, double yv) {
		super(5, 50, 500);
		xVol = xv;
		yVol = yv;
		image = "img/ButterflySprite1.gif";
	}
	
	//I think only the y velocity is needed as the game is side scrolling. The player just moves up and down
	// - Asha
	@Override
	public void moveByAmount(double x, double y) {
		
		
			xVol += x;
		
			yVol += y;
		
	}

	@Override
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eatCollectable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	
	public void hitObstacle() {
		System.out.print(true);
		numHits++;
	}
	
	public boolean keepPlaying() {
		if(numHits > 2) {
			return false;
		}
		return true;
	}
	
	public String imageName() {
		return image;
	}
	
	public double getX() {
		return xVol;
	}
	
	public double getY() {
		return yVol;
	}
	
	public boolean intersect(Rectangle p) {
		r = new Rectangle(100 + xVol, 600/2 - 64 + yVol, 64, 64); 
		int i = 0;

		if(r.intersects(p)) {
			//System.out.print(true);
			return true;
		}
		
		return false;
	}
	
	public Rectangle getRect() {
		return new Rectangle(xVol, yVol, 64, 64);
	}
	
}
