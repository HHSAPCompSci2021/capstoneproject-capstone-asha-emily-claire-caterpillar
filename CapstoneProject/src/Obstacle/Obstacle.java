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
	
}
