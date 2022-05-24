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
	 * Creates a Butterfly
	 * @param numCollectable - collectibles required to eat
	 * @param x - x-coordinate
	 * @param y - y-coordinate
	 * @param design - image
	 */
	public Butterfly(int numCollectable, double x, double y, PImage design) {
		super(numCollectable, x, y, design);
	}
	

	/**
	 * Moves by amount suggested
	 * @param x - x-coordinate
	 * @param y - y-coordinate 
	 */
	@Override
	public void moveByAmount(double x, double y) {	
			setY(getY() + y);
	}


	/**
	 * Draws the butterfly
	 * @param s - DrawingSurface
	 */
	@Override
	public void draw(DrawingSurface s) {
			s.image(s.loadImage(s.getDesign()), (float)getX(), (float)getY(), 100, 100);
			
	}
	/**
	 * Draws the butterfly
	 * @param s - DrawingSurface
	 */
	public void draw2(DrawingSurface s) {
		s.image(getDesign(), (float)getX(), (float)getY(), 100, 100);
		
}
	/**
	 * Draws the butterfly
	 * @param s - DrawingSurface
	 * @param p - image
	 */
	public void draw1(DrawingSurface s, PImage p) {
		s.image(p, (float)getX(), (float)getY(), 100, 100);
		
}
	/**
	 * Applies window limits
	 */
	@Override
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		// TODO Auto-generated method stub
		
	}
	

	
	
	
}
