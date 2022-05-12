package Obstacle;

import Player.Player;
import asha.shapes.Rectangle;

/**
 * Represents a Predator (a form of obstacle) that the player may encounter
 * @author Claire
 *
 */
public class Predator extends Element {
	
	
	/**
	 * Creates a predator
	 */
	public Predator(String i, int x, int y, double s) {
		super(i, x, y, s);
	}
	
	public Predator(String i, double s) {
		super(i, s);
	}
	
	/**
	 * Checks if the player runs into the predator
	 * @return boolean - if the player runs into the predator
	 */
	public boolean ranInto(Player p) {
		
		
		return false;
	}
	
	
}
