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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
//import javazoom.jl.player.Player;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;

public class ResetPanel extends Screen{
	
	//Links to prev menupanel
	private Rectangle retryButton;
	//Links to Start menupanel
	private Rectangle quitGameButton;
	private DrawingSurface surface;
	private String phaseType;
	private Player player;
	/**
	 * Constructs a menu panel window with the purpose of showing instructions and starting the game
	 * @precondition phaseType is either eggPhase, caterpillarPhase, or butterflyPhase
	 * @param drawer - the drawing surface 
	 */
	public ResetPanel(DrawingSurface drawer, String phaseType, Player player) {
		super(800, 600);
		this.surface = drawer;
		this.phaseType = phaseType;
		this.player = player;
		retryButton = new Rectangle(200, 200, 400, 200);
		quitGameButton = new Rectangle(200, 450, 400, 200);
	}
	
	/**
	 * Draws the buttons needed to restart the game
	 */
	public void draw() {
		surface.background(255,255,255);
		surface.fill(255);
		
		//Retry Button
		surface.rect(retryButton.x, retryButton.y, retryButton.width, retryButton.height);
		surface.fill(0);
		String str = "Retry";
		float w = surface.textWidth(str);
		surface.text(str, retryButton.x+retryButton.width/2-w/2, retryButton.y+retryButton.height/2);
		
		//Quit Button
		surface.rect(retryButton.x, retryButton.y, retryButton.width, retryButton.height);
		surface.fill(0);
		String str2 = "Quit";
		float w2 = surface.textWidth(str2);
		surface.text(str, retryButton.x+retryButton.width/2-w2/2, retryButton.y+retryButton.height/2);
		
	}
	
	/**
	 * Checks if the mouse presses a button. If so, the screen changes.
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY));
        if(retryButton.contains(p)) {
        	surface.switchScreen(1);
        }
	
		
	}
	
	

}
