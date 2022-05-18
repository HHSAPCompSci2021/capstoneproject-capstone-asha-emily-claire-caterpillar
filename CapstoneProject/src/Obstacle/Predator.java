package Obstacle;

import Player.Player;
import asha.shapes.Rectangle;
import core.DrawingSurface;
import processing.core.PImage;

/**
 * Represents a Predator (a form of obstacle) that the player may encounter
 * @author Claire
 *
 */
	public class Predator extends Element {
	
	
	/**
	 * Creates a predator
	 */
	public Predator(DrawingSurface ds, String i, int x, int y, double s) {
		super(ds, i, x, y, s);
	}
	
	/**
	 * Creates a predator
	 */
	public Predator(DrawingSurface ds, String i, double s) {
		super(ds, i, s);
	}
	
	/**
	 * Checks if the player runs into the predator
	 * @return boolean - if the player runs into the predator
	 */
	public boolean ranInto(Player p) {
		return false;
	}
	
	
}
