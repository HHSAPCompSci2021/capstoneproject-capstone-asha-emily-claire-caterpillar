package Obstacle;

import Player.Player;

/**
 * Represents a Predator (a form of obstacle) that the player may encounter
 * @author Claire
 *
 */
public class Predator extends Obstacle {
	/**
	 * Creates a predator
	 */
	public Predator(int x, int y) {
		super(x, y);
	}
	/**
	 * Checks if the player runs into the predator
	 * @return boolean - if the player runs into the predator
	 */
	public boolean ranInto(Player p) {
		
		
		return false;
	}
	
}
