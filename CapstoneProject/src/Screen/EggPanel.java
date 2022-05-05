package Screen;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import core.DrawingSurface;
import processing.core.PImage;


public class EggPanel extends Screen{
	private PImage[] designChoices;
	private boolean isFinished;

	private DrawingSurface surface;
	private PImage designChoosen;
	
	/**
	 * Constructs an EggPanel (the screen for the egg phase).
	 * @param surface - a surface to draw on
	 */
	public EggPanel(DrawingSurface surface) {
		this.surface = surface;
		isFinished = false;

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
	public boolean getIsFinished() {
		return isFinished;
	}
	
	/**
	 * Draws the screen
	 */
	public void draw() {
		surface.background(255,255,255);
		surface.fill(102, 255, 178);
	}
	
	/**
	 * Checks if the uses clicks on the screen. If they do, then they are ready to move on to the next screen.
	 */
	public void mousePressed() {
		isFinished = true;
	}
}
