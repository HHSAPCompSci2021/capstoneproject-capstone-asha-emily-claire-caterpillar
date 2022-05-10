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
	/**
	 * Constructs a menu panel window with the purpose of showing instructions and starting the game
	 * @param drawer - the drawing surface 
	 */
	public MenuPanel(DrawingSurface drawer) {
		//Need to add width and height to super
		super(800,600);
		
		this.surface = drawer;
		startGame = false;

		button = new Rectangle(800/2-100,600/2-50,200,100);
	}
	
	
	//edited by Emily 5/5
	/**
	 * Draws the surface
	 * @param drawer 
	 */
	public void draw() {
		surface.background(255,255,255);
		surface.fill(0);
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
		surface.fill(102, 255, 178);
		String str = "Start Game!";
		float w = surface.textWidth(str);
		surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2);
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
        	surface.switchScreen(1);
        }
	
		
	}
	
}
