package Obstacle;

import java.awt.Rectangle;

public class Element {

	private double x, y;
	private Rectangle r;
	private double speed;
	private String image;
	
	public Element(String i, double s) {
		image = i;
		speed = s;
	}
	
	public Element(String i, double x, double y, double s) {
		this.x = x;
		this.y = y;
		speed = s;
		image = i;
	}
	
	public Rectangle getBounds() {
		
		return null;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public Rectangle getRect() {
		return r;
	}
	
	public void moveByAmount(double x, double y) {
		this.x += x;
		this.y += y;
	}

	
}
