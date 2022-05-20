package Screen;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Obstacle.Beat;
import core.DrawingSurface;

public class RhythmPanel extends Screen{

	private ArrayList<Beat> e1;
	
	private ArrayList<Beat> e2;

	private ArrayList<Beat> e3;

	private ArrayList<Beat> e4;

	private DrawingSurface surface;
	
	private Beat up, down, left, right;
	
	
	public RhythmPanel(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	public RhythmPanel(DrawingSurface s) {
		super(800, 600);
		surface = s;
	}
	
	public void setup() {
		e1 = new ArrayList<Beat>();
		e2 = new ArrayList<Beat>();
		e3 = new ArrayList<Beat>();
		e4 = new ArrayList<Beat>();
		up = new Beat("img/Kite.gif", 300, 450, 0);
		down = new Beat("img/Kite.gif", 400, 450, 0);
		left = new Beat("img/Kite.gif", 200, 450, 0);
		right = new Beat("img/Kite.gif", 500, 450, 0);


		addBeats();
	}
	
	public void addBeats() {
		
		e1.add(new Beat("img/Leaf.gif", 300, 35, 10));
		e2.add(new Beat("img/Leaf.gif", 400, 35, 10));
		e3.add(new Beat("img/Leaf.gif", 200, 35, 10));
		e4.add(new Beat("img/Leaf.gif", 500, 35, 10));

		
		for(int i = 0; i < 46         ; i++) {
			e1.add(new Beat("img/Flower.gif", 300, -64, 10));
			e2.add(new Beat("img/Flower.gif", 400, -64, 10));
			e3.add(new Beat("img/Flower.gif", 200, -64, 10));
			e4.add(new Beat("img/Flower.gif", 500, -64, 10));

			
		}
		
		e1.add(new Beat("img/Flower.gif", 300, 0, 10, 64, 200));
		e2.add(new Beat("img/Flower.gif", 400, 0, 10, 64, 200));
		e3.add(new Beat("img/Flower.gif", 200, 0, 10, 64, 200));
		e4.add(new Beat("img/Flower.gif", 500, 0, 10, 64, 200));
	
	}
	
	public void move(ArrayList<Beat> obs) {
			double speed = 10.5;
		
			int i = 0;
			if(i < 14) {
				speed = 10.5;
			}
	
			boolean o = true;
			while(o && i < obs.size()) {
				o = false;
				if(obs.get(i).getImage().equals("img/Flower.gif") && obs.get(i).getView())
					obs.get(i).draw(surface);
				obs.get(i).moveByAmount(0, speed);
				
				if(obs.get(i).getY() > 250 && obs.size() > 1) {
					//obs.remove(0);
					o = true;
					i++;
				}
			
		}	
	}
	
	
	public void draw() {
		surface.background(255,255,255);
		surface.fill(0);
 
		
		up.draw(surface);
		down.draw(surface);
		right.draw(surface);
		left.draw(surface);
		
		for(Beat e: e1) {
			if (surface.isPressed(KeyEvent.VK_UP) && e.collide(up.getBounds())) {
				e.setView(false);
				surface.text("YAY", 20, 20);
			}
			
			if(e.getY() > 664) {
				e.setView(false);
			}
		}
		
		for(Beat e: e2) {
			if (surface.isPressed(KeyEvent.VK_DOWN) && e.collide(down.getBounds())) {
				e.setView(false);
				surface.text("YAY", 20, 20);

			}
			
			if(e.getY() > 664) {
				e.setView(false);		
			}
		}
		
		for(Beat e: e3) {
			if (surface.isPressed(KeyEvent.VK_LEFT) && e.collide(left.getBounds())) {
				e.setView(false);
				surface.text("YAY", 20, 20);

			}
			
			if(e.getY() > 664) {
				e.setView(false);
			}	
		}
		
		for(Beat e: e4) {
			if (surface.isPressed(KeyEvent.VK_RIGHT) && e.collide(right.getBounds())) {
				e.setView(false);
				surface.text("YAY", 20, 20);

			}
			
			if(e.getY() > 664) {
				e.setView(false);
			}
		}
		
		

		
		
		move(e1);
		move(e2);
		move(e3);
		move(e4);
		
//		move(e1, 10.5, 12, 20);
//		move(e2, 10.5, 12, 20);
//		move(e3, 10.5, 12, 20);
//		move(e4, 10.5, 12, 20);
		
		
		
//		sideScrolling(e1.get(0));
//		sideScrolling(e2.get(0));
//		sideScrolling(e3.get(0));
//		sideScrolling(e4.get(0));

	}

}
