package Player;

import java.awt.Point;
//Originally had the wrong element export but i changed it -claire
import Obstacle.Element;
import Obstacle.Obstacle;
import Obstacle.Predator;
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
	
	private boolean isAlive;
	private int totalCollectiblesEaten;
	private int collectiblesEaten;
	private int numCollectibleNeedToEat;
	private Point currentLoc;
	private int totalCollisions;
	private double x, y;
	private String design;
	//Add a variable for the image
	/**
	 * Constructs an Player that is alive with the number of collectibles needed. The collectablesEaten should continue to increase 
	 * regardless of phase.
	 * @param numCollectableNeedToEat - the int of collectibles that must be eaten
	 */
	public Player(int numCollectableNeedToEat, double x, double y, String design) {
		this.numCollectibleNeedToEat = numCollectableNeedToEat;
		this.x = x;
		this.y = y;
		this.design = design;
		this.currentLoc = new Point(50, 500);
		collectiblesEaten = 0;
		isAlive = true;
		totalCollisions = 0;
	}
	
	/**
	 * Getter method for design
	 * @return name of the design file
	 */
	public String getDesign() {
		return design;
	}
	/**
	 * Changes 
	 * @param newDesign
	 */
	public void setDesign(String newDesign) {
		design = newDesign;
	}
	/**
	 * Returns the Point of the current location
	 * @return Point - the current location
	 */
	public Point getCurrentLoc() {
		return currentLoc;
	}
	
	public void setCurrentLoc(Point setLoc) {
		currentLoc = setLoc;
	}
	
	/**
	 * Getter method of isAlive
	 * @return isAlive
	 */
	public boolean getIsAlive() {
		return isAlive;
	}
	
	/**
	 * Setter method for isAlive
	 * @param change - what to change it to
	 */
	public void setIsAlive(boolean change) {
		isAlive = change;
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
	 * @postcondition changes isAlive to false if there are 3 or more collisions
	 */
	public int increaseCollisions(Element element) {
		
		if(element instanceof Obstacle) {
			totalCollisions++;
		} else if(element instanceof Predator) {
			totalCollisions = 3;
		}
		
		if(totalCollisions >= 3) {
			isAlive = false;
		}
		
		return totalCollisions;
	}
	
	/**
	 * Returns a Rectangle to of the players image
	 * @return the rectangular frame of the player's image
	 */
	public Rectangle playerDesignRect() {
		return new Rectangle(x, y, 64, 64);
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
	 * Returns x
	 * @return double - x 
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Changes the value of x
	 * @precondition set is a positive number
	 * @param set - an int that it will be set too
	 */
	public void setX(double set) {
		x = set;
	}
	
	/**
	 * Returns y
	 * @return y
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Changes the value of y
	 * @param set - an int that it will be set oo
	 */
	public void setY(double set) {
		y = set;
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
	


	//Added DrawingSurface as a parameter -Claire
	
	/**
	 * Draws the player on the screen
	 * @param s - the DrawingSurface
	 */
	public abstract void draw(DrawingSurface s);
	
	
	
}
