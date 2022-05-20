package Obstacle;

import java.awt.Rectangle;

import core.DrawingSurface;
import processing.core.PImage;

public class Element {

	/**
	 * The coordinates of the element
	 */
	private double x, y;
	
	/**
	 * The rectangle bounds of the element
	 */
	private Rectangle r;
	
	/**
	 * The element's speed
	 */
	private double speed;
	
	/**
	 * The element's image
	 */
	private String image;
	private int width, height;
	private PImage im;

	/**
	 * Contructs a game element
	 */
	public Element() {
		
	}
	
	/**
	 * Contructs a game element
	 */
	public Element(String i, double s) {
		image = i;
		speed = -s;
	}
	
	/**
	 * Contructs a game element
	 */
	public Element(String i, double x, double y, double s) {
		this.x = x;
		this.y = y;
		speed = -s;
		image = i;
		width = 64; 
		height = 64;
	}
	
	public Element(String i, double x, double y, double s, int xsize, int ysize) {
		this.x = x;
		this.y = y;
		speed = -s;
		image = i;
		width = xsize;
		height = ysize;
	}
	
	public Element(PImage p, double x, double y, double s, int xsize, int ysize) {
		this.x = x;
		this.y = y;
		speed = -s;
		im = p;
		width = xsize;
		height = ysize;
	}
	
	/**
	 * Resizes the bounds of the game element
	 * @param x - the x of the bounds
	 * @param y - the y of the bounds
	 * @param width - the new width of the bounds
	 * @param height - the new height of the element
	 */
	public void resizeBounds(int x, int y, int width, int height)
	{
		this.width = width;
		this.height = height;
	}

	/**
	 * Gets the rectangle bounds of the element
	 * @return the rectangle that represents the bounds
	 */
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int) y, width, height);
	}
	
	
	/**
	 * Gets the x of the element
	 * @return x - the x position of the element
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Gets the y of the element
	 * @return y - the y position of the element
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Gets the speed of the element
	 * @return speed - the magntiude of the speed
	 */
	public double getSpeed() {
		return -speed;
	}
	
	/**
	 * Moves the element by the amount specified
	 * @param y - how much the element vertically moves
	 * @param x - how much the element horizontally moves
	 */
	public void moveByAmount(double x, double y) {
		this.x += x;
		this.y += y;
	}
	
	/**
	 * Moves the element by the speed
	 */
	public void move() {
		this.x += speed;
	}
	
	/**
	 * Checks whether the element collides with another rectangle bounds
	 * @param r - the rectangle bounds of another game element
	 */
	public boolean collide(Rectangle r) {
		if(getBounds().intersects(r)) {
			return true;
		} else {
			return false; 
		}
	}
	
	/**
	 * Draws the player on the screen
	 * @param s - the DrawingSurface
	 */
	public void draw(DrawingSurface s) {
		s.image(s.loadImage(image), (float)getX(), (float)getY(), width, height);

	}
	
	public String getImage() {
		return image;
	}
	
	/**
	 * Draws the player on the screen
	 * @param s - the DrawingSurface
	 */
	public void draw1(DrawingSurface s) {
		s.image(im, (float)getX(), (float)getY(), width, height);

	}

	
}
