package Obstacle;

import java.awt.Rectangle;

import Player.Player;
/**
 * Represents an obstacle that a player may encounter
 * @author Claire
 *
 */
public class Obstacle {
	
	private boolean ranInto;
	private static int totalCollisions;
	private double x, y;
	
	/**
	 * Constructs an obstacle
	 */
	public Obstacle(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Obstacle() {
		
	}
	
	/**
	 * Bounces the character back from the obstacle
	 */
	public void moveBack(Player p) {
		p.moveByAmount(-10, 0);
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
		if(totalCollisions > 10) {
			return true;
		}
		return false;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void moveByAmount(double x, double y) {
		this.x += x;
		this.y += y;
	}
}
