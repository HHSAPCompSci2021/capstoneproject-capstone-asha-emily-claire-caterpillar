package core;
import java.applet.Applet;
import java.awt.Point;
import java.util.ArrayList;

import Player.Egg;
import Player.Player;
import Screen.ButterflyPanel;
import Screen.CaterpillarPanel;
import Screen.EggPanel;
import Screen.EndPanel;
import Screen.InstructionsPanel;
import Screen.MenuPanel;
import Screen.ResetPanel;
import Screen.RhythmPanel;
import Screen.Screen;
import Sound.SoundJLayer;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * 
 * @author Emily
 * Creates a surface that holds all the panels (different phases).
 * These are represented by different screens
 */
public class DrawingSurface extends PApplet{
	private ArrayList<Screen> screens;
	private Screen currScreen; 
	public float ratioX, ratioY;
	private ArrayList<Integer> keys;
	private PImage p;
	private ArrayList<SoundJLayer> songs;
	private int callTime = 0;

	/**
	 * Creates a DrawingSurface that displays all the screens
	 */
	public DrawingSurface() {
		screens = new ArrayList<Screen>();
		keys = new ArrayList<Integer>();

		//Songs Added
		songs = new ArrayList<SoundJLayer>();
		songs.add(new SoundJLayer("audio/Menu Jazz.mp3"));
		songs.add(new SoundJLayer("audio/Menu Jazz.mp3"));
		songs.add(new SoundJLayer("audio/Game Jazz.mp3"));
		songs.add(new SoundJLayer("audio/Game Jazz.mp3"));
		songs.add(new SoundJLayer("audio/Rhythm.mp3"));

		//Screens
		//0
		MenuPanel menu = new MenuPanel(this, "eggPhase");
		screens.add(menu);

		//1
		InstructionsPanel insturctions1 = new InstructionsPanel(this, "eggPhase");
		screens.add(insturctions1);

		//2
		EggPanel egg = new EggPanel(this);
		screens.add(egg);

		//3
		MenuPanel menuE = new MenuPanel(this, "caterpillarPhase");
		screens.add(menuE);

		//4
		InstructionsPanel insturctions2 = new InstructionsPanel(this, "caterpillarPhase");
		screens.add(insturctions2);

		//5
		CaterpillarPanel cater = new CaterpillarPanel(this);
		screens.add(cater);

		//6
		ResetPanel resetPanel = new ResetPanel(this, 3);
		screens.add(resetPanel);

		//7
		MenuPanel menuC = new MenuPanel(this, "rhythmPhase");
		screens.add(menuC);

		//8
		InstructionsPanel insturctions4 = new InstructionsPanel(this, "rhythmPhase");
		screens.add(insturctions4);

		//9
		RhythmPanel r = new RhythmPanel(this);
		screens.add(r);

		//10
		ResetPanel resetPanel1 = new ResetPanel(this, 7);
		screens.add(resetPanel1);


		//11
		MenuPanel menuB = new MenuPanel(this, "butterflyPhase");
		screens.add(menuB);

		//12
		InstructionsPanel insturctions3 = new InstructionsPanel(this, "butterflyPhase");
		screens.add(insturctions3);

		//13
		ButterflyPanel butter = new ButterflyPanel(this);
		screens.add(butter);

		//14
		ResetPanel reset = new ResetPanel(this, 11);
		screens.add(reset);

		//15
		EndPanel end = new EndPanel(this);
		screens.add(end);
		//Game won panel



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

		if(currScreen instanceof MenuPanel || currScreen instanceof ResetPanel || currScreen instanceof InstructionsPanel || currScreen instanceof EndPanel) {
			if(callTime < 1) {
				songs.get(0).play();
				callTime++;
			}
		} else if(currScreen instanceof EggPanel) {

			if(callTime < 1) {
				songs.get(1).play();
				callTime++;
			}

		} else if(currScreen instanceof CaterpillarPanel) {

			if(callTime < 1) {
				songs.get(2).play();
				callTime++;
			}
		} else if(currScreen instanceof ButterflyPanel) {
			if(callTime < 1) {
				songs.get(3).play();
				callTime++;
			}
		} else if(currScreen instanceof RhythmPanel) {
			if(callTime < 1) {
				songs.get(4).play();
				callTime++;
			}
		}

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
	 * Switches to a different screen, progresses the game. Changes the music played
	 * @param i - the screen index to switch too
	 * @postcondition song played is changed/closes
	 */
	public void switchScreen(int i) {
		callTime = 0;

		//Closing all the songs
		if(currScreen instanceof MenuPanel || currScreen instanceof ResetPanel || currScreen instanceof InstructionsPanel || currScreen instanceof EndPanel) {
			songs.get(0).getAdvancedPlayer().close();	
		} else if(currScreen instanceof EggPanel) {
			songs.get(1).getAdvancedPlayer().close();	
		} else if(currScreen instanceof CaterpillarPanel) {
			songs.get(2).getAdvancedPlayer().close();
		} else if(currScreen instanceof ButterflyPanel) {
			songs.get(3).getAdvancedPlayer().close();

		} 

		currScreen = screens.get(i);
	}

	/**
	 * Getter method for design
	 * @return name of the design file
	 */
	public String getDesign() {
		EggPanel panel = (EggPanel)screens.get(2);
		System.out.print(panel.selectDesign());
		return panel.selectDesign();
		//return p;
	}

	/**
	 * Set a new screen for a panel 
	 * @param panel - name of the panel type
	 */
	public void reset(String panel) {
		if(panel.equals("c"))
		{
			CaterpillarPanel cater = new CaterpillarPanel(this);
			screens.set(5, cater);
			cater.setup();
		} else if(panel.equals("b"))
		{
			ButterflyPanel butter = new ButterflyPanel(this);
			screens.set(13, butter);
			butter.setup();
		} else {
			RhythmPanel r = new RhythmPanel(this);
			screens.set(9, r);
			r.setup();
		}
	}

}
