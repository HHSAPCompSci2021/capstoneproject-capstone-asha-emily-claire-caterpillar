package Obstacle;

import processing.core.PImage;

public class Beat extends Element{

	private boolean view;
	private boolean last; 
	
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
	
	public Beat(String i, double x, double y, double s, int w, int l) {
		super(i, x, y, s, w, l);
	}

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
	
	public boolean getView() {
		return view;
	}
	
	public void setView(boolean v) {
		view = v;
	}
	
	public boolean getLast() {
		return last;
	}
}
