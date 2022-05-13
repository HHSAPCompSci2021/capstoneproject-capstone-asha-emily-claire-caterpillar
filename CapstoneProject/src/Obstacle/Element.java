package Obstacle;

import asha.shapes.Rectangle;
import core.DrawingSurface;

public class Element {

	private double x, y;
	private Rectangle r;
	private double speed;
	private String image;
	
	public Element() {
		
	}
	
	public Element(String i, double s) {
		image = i;
		speed = -s;
	}
	
	public Element(String i, double x, double y, double s) {
		this.x = x;
		this.y = y;
		speed = -s;
		image = i;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 64, 64);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getSpeed() {
		return -speed;
	}
	
	public void moveByAmount(double x, double y) {
		this.x += x;
		this.y += y;
	}
	
	public void move() {
		this.x += speed;
	}
	
	public boolean collide(Rectangle r) {
		if(getBounds().intersects(r)) {
			return true;
		} else {
			return false; 
		}
	}
	
	public void draw(DrawingSurface s) {
		s.image(s.loadImage(image), (float)getX(), (float)getY(), 64, 64);

	}

	
}
