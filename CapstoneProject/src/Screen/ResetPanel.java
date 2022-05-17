package Screen;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import processing.core.PApplet;
import processing.core.PImage;
import asha.shapes.Circle;
import processing.*;
import core.DrawingSurface;
import processing.core.PApplet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
//import javazoom.jl.player.Player;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Obstacle.Gif;
import Player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Represents a ResetPanel - the GUI for resetting a phase or quitting the game
 * @author Asha
 *
 */
public class ResetPanel extends Screen{
	
	//Links to prev menupanel
	private Rectangle retryButton;
	//Links to Start menupanel
	private Rectangle quitGameButton;
	private DrawingSurface surface;
	private int nextScreen;
	private Player player;
	/**
	 * Constructs a reset panel window with the purpose retrying a phase or exiting the game
	 * @precondition nextScreen represents an actual screen for the program to switch to
	 * @param drawer - the drawing surface 
	 * @param nextScreen - the nextScreen to go to if the user wants to retry
	 */
	public ResetPanel(DrawingSurface drawer, int nextScreen) {
		super(800, 600);
		this.surface = drawer;
		this.nextScreen = nextScreen;
		retryButton = new Rectangle(200, 100, 400, 100);
		quitGameButton = new Rectangle(200, 300, 400, 100);
		player = null;
	}
	
	public ResetPanel(DrawingSurface drawer, int nextScreen, Player player) {
		super(800, 600);
		this.surface = drawer;
		this.nextScreen = nextScreen;
		retryButton = new Rectangle(200, 100, 400, 100);
		quitGameButton = new Rectangle(200, 300, 400, 100);
		this.player = player;
	}
	
	/**
	 * Draws the buttons needed to restart the game
	 */
	public void draw() {
		surface.background(255,255,255);
		
//		Gif backgroundImg = new Gif(new PApplet(), "img/background2.gif", 15, 0, 0, 800, 600);
//		
//		backgroundImg.draw();
		
		surface.image(surface.loadImage("img/background2.gif"), 0, 0, 800, 600);
		
		surface.fill(255);
		//Retry Button
		surface.rect(retryButton.x, retryButton.y, retryButton.width, retryButton.height);
		surface.fill(0);
		String str = "Retry";
		float w = surface.textWidth(str);
		surface.text(str, retryButton.x+retryButton.width/2-w/2, retryButton.y+retryButton.height/2);
	
		//Stats (only if there's a recent player)
		if(player != null) {
			surface.text("Total Collectibles: " + player.getNumCollectible(), 200, 200);
		}
		
		
		
		//Quit Button
		surface.fill(255);
		surface.rect(quitGameButton.x, quitGameButton.y, quitGameButton.width, quitGameButton.height);
		surface.fill(0);
		String str2 = "Quit";
		float w2 = surface.textWidth(str2);
		surface.text(str2, quitGameButton.x+quitGameButton.width/2-w2/2, quitGameButton.y+quitGameButton.height/2);
		
	}
	
	/**
	 * Checks if the mouse presses a button. If so, the screen changes. 
	 */
	public void mousePressed() {
		
		
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY));
        if(retryButton.contains(p)) {
        	surface.switchScreen(nextScreen);
        } 
        
        if(quitGameButton.contains(p)) {
        	System.exit(0);
        }
	
		
	}
	
	

}
