package Player;

import core.DrawingSurface;

/**
 * Represents the player during the butterfly phase.
 * @author Claire
 *
 */
public class Butterfly extends Player{
	
	private DrawingSurface surface;
	private static double xVol, yVol;
	private String image;
	
	/**
	 * Constructs a Butterfly
	 */
	public Butterfly() {
		super(5);
		image = "img/ButterflySprite1.gif";
	}
	
	/**
	 * Constructs a Butterfly with a default velocity
	 * @param xv - horizontal velocity
	 * @param yv - vertical velocity 
	 */
	public Butterfly(double xv, double yv) {
		super(5);
		xVol = xv;
		yVol = yv;
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
	
	public String imageName() {
		return image;
	}
	
	public double getX() {
		return xVol;
	}
	
	public double getY() {
		return yVol;
	}
	
}
