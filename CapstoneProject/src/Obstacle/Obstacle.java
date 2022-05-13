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

public class Obstacle extends Element{
	
	/**
	 * Constructs an obstacle
	 */
	public Obstacle(String i, int x, int y, double s) {
		super(i, x, y, s);
	}
	
	/**
	 * Constructs an obstacle
	 */
	public Obstacle(String i, double s) {
		super(i, s);
	}
	
	/**
	 * Bounces the character back from the obstacle
	 */
	public void moveBack(Player p) {
		p.moveByAmount(-20, 0);
	}
	
}
