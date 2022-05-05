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

public class DrawingSurface extends PApplet{
	private ArrayList<Screen> screens;
	private Screen currScreen; 
	public float ratioX, ratioY;
	private ArrayList<Integer> keys;
	
	public DrawingSurface() {
		screens = new ArrayList<Screen>();
		
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
	
	public void setup() {
		for (Screen s : screens)
			s.setup();
	}
	
	public void draw() {
		ratioX = (float)width/currScreen.DRAWING_WIDTH;
		ratioY = (float)height/currScreen.DRAWING_HEIGHT;

		push();
		
		scale(ratioX, ratioY);
		
		currScreen.draw();
		
		pop();
	}
	
	public void keyPressed() {
		keys.add(keyCode);
		if (key == ESC)  // This prevents a processing program from closing on escape key
			key = 0;
	}

	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	
	public void mousePressed() {
		currScreen.mousePressed();
	}
	
	public void mouseReleased() {
		currScreen.mouseReleased();
	}
	
	public void switchScreen(int i) {
		currScreen = screens.get(i);
	}
}
