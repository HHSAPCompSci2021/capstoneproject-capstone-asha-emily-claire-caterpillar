package Obstacle;

import java.awt.Rectangle;

import Player.Butterfly;
import Player.Caterpillar;
import Player.Player;
/**
 * Represents an obstacle that a player may encounter
 * @author Claire
 *
 */
<<<<<<< Updated upstream
public class Obstacle {
	
	private boolean ranInto;
	private double x, y;
=======
public class Obstacle extends Element{
>>>>>>> Stashed changes
	
	/**
	 * Constructs an obstacle
	 */
	public Obstacle(int x, int y, double s) {
		super(x, y, s);
	}
	
	public Obstacle(double s) {
		super(s);
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
	
<<<<<<< Updated upstream
	/**
	 * Checks if the character reached the total amount of collsions before having to restart
	 * @return
	 */
	public boolean reachTotalCollisions(Caterpillar caterpillar, Butterfly butterfly) {
		if(caterpillar != null) {
			if(caterpillar.getTotalCollisions() > 3) {
				return true;
			}
		}
		
		if(butterfly != null) {
			if(butterfly.getTotalCollisions() > 3) {
				return true;
			}
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
=======
>>>>>>> Stashed changes
}
