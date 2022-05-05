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
		super();
		
		this.surface = drawer;
		startGame = false;

		button = new Rectangle(800/2-100,600/2-50,200,100);
	}
	
	
	
	/**
	 * Draws the surface
	 * @param drawer 
	 */
	public void draw(PApplet drawer) {
		surface.background(255,255,255);
		surface.text("You're a butterfly ready to embark on a new adventure to discover yourself and the world around you. "
				+ "You want nothing more than to spread your wings and soar along the clouds. "
				+ "As a butterfly, the world is a dangerous place for you, but you have a dream to explore as much of it as possible. "
				+ "In this side-scrolling runner game, you will be dropped into this deadly, but exciting world as an egg, but will slowly grow "
				+ "overtime into a caterpillar, a pupa, and eventually a butterfly. Before you start, "
				+ "you’ll get the opportunity to choose what kind of butterfly you’ll end up being. "
				+ "To live out your dream you will have to avoid all potential enemies and obstacles and consume enough food. "
				+ "If you run into an obstacle or enemy or don’t eat enough, you will die. "
				+ "This isn’t the end of the world as you’ll reset back to the start of the section you perished in. "
				+ "Our primary goal in writing this program is to create a fun and interesting game that people will be able to enjoy "
				+ "while learning more about the life cycle of butterflies. The primary feature of our program is the main side scroll"
				+ " esque game with a character selection feature at the start. "
				+ "The game will include the different phases which will change the style of the game. "
				+ "Our primary user base would be people who enjoy games.  ", 100, 100);
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
	
	/**
	 * Checks if the mouse presses the start button. If so, the screen changes.
	 */
	public void mousePressed() {
		double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
        double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
		
        if(button.contains(new Point((int) mouseX, (int) mouseY))) {
        	startGame = true;
        }
	
		
	}
	
}
