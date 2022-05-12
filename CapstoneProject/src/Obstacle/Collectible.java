package Obstacle;

import Player.Player;
import core.DrawingSurface;
import processing.core.PImage;
/**
 * Represents a Collectible, such as a leaf or flower
 * @author Asha
 *
 */
public class Collectible extends Element{
	private boolean eatenYet;
	private String collectibleType;
	private String typeDesign;
	private double x, y;
	
	/**
	 * Constructs a collectible (either a leaf or flower)
	 * @precondition collectableType is either a "leaf" or "flower"
	 * @param collectibleType - leaf or flower
	 */
	public Collectible(String collectibleType, String image, double speed, double x, double y) {
		super(image, speed);
		this.x = x;
		this.y = y;
		this.collectibleType = collectibleType;
		eatenYet = false;
		
		if(collectibleType.equals("leaf")) {
			typeDesign = "img/Leaf.gif";
		} else {
			typeDesign = "img/Flower.gif";
		}
	}
	
	/**
	 * The collectible is collected. The total number of collectibles and the number of collectibles per phase increase.
	 * The collectible becomes eaten and on other methods managed by the panel should disappear.
	 * @param player - A Player object that will collect this collectible
	 */
	public void eat(Player player) {
		player.eatCollectable();
		eatenYet = true;
	}
	
	/**
	 * Getter method for if the collectible is eaten yet
	 * @return eatenYet - if the collectible has been eaten
	 */
	public boolean getEatenYet() {
		return eatenYet;
	}
	
	/**
	 * Displays the image on the screen
	 * @precondition surface is not null. x, y, width, and height are all positive
	 * @param surface - a DrawingSurface to place the image on
	 * @param x - the int x coordinate
	 * @param y - the int y coordinate
	 * @param width - the int width
	 * @param height - the int height
	 * @postcondition An image is placed on the screen
	 */
	public void draw(DrawingSurface surface, int width, int height) {
		while(!eatenYet) {
			surface.image(surface.loadImage(typeDesign), (float) x, (float) y, width, height);
		}
		
	}
	/**
	 * Returns the type of collectible it is: leaf or flower
	 * @return collectibleType - whether it is a leaf or flower
	 */
	public String getCollectibleType() {
		return collectibleType;
	}
	
	/**
	 * Moves by the amount specified
	 * @param x - horizontal amount to move by
	 * @param y - vertical amount to move by
	 */
	public void moveByAmount(double x, double y) {
		this.x += x;
		this.y += y;
	}
	/**
	 * Returns the x coordinate of the collectible
	 * @return x coordinate of the collectible
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Returns y coordinate of the collectible
	 * @return y coordinate of the collectible
	 */
	public double getY() {
		return y;
	}
}
