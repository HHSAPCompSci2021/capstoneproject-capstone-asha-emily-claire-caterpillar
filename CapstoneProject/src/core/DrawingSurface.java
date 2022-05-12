package core;
import java.applet.Applet;
import java.awt.Point;
import java.util.ArrayList;

import Screen.ButterflyPanel;
import Screen.CaterpillarPanel;
import Screen.EggPanel;
import Screen.MenuPanel;
import Screen.Screen;
import processing.core.PApplet;
/**
 * 
 * @author Emily
 * Creates a surface that holds all the panels (different phases).
 * These are represented by different screens
 *
 */
public class DrawingSurface extends PApplet{
	private ArrayList<Screen> screens;
	private Screen currScreen; 
	public float ratioX, ratioY;
	private ArrayList<Integer> keys;
	
	/**
	 * Creates a DrawingSurface that displays all the screens
	 */
	/* 
	 * 0 = menu
	 * 1 = egg
	 * 2 = caterpillar
	 * 3 = butterfly
	 */
	public DrawingSurface() {
		screens = new ArrayList<Screen>();
		keys = new ArrayList<Integer>();
		
		MenuPanel menu = new MenuPanel(this);
		screens.add(menu);
		
		EggPanel egg = new EggPanel(this);
		screens.add(egg);
		
		CaterpillarPanel cater = new CaterpillarPanel(this);
		screens.add(cater);
		
		ButterflyPanel butter = new ButterflyPanel(this);
		screens.add(butter);
		
		currScreen = screens.get(0);
		
	}
	/**
	 * Provides the basis for setup of the program
	 */
	public void setup() {
		for (Screen s : screens)
			s.setup();
	}
	
	/**
	 * Draws the screen
	 */
	public void draw() {
		ratioX = (float)width/currScreen.DRAWING_WIDTH;
		ratioY = (float)height/currScreen.DRAWING_HEIGHT;

		push();
		scale(ratioX, ratioY);
		currScreen.draw();
		pop();
	}
	
	/**
	 * Checks if a key is pressed
	 */
	public void keyPressed() {
		keys.add(keyCode);
		if (key == ESC) 
			key = 0;
	}
	
	/**
	 * Checks if a key is released
	 */
	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}
	
	/**
	 * Checks if a key is pressed
	 * @param code - the key code
	 * @return boolean - if the key is pressed or not
	 */
	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	
	/**
	 * Checks if the mouse is pressed
	 */
	public void mousePressed() {
		currScreen.mousePressed();
	}
	
	/**
	 * Checks if the mouse is released
	 */
	public void mouseReleased() {
		currScreen.mouseReleased();
	}
	
	/**
	 * Get the actual point at an assumed coordinate based on the ratio of the screen
	 * @param assumed - the assumed point at the coordinates
	 * @return Point - the actual point at the coordinates in ratio to the screen
	 */
	public Point assumedCoordinatesToActual(Point assumed) {
		return new Point((int)(assumed.getX()*ratioX), (int)(assumed.getY()*ratioY));
	}

	/**
	 * Get the assumed point at an actual coordinate based on the ratio of the screen
	 * @param actual - the actual point at the coordinates
	 * @return Point - the assumed point at the coordinates in ratio to the screen
	 */
	public Point actualCoordinatesToAssumed(Point actual) {
		return new Point((int)(actual.getX()/ratioX) , (int)(actual.getY()/ratioY));
	}
	
	/**
	 * Switches to a different screen, progresses the game
	 * @param i - the screen index to switch too
	 */
	public void switchScreen(int i) {
		currScreen = screens.get(i);
	}
	
	/**
	 * Getter method for design
	 * @return name of the design file
	 */
	public String getDesign() {
		EggPanel panel = (EggPanel)screens.get(1);
		return panel.selectDesign();
	}

}
