package Screen;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Player.Egg;
import core.DrawingSurface;
import processing.core.PApplet;
import processing.core.PImage;


/**
 * The screen during the egg phase
 * @author Asha
 *
 */
public class EggPanel extends Screen{
	private ArrayList<String> designChoices;
	private boolean isFinished;

	private DrawingSurface surface;
	private int indexDisplayed;
	private String designChoosen;
	
	/**
	 * Constructs an EggPanel (the screen for the egg phase).
	 * @param surface - a surface to draw on
	 */
	public EggPanel(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
		isFinished = false;
		designChoices = new ArrayList<String>();
		designChoices.add("img/ButterflySprite1.gif");
		designChoices.add("img/ButterflySprite2.gif");
		designChoices.add("img/ButterflySprite3.gif");
		indexDisplayed = 0;
		designChoosen = designChoices.get(0);

	}
	
	/**
	 * Flips through various designs for the user to choose from
	 * @return Index of the design displayed
	 */
	public int displayNextDesign() {
		if(indexDisplayed + 1 > designChoices.size()) {
			indexDisplayed = 0;
		} else if(indexDisplayed - 1 < 0){
			indexDisplayed = designChoices.size() - 1;
		} else {
			indexDisplayed++;
		}
		return indexDisplayed;
		
	}
	/**
	 * The user selects the design, otherwise it is defaulted to the first design.
	 * @return
	 */
	public String selectDesign() {

		return designChoosen;
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
	public void draw(PApplet drawer) {
		surface.background(255,255,255);
		surface.fill(102, 255, 178);
		surface.image(drawer.loadImage(designChoices.get(indexDisplayed)), 0, 0);
	}
	
	/**
	 * Checks if the uses clicks on the screen. If they do, then they are ready to move on to the next screen.
	 */
	public void mousePressed() {
		designChoosen = designChoices.get(indexDisplayed);
		isFinished = true;
	}
	/**
	 * Checks if the space key is pressed. If so, it transitions to the next design.
	 * @param event
	 */
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_SPACE) {
			displayNextDesign();
		}
	}
}
