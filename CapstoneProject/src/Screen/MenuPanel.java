package Screen;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import processing.core.PApplet;
import asha.shapes.Circle;
import processing.*;
import core.DrawingSurface;
import processing.core.PApplet;
//import screens.ScreenSwitcher;
/**
 * The screen showing instructions before the game starts
 * @author Asha
 *
 */
public class MenuPanel extends Screen {
	private Rectangle button;
	private DrawingSurface surface;
	private boolean startGame;
	private String phaseType;
	private int nextScreen;
	/**
	 * Constructs a menu panel window with the purpose of showing instructions and starting the game
	 * @precondition phaseType is either eggPhase, caterpillarPhase, butterflyPhase, or endPhase
	 * @param drawer - the drawing surface 
	 */
	public MenuPanel(DrawingSurface drawer, String phaseType) {
		//Need to add width and height to super
		super(800,600);
		
		this.surface = drawer;
		this.phaseType = phaseType;
		startGame = false;
		
		if(phaseType.equals("eggPhase")) {
			nextScreen = 1;
		} else if(phaseType.equals("caterpillarPhase")) {
			nextScreen = 3;
		} else if(phaseType.equals("butterflyPhase")) {
			nextScreen = 5;
		} 

		button = new Rectangle(800/2-100,600/2-50,200,100);
	}
	
	
	//edited by Emily 5/5
	/**
	 * Draws the surface
	 * @param drawer 
	 */
	public void draw() {
		surface.background(255,255,255);
		surface.image(surface.loadImage("img/menupanelBackground.gif"), 0, 0, 800, 600);
		
		surface.fill(255);
		if(phaseType.equals("eggPhase")) {
		
			surface.text("You're a butterfly ready to embark on a new adventure to discover yourself and the world around you. "
					+ "\nYou want nothing more than to spread your wings and soar along the clouds. "
					+ "\nAs a butterfly, the world is a dangerous place for you, but you have a dream to explore as much of it as possible. "
					+ "\nIn this side-scrolling runner game, you will be dropped into this deadly, but exciting world as an egg, but will slowly grow "
					+ "\novertime into a caterpillar, a pupa, and eventually a butterfly. Before you start, "
					+ "\nyou’ll get the opportunity to choose what kind of butterfly you’ll end up being. "
					+ "\nTo live out your dream you will have to avoid all potential enemies and obstacles and consume enough food. "
					+ "\nIf you run into an obstacle or enemy or don’t eat enough, you will die. "
					+ "\nThis isn’t the end of the world as you’ll reset back to the start of the section you perished in. "
					+ "\nOur primary goal in writing this program is to create a fun and interesting game that people will be able to enjoy "
					+ "\nwhile learning more about the life cycle of butterflies. The primary feature of our program is the main side scroll"
					+ " \nesque game with a character selection feature at the start. "
					+ "\nThe game will include the different phases which will change the style of the game. "
					+ "\nOur primary user base would be people who enjoy games.  ",20, 20);
			
			surface.fill(255);
			surface.rect(button.x, button.y, button.width, button.height);
			surface.fill(0);
			String str = "Start!";
			float w = surface.textWidth(str);
			surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2);
			
		} else if(phaseType.equals("caterpillarPhase")) {
			surface.text("Congrats! You are now a caterpillar! "
					+ "\nUse the up and down arrows keys to toggle between movements. "
					+ "\nMake sure to collect leaves to progress through the game. They provide energy that will keep you alive."
					+ "\nIf you crash into an obstacle 3 times, you will unfortunately have to start your journey over again."
					+ "\nThe same occurs when you run into a predator."
					+ "\nGood luck!", 20, 20);
			surface.fill(255);
			surface.rect(button.x, button.y, button.width, button.height);
			surface.fill(0);
			String str = "Start!";
			float w = surface.textWidth(str);
			surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2);
		} else if(phaseType.equals("butterflyPhase")) {
			surface.text("Yay! You are now a butterfly!"
					+ "\nUse the arrow keys to avoid obstacles/predators and to collect flowers."
					+ "\nEventually, the game will end and you will have reached your destination."
					+ "\nPress esc to exit out of the screen", 20, 20);
			surface.fill(255);
			surface.rect(button.x, button.y, button.width, button.height);
			surface.fill(0);
			String str = "Start!";
			float w = surface.textWidth(str);
			surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2);
		} else {
			surface.text("Congrats!"
					+ "\nYou have completed your journey as a butterfly"
					+ "\nFeel free to play again", 20, 20);
		}
		
		
	}
	
	/**
	 * Checks if a key is pressed and acts accordingly
	 */
	public void keyPressed() {
		
	}
	
	//edited by Emily 5/10
	/**
	 * Checks if the mouse presses the start button. If so, the screen changes.
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY));
        if(button.contains(p)) {
       
        	surface.switchScreen(nextScreen);
        }
	
		
	}
	
}
