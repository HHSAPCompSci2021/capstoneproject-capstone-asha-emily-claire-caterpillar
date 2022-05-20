package Obstacle;

import processing.core.PApplet;
import processing.core.PImage;
/**
 * Represents displaying a gif file
 * @author Emily
 *
 */
public class Gif {
	private PImage[] image; 
	private String name;
	private int frames;
	private double x, y;
	private int width, height;
	private PApplet surface; 
	
	/**
	 * Constructs a Gif
	 * @param s - PApplet 
	 * @param n - file name/location
	 * @param f - amount of frames
	 * @param x - x-coordinate of the gif
	 * @param y - y-coordinate of the gif
	 * @param w - width of the gif
	 * @param h - height of the gif
	 */
	public Gif(PApplet s, String n, int f, double x, double y, int w, int h) {
		surface = s;
		image = new PImage[frames];
		name = n;
		frames = f;
		this.x = x;
		this.y = y;
		width = w;
		height = h; 
	}
	
	/**
	 * Sets up the screen
	 */
	public void setup()
	{
		surface.size(width, height);
		surface.smooth();
		for(int i = 0; i < frames; i++)
		{
			image[i] = surface.loadImage(name+i+".gif");
		}
	}
	/**
	 * Draws the image
	 */
	public void draw()
	{
		surface.image(image[surface.frameCount%frames], (float)x, (float)y);
	}
	
	/**
	 * Setter method for x
	 * @param newX - new x-coordinate
	 */
	public void setX(double newX) {
		x = newX;
	}
	/**
	 * Setter method for y
	 * @param newY - new y-coordinate
	 */
	public void setY(double newY) {
		y = newY;
	}
}
