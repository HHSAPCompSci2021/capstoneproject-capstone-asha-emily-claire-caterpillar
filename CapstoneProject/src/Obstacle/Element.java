package Obstacle;

import asha.shapes.Rectangle;
import core.DrawingSurface;

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
	}
	
	/**
	 * Gets the rectangle bounds of the element
	 * @return the rectangle that represents the bounds
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 64, 64);
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
		s.image(s.loadImage(image), (float)getX(), (float)getY(), 64, 64);

	}

	
}
