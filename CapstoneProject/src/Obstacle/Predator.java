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
	public Predator(String i, int x, int y, double s) {
		super(i, x, y, s);
	}
	
	/**
	 * Creates a predator
	 */
	public Predator(String i, int x, int y, double s, int xsize, int ysize) {
		super(i, x, y, s, xsize, ysize);
	}
	/**
	 * Creates a predator
	 */
	public Predator(String i, double s) {
		super(i, s);
	}
	
	public Predator(PImage pImage, int x, int y, double s, int xsize, int ysize) {
		super(pImage, x, y, s, xsize, ysize);	
		}

	/**
	 * Checks if the player runs into the predator
	 * @return boolean - if the player runs into the predator
	 */
	public boolean ranInto(Player p) {
		return false;
	}
	
	
}
