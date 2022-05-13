package Player;

import java.util.List;

import Obstacle.Collectible;
import Obstacle.Obstacle;
import Obstacle.Predator;
import core.DrawingSurface;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Represents the player during the Caterpillar phase
 * @author Emily
 *
 */
public class Caterpillar extends Player{
	private PImage image;
	private double yVol;
	private double x, y;
	private boolean onSurface;
	private int upDown;
	
	/**
	 * Constructs a Caterpillar 
	 */
	public Caterpillar(int numCollectableNeedToEat, double x, double y, String design)
	{
		super(numCollectableNeedToEat, x, y, design);
		onSurface = true;
		upDown = 0;
		yVol = 0;
	}
	
	@Override
	public void moveByAmount(double x, double y) {
		setX(getX()+x);
		setY(getY()+x);
		
	}

	@Override
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		// TODO Auto-generated method stub
		
	}

	//Should the parameter be drawing surface instead of PApplet? Also, is this method needed, if it is already being override?
	public void draw(PApplet p) {
		// TODO Auto-generated method stub
		p.image(p.loadImage(selectedImage("caterpillar")), (float)x, (float)y, 64, 64);
			
	}
	
	//Added the drawing surface parameter. 
	@Override
	public void draw(DrawingSurface s) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Makes the Caterpillar dive
	 */
	public void dive() {
		// TODO Auto-generated method stub
		if(onSurface) {
			yVol = 5;
			upDown = -1;
		}
	}

	/**
	 * Makes the Caterpillar jump
	 */
	public void jump() {
		// TODO Auto-generated method stub
		if(onSurface) {
			yVol = -5;
			upDown = 1;
		}

		
	}

	/**
	 * Applies all additional forces to Caterpillar
	 */
	public void act(double ground) {
		// TODO Auto-generated method stub
		onSurface = false;
		if(upDown == 1) {
			yVol += 0.1;
		} else if(upDown == -1)
		{
			yVol -= 0.1;
		}
		
		y += yVol;
		
		if(y == ground)
		{
			yVol = 0;
			y = ground;
			upDown = 0;
			onSurface = true;
			
		}
	}
	
}
