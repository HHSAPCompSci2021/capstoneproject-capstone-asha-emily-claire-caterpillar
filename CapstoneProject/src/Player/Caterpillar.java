package Player;

import java.util.List;

import Obstacle.Collectible;
import Obstacle.Obstacle;
import Obstacle.Predator;
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
	public Caterpillar(double x, double y)
	{
		super(5, x, y);
		onSurface = true;
		upDown = 0;
		yVol = 0;
	}
	
	@Override
	public void moveByAmount(double x, double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		// TODO Auto-generated method stub
		
	}

	public void draw(PApplet p) {
		// TODO Auto-generated method stub
		p.image(p.loadImage(selectedImage("caterpillar")), (float)x, (float)y, 64, 64);
			
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	public void dive() {
		// TODO Auto-generated method stub
		if(onSurface) {
			yVol = 5;
			upDown = -1;
		}
	}

	public void jump() {
		// TODO Auto-generated method stub
		if(onSurface) {
			yVol = -5;
			upDown = 1;
		}

		
	}

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

	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}
	
}
