package Obstacle;

import Player.Player;
import asha.shapes.Rectangle;

/**
 * Represents a Predator (a form of obstacle) that the player may encounter
 * @author Claire
 *
 */
public class Predator extends Obstacle {
	
	private String image;
	
	/**
	 * Creates a predator
	 */
	public Predator(int x, int y, double s) {
		super(x, y, s);
		image = "img/Flower.gif";
	}
	
	public Predator(double s) {
		super(s);
		image = "img/Flower.gif";
	}
	/**
	 * Checks if the player runs into the predator
	 * @return boolean - if the player runs into the predator
	 */
	public boolean ranInto(Player p) {
		
		
		return false;
	}
	
	public String getImage() {
		return image;
	}
	
	public double getSpeed() {
		return -speed;
	}
	
	public Rectangle getRectangle() {
		 = new Rectangle(600 + getX(), 600/2 - 120 + getY(), 64, 64);
		return r;
	}
	
}
