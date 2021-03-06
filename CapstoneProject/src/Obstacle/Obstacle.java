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
	 * @param i - file name of the obstacle
	 * @param x - x-coordinate of the obstacle
	 * @param y - y-coordinate of the obstacle
	 * @param s - speed of the obstacle
	 */
	public Obstacle(String i, int x, int y, double s) {
		super(i, x, y, s);
	}
	
	/**
	 * Constructs an obstacle
	 * @param i - file name 
	 * @param s - speed 
	 */
	public Obstacle(String i, double s) {
		super(i, s);
	}
	/**
	 * Constructs an obstacle
	 * @param pImage - PImage
	 * @param x - x-coordinate 
	 * @param y - y-coordinate
	 * @param s - speed 
	 */
	public Obstacle(PImage pImage, int x, int y, int s) {
		// TODO Auto-generated constructor stub
		super(pImage, x, y, s, 64, 64);
	}

	/**
	 * Constructs an obstacle
	 * @param pImage - image 
	 * @param x - x-coordinate 
	 * @param y - y-coordinate 
	 * @param s - speed
	 * @param sizeX
	 * @param sizeY
	 */
	public Obstacle(PImage pImage, int x, int y, double s, int sizeX, int sizeY) {
		// TODO Auto-generated constructor stub
		super(pImage, x, y, s, sizeX, sizeY);
	}


	/**
	 * Bounces the character back from the obstacle
	 * @param p - Player
	 */
	public void moveBack(Player p) {
		p.moveByAmount(-20, 0);
	}
	
}
