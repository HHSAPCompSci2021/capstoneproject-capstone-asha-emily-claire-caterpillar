package Obstacle;

import processing.core.PApplet;
import processing.core.PImage;

public class Gif {
	private PImage[] image; 
	private String name;
	private int frames;
	private double x, y;
	private int width, height;
	private PApplet surface; 
	
	
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
	
	public void setup()
	{
		surface.size(width, height);
		surface.smooth();
		for(int i = 0; i < frames; i++)
		{
			image[i] = surface.loadImage(name+i+".gif");
		}
	}
	
	public void draw()
	{
		surface.image(image[surface.frameCount%frames], (float)x, (float)y);
	}
	
	public void setX(double newX) {
		x = newX;
	}
	
	public void setY(double newY) {
		y = newY;
	}
}
