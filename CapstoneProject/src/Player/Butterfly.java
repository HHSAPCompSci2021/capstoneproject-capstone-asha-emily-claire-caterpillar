package Player;

import asha.shapes.Rectangle;
import core.DrawingSurface;
import processing.core.PImage;

/**
 * Represents the player during the butterfly phase.
 * @author Claire
 *
 */
public class Butterfly extends Player{
	
	//private DrawingSurface surface;

	
	/**
	 * Constructs a Butterfly
	 */
	public Butterfly(int numCollectable, double x, double y, PImage design) {
		//Asha: Edited this part to allow program to compile. Feel free to change it
		super(numCollectable, x, y, design);
	}
	

	//I think only the y velocity is needed as the game is side scrolling. The player just moves up and down
	// - Asha
	@Override
	public void moveByAmount(double x, double y) {	
			setY(getY() + y);
	}



	@Override
	public void draw(DrawingSurface s) {
			s.image(s.loadImage(s.getDesign()), (float)getX(), (float)getY(), 100, 100);
			
	}
	
	public void draw2(DrawingSurface s) {
		s.image(getDesign(), (float)getX(), (float)getY(), 100, 100);
		
}

	public void draw1(DrawingSurface s, PImage p) {
		s.image(p, (float)getX(), (float)getY(), 100, 100);
		
}

	@Override
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		// TODO Auto-generated method stub
		
	}
	

	
	
	
}
