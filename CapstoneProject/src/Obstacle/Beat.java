package Obstacle;


import processing.core.PImage;

/**
 * Displays the Elements on the Screen with regard to the beat to the music
 * @author Claire
 *
 */
public class Beat extends Element{

	private boolean view;
	private boolean last; 
	
	/**
	 * Constructs a Beat object
	 * @param i - String of the image file name 
	 * @param x - x-coordinate
	 * @param y - y-coordinate
	 * @param s - speed 
	 */
	public Beat(String i, double x, double y, double s) {
		super(i,x,y,s);
		view = true;
		last = false;
		
	}
 

	public Beat(PImage p, double x, double y, double s) {
		super(p,x,y,s,64,64);
		view = true;
		last = false;
		
	}
	

	/**
	 * Constructs a Beat object
	 * @param i - String of the image file name 
	 * @param x - x-coordinate
	 * @param y - y-coordinate
	 * @param s - speed 
	 * @param w - width
	 * @param l - height 
	 */

	public Beat(String i, double x, double y, double s, int w, int l) {
		super(i, x, y, s, w, l);
	}
	
	/**
	 * Constructs a Beat object
	 * @param i - String of the image file name 
	 * @param x - x-coordinate
	 * @param y - y-coordinate
	 * @param s - speed 
	 * @param t - if it is the last image
	 */
	public Beat(String i, double x, double y, double s, boolean t) {
		super(i,x,y,s);
		view = true;
		last = t;
		
	}
	
	public Beat(PImage p, double x, double y, double s, boolean t) {
		super(p,x,y,s,64,64);
		view = true;
		last = t;
		
	}
	

	/**
	 * Returns of it should be seen
	 * @return view - if the boject should be seen
	 */
	public boolean getView() {
		return view;
	}
	
	/**
	 * Setter method for view 
	 * @param v - change to view
	 */
	public void setView(boolean v) {
		view = v;
	}
	
	/**
	 * Getter method for last
	 * @return last
	 */
	public boolean getLast() {
		return last;
	}
}
