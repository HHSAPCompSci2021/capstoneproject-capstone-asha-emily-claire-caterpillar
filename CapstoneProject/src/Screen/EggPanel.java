package Screen;

import java.awt.Rectangle;

import core.DrawingSurface;
import processing.core.PImage;

public class EggPanel extends Screen{
	private PImage[] designChoices;
	private Rectangle button;
	private DrawingSurface surface;
	private PImage designChoosen;
	
	/**
	 * Constructs an EggPanel (the screen for the egg phase).
	 * @param surface - a surface to draw on
	 */
	public EggPanel(DrawingSurface surface) {
		this.surface = surface;
	}
	
	/**
	 * Flips through various designs for the user to choose from
	 */
	public void displayNextDesign() {
		
	}
	/**
	 * The user selects the design, otherwise it is defaulted to the first design.
	 * @return
	 */
	public PImage selectDesign() {
		return null;
	}
	
	/**
	 * Checks if this phase is finished 
	 * @return boolean - if the phase is finished it returns true, otherwise false.
	 */
	public boolean isFinished() {
		return false;
	}
	
	/**
	 * Draws the screen
	 */
	public void draw() {
		//super.draw();
	}
}
