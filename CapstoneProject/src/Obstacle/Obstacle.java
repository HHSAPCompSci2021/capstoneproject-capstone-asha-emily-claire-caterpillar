package Obstacle;

import java.awt.Rectangle;

import Player.Butterfly;
import Player.Caterpillar;
import Player.Player;
import core.DrawingSurface;
import processing.core.PImage;
/**
 * Represents an obstacle that a player may encounter
 * @author Claire
 *
 */

public class Obstacle extends Element{
	
	/**
	 * Constructs an obstacle
	 */
	public Obstacle(DrawingSurface ds, String i, int x, int y, double s) {
		super(ds, i, x, y, s);
	}
	
	/**
	 * Constructs an obstacle
	 */
	public Obstacle(DrawingSurface ds, String i, double s) {
		super(ds, i, s);
	}
	
	/**
	 * Bounces the character back from the obstacle
	 */
	public void moveBack(Player p) {
		p.moveByAmount(-20, 0);
	}
	
}
