package Screen;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.Egg;
import Sound.SoundJLayer;
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
		
//		SoundJLayer soundToPlay = new SoundJLayer("audio/Egg Panel Music.mp3");
//		soundToPlay.play();

	}
	
	
	/**
	 * Flips through various designs for the user to choose from
	 * @return Index of the design displayed
	 */
	public int displayNextDesign() {
		if(indexDisplayed + 1 > designChoices.size() - 1) {
			indexDisplayed = 0;
		} else {
			indexDisplayed++;
		}
		return indexDisplayed;
		
	}
	/**
	 * The user selects the design, otherwise it is defaulted to the first design.
	 * @return the filename of the design chosen
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
	public void draw() {
		surface.background(255,255,255);
		surface.fill(255);
		surface.image(surface.loadImage("img/background1.jpg"), 0, 0, 800, 600);
	
		surface.image(surface.loadImage(designChoices.get(indexDisplayed)), DRAWING_WIDTH/2, 300, 64, 64);
		surface.text("Click on the screen to choose the butterfly you aspire to be one day. \n "
				+ "Press the spacebar when you are ready to hatch.", DRAWING_WIDTH/3, 400);
		
	
		if (surface.isPressed(KeyEvent.VK_SPACE)) {
			designChoosen = designChoices.get(indexDisplayed);
			surface.switchScreen(2);
		}
	}
	
	/**
	 * Checks if the uses clicks on the screen. If they do, then they are ready to move on to the next screen.
	 * @postcondition a new image is displayed on the screen
	 */
	public void mousePressed() {
		displayNextDesign();
	}
	


	
}
