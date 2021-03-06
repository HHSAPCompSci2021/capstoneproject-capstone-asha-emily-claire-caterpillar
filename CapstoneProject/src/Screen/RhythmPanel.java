package Screen;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Obstacle.Beat;
import core.DrawingSurface;
import processing.core.PImage;
/**
 * Represents a RhythmPanel to play the rhythm game
 * @author Claire and Emily
 */
public class RhythmPanel extends Screen{

	private ArrayList<Beat> e1;
	
	private ArrayList<Beat> e2;

	private ArrayList<Beat> e3;

	private ArrayList<Beat> e4;

	private DrawingSurface surface;
	
	private Beat up, down, left, right;
	
	private int totalCount;
	
	private boolean win;
	private PImage p, l, b;
	
	/**
	 * Constructs the rhythm panel
	 * @param width - the width of the screen
	 * @param height - the height of the screen
	 */
	public RhythmPanel(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructs the rhythm panel
	 * @param width - the width of the screen
	 * @param height - the height of the screen
	 */
	public RhythmPanel(DrawingSurface s) {
		super(800, 600);
		surface = s;
	}
	
	/**
	 * Set up the caterpillar panel
	 */
	public void setup() {
		p = surface.loadImage("img/Beat.png");
		l = surface.loadImage("img/Leaf.gif");
		b = surface.loadImage("img/rhythmBackground.jpg");
		e1 = new ArrayList<Beat>();
		e2 = new ArrayList<Beat>();
		e3 = new ArrayList<Beat>();
		e4 = new ArrayList<Beat>();
		up = new Beat("img/down.png", 318, 450, 0);
		down = new Beat("img/up.png", 426, 450, 0);
		left = new Beat("img/left.png", 216, 450, 0);
		right = new Beat("img/right.png", 528, 450, 0);
		totalCount = 0;
		win = false;
		addBeats();
		
		
	}
	
	/**
	 * Add all the beat objects needed in the rhythm game
	 */
	public void addBeats() {
		
		e1.add(new Beat(p, 318, 205, 10));
		e2.add(new Beat(p, 426, 205, 10));
		e3.add(new Beat(p, 216, 205, 10));
		e4.add(new Beat(p, 528, 205, 10));

		
		for(int i = 0; i < 54; i++) {
			e1.add(new Beat(p, 318, -64, 10));
			e2.add(new Beat(p, 426, -64, 10));
			e3.add(new Beat(p, 216, -64, 10));
			e4.add(new Beat(p, 528, -64, 10));

			
		}
		
		e1.add(new Beat(p, 318, -64, 10));
		e2.add(new Beat(p, 426, -64, 10));
		e3.add(new Beat(p, 216, -64, 10));
		e4.add(new Beat(p, 528, -64, 10, true));
		
//		e1.add(new Beat("img/Beat.png", 300, 0, 10, 64, 200));
//		e2.add(new Beat("img/Beat.png", 400, 0, 10, 64, 200));
//		e3.add(new Beat("img/Beat.png", 200, 0, 10, 64, 200));
//		e4.add(new Beat("img/Beat.png", 500, 0, 10, 64, 200));
		
		int[] j = {1,2,3, 4, 5, 7,8,9,10,11,13,14,15,16,17,19,20,21,24,25,26,28,29,31,32,33,34,35,36,37,38,40,41,42,43,44,45,49,50,51,52,53,54,55,56};
		int[] j1 = {0,2,3,4,6,8,9,10,12,14,15,17,18,29,22,23,24,25,27,28,29,30,31,32,35,36,37,39,42,43,44,46,50,51,52,53,54,55,56};
		int[] j2 = {0,1,3,5,6,7,9,11,12,13,16,18,21,22,23,24,25,26,27,29,30,31,32,33,34,38,39,40,41,42,43,45,46,47,48,49,53,54,55,56,52};
		int[] j3 = {0,1,2,4,5,6,7,8,10,11,12,13,14,16,17,19,20,21,22,23,26,27,30,32,33,34,35,36,37,38,39,40,41,44,45,46,47,48,49,50,51};
		
		for(int i = 0; i < e3.size(); i++) {
			for(int m : j) {
				if(i == m) {
					e3.get(i).setPImage(l);
				}
			}
		}
		
		for(int i = 0; i < e1.size(); i++) {
			for(int m : j1) {
				if(i == m) {
					e1.get(i).setPImage(l);
				}
			}
		}
		
		for(int i = 0; i < e2.size(); i++) {
			for(int m : j2) {
				if(i == m) {
					e2.get(i).setPImage(l);
				}
			}
		}
		
		for(int i = 0; i < e4.size(); i++) {
			for(int m : j3) {
				if(i == m) {
					e4.get(i).setPImage(l);
				}
			}
		}
		
		
	}
	
	/**
	 * moves the beat objects of a column
	 * @param obs - the array list of beats of a column 
	 */
	public void move(ArrayList<Beat> obs) {
			double speed = 11;
			int dist = 0;
			
			
			int i = 0;
			
			
			boolean o = true;
			while(o && i < obs.size()) {
				

				
				if(i == 20 || i == 22) {
					obs.get(i).setView(false);
				}
				
		
				if(i == 15 || i == 20 ||   i == 24 || i == 25 || i == 26 || i == 29 || i == 35 || i == 40 || i == 47 || i == 51){
					dist = 100;
				} else if (i == 52 ||  i == 53 || i == 54 || i == 55) {
					dist = 50;
				} else {
					dist = 250;
				}
				
				o = false;
				if(obs.get(i).getPImage().equals(p) && obs.get(i).getView())
					obs.get(i).draw1(surface);
				obs.get(i).moveByAmount(0, speed);
				
				if(obs.get(i).getY() > dist && obs.size() > 1) {
					//obs.remove(0);
					o = true;
					i++;
				}
			
		}	
			
	}
	
	/**
	 * Draws the screen
	 */
	public void draw() {
		
		
		//surface.background(255,255,255);
		//surface.fill(0);
		surface.image(b, 0, 0, 800, 600);
		
//		up.draw(surface);
//		down.draw(surface);
//		right.draw(surface);
//		left.draw(surface);
		
		for(Beat e: e1) {
			if (surface.isPressed(KeyEvent.VK_DOWN) && e.collide(up.getBounds())) {
				e.setView(false);
				totalCount++;
			}
			
			if(e.getY() > 664) {
				e.setView(false);
			}
		}
		
		for(Beat e: e2) {
			if (surface.isPressed(KeyEvent.VK_UP) && e.collide(down.getBounds())) {
				e.setView(false);
				totalCount++;

			}
			
			if(e.getY() > 664) {
				e.setView(false);	
			}
		}
		
		for(Beat e: e3) {
			if (surface.isPressed(KeyEvent.VK_LEFT) && e.collide(left.getBounds())) {
				e.setView(false);
				totalCount++;
			}
			
			if(e.getY() > 664) {
				e.setView(false);
			}	
		}
		
		for(Beat e: e4) {
			if (surface.isPressed(KeyEvent.VK_RIGHT) && e.collide(right.getBounds())) {
				e.setView(false);
				totalCount++;
				if(e.getLast())
				{
					System.out.println("collide");
					win = true;
				}

			}
			
			if(e.getY() > 664) {
				e.setView(false);
				if(e.getLast())
				{
					System.out.println("out");
					win = true;
				}
			}
		}
		
		

		
		move(e1);
		move(e2);
		move(e3);
		move(e4);
		
		
		if(totalCount > 200 && win) {
			nextScreen();
		} else if(totalCount <= 200 && win) {
			System.out.println(win);
			System.out.println(totalCount);
			totalCount = 0;
			win = false;
			resetScreen();
		}

	}
	
	/**
	 * Clears the screen and restarts the phase
	 */
	public void resetScreen() {
	
		surface.reset("r");
		surface.switchScreen(10);

	}

	/**
	 * Transitions to the next panel
	 */
	public void nextScreen() {
		surface.switchScreen(11);
	}

}
