package Screen;

import java.awt.Point;
import java.awt.Rectangle;

//import asha.shapes.Rectangle;
import core.DrawingSurface;

import java.awt.MouseInfo;
//import java.awt.Point;
import java.awt.event.KeyEvent;
import processing.core.PApplet;
import asha.shapes.Circle;
import processing.*;
import core.DrawingSurface;
import processing.core.PApplet;
/**
 * Represents the instructors for the game
 * @author Asha
 */
public class InstructionsPanel extends Screen{
	
	private DrawingSurface surface;
	private String phaseType;
	private Rectangle button;
	private int nextScreen;
	/**
	 * Constructs an instructions panel
	 * @param drawer - the DrawingSurface
	 * @param phaseType - What phase the panel is located in 
	 */
	public InstructionsPanel(DrawingSurface drawer, String phaseType) {
		super(800, 600);
		this.surface = drawer;
		this.phaseType = phaseType;
		button = new Rectangle(41, 39,143,45);
		nextScreen = 0;
	}
	/**
	 * Draws the panel
	 */
	public void draw() {
		surface.background(255,255,255);
		surface.image(surface.loadImage("img/iBackground.gif"), 0, 0, 800, 600);
		surface.fill(255);
		surface.textSize(17);
		if(phaseType.equals("eggPhase")) {
			nextScreen = 0;
			surface.text("You're a butterfly ready to embark on a new adventure to discover yourself and the world \naround you. "
					+ "\nYou want nothing more than to spread your wings and soar along the clouds. "
					+ "\nAs a butterfly, the world is a dangerous place for you, but you have a dream to explore \nas much of it as possible. "
					+ "\nIn this side-scrolling runner game, you will be dropped into this deadly, but exciting \nworld as an egg, but will slowly grow "
					+ "\novertime into a caterpillar, a pupa, and eventually a butterfly. Before you start, "
					+ "\nyou’ll get the opportunity to choose what kind of butterfly you’ll end up being. "
					+ "\n\n"
					+ "\nClick anywhere on the screen to cycle through designs."
					+ "\nPress the spacebar when you are ready to start."
					+ "\nClick on the start button when you are ready to start the next phase.",40, 150);
		} else if(phaseType.equals("caterpillarPhase")) {
			nextScreen = 3;
			surface.text("Congrats! You are now a caterpillar! "
					+ "\nUse the up and down arrows keys to jump and dive. "
					+ "\nMake sure to collect leaves to progress through the game. They provide energy that will \nkeep you alive."
					+ "\nIf you crash into an obstacle 3 times, you will unfortunaly have to start your journey over \nagain."
					+ "\nThe same occurs when you run into just one predator."
					+ "\nGood luck!", 40, 130);
		} else if(phaseType.equals("butterflyPhase")){
			nextScreen = 11;
			surface.text("Yay! You are now a butterfly!"
					+ "\nUse the space bar to avoid obstacles/predators."
					+ "\nIf you crash into an obstacle 3 times, you will unfortunaly have to start your journey over \nagain."
					+ "\nThe same occurs when you run into just one predator."
					+ "\nTo win the game, collect pink flowers."
					+ "\nGood luck!", 40, 130);
		} else if(phaseType.equals("rhythmPhase")){
			nextScreen = 7;
			surface.text("Now you are transforming into a butterfly!"
					+ "\nYour stuck inside a chrysalis."
					+ "\nPass the time by pressing the corresponding arrow keys when a bubble aligns \nwith the arrows."
					+ "\nGet enough right and you can become a butterfly!"
					+ "\nGood luck!", 40, 130);
		}
		
		surface.fill(255);
		//surface.rect(button.x, button.y, button.width, button.height);
		surface.fill(0);
		String str = "Back To Start";
		float w = surface.textWidth(str);
		//surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2);
	}
			
	/**
	 * Checks if the mouse presses the start button. If so, the screen changes.
	 */
	public void mousePressed() {
	Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY));
    if(button.contains(p)) {
    	setCurrScreen(false);
    	surface.switchScreen(nextScreen);
    }

	
}

}
