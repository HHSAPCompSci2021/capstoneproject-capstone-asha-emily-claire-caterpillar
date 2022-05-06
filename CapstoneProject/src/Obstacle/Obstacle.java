package Obstacle;

import java.awt.Rectangle;
/**
 * Represents an obstacle that a player may encounter
 * @author Claire
 *
 */
public class Obstacle {
	
	private boolean ranInto;
	private int totalCollistions;
	private double x, y;
	
	/**
	 * Constructs an obstacle
	 */
	public Obstacle() {
		
	}
	
	/**
	 * Bounces the character back from the obstacle
	 */
	public void moveBack() {
		
	}
	
	/**
	 * Receies the boundaries of the obstacle
	 * @return a rectangle in those boundaries
	 */
	public Rectangle getBounds() {
		
		return null;
	}
	
	/**
	 * Increases the rate of collisions
	 */
	public void increaseCollisions() {
		
	}
	
	/**
	 * Checks if the character reached the total amount of collsions before having to restart
	 * @return
	 */
	public boolean reachTotalCollisions() {
		
		return false;
	}
}
