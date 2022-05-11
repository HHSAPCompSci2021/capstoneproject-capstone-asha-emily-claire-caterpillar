package Player;

import java.awt.Point;

import Screen.EggPanel;
import asha.shapes.Rectangle;
import core.DrawingSurface;
import processing.core.PImage;
/**
 * Represents the player. To be expanded upon in other phases.
 * @author Asha
 *
 */
public abstract class Player {
	
	private String design;
	private boolean isAlive;
	private static int totalCollectiblesEaten;
	private int collectiblesEaten;
	private int numCollectibleNeedToEat;
	private Point currentLoc;
	private int totalCollisions;
	//Add a variable for the image
	/**
	 * Constructs an Player that is alive with the number of collectibles needed. The collectablesEaten should continue to increase 
	 * regardless of phase.
	 * @param numCollectableNeedToEat - the int of collectibles that must be eaten
	 */
	public Player(int numCollectableNeedToEat) {
		this.numCollectibleNeedToEat = numCollectableNeedToEat;
		collectiblesEaten = 0;
		isAlive = true;
		totalCollisions = 0;
	}
	
	/**
	 * Eats the collectible; increases the number of collectibles eaten (both total and part for player)
	 */
	public void eatCollectable() {
		totalCollectiblesEaten++;
		collectiblesEaten++;
	}
	/**
	 * Getter method for the sprite design
	 * @precondition imageType is either "caterpillar" or "butterfly"
	 * @param imageType - String of the type of image it will be 
	 * @return the name of the image file
	 */
	public String selectedImage(String imageType) {
		if(imageType.equals("caterpillar")) {
			return "img/Caterpillar.gif";
		} else {
			EggPanel select = new EggPanel(new DrawingSurface()); 
			return select.selectDesign();
		}
		
				
	}
	
	/**
	 * Allows the client to set the total collisions
	 * @param add the number to add to the total collisions
	 */
	public void setTotalCollisions(int add) {
		totalCollisions += add;
	}
	
	/**
	 * Getter method for numCollectibleNeedToEat
	 * @return numCollectibleNeedToEat
	 */
	public int getNumCollectiblesNeedToEat() {
		return numCollectibleNeedToEat;
	}
	
	/**
	 * Increases the total number of collisions for this phase
	 * @return the total number of collisions 
	 */
	public int increaseCollisions() {
		totalCollisions++;
		return totalCollisions;
	}
	
	/**
	 * Returns a Rectangle to of the players image
	 * @return the rectangular frame of the player's image
	 */
	public Rectangle playerDesignRect() {
		return new Rectangle(64, 64, 64, 64);
	}
	
	
	/**
	 * Returns the total number of collectibles eaten throughout the game
	 * @return the total number of collectibles eaten
	 */
	public int getTotalNumCollectible() {
		return totalCollectiblesEaten;
	}
	
	/**
	 * Returns the number of collectibles eaten in this phase
	 * @return the collectibles eaten
	 */
	public int getNumCollectible() {
		return collectiblesEaten;
	}
	
	/**
	 * Returns total collisions
	 * @return total collisions
	 */
	public int getTotalCollisions() {
		return totalCollisions;
	}

	/**
	 * Moves the player by the amount specified
	 * @param y - how much the player vertically moves
	 */
	public abstract void moveByAmount(double x, double y);
	
	/**
	 * Stating the bounds of the window for the player
	 * @param windowWidth - the width of the window (screen)
	 * @param windowHeight - the height of the window (screen)
	 */
	public abstract void applyWindowLimits(int windowWidth, int windowHeight);
	


	/**
	 * Draws the player on the screen
	 */
	public abstract void draw();
	
	
	
}
