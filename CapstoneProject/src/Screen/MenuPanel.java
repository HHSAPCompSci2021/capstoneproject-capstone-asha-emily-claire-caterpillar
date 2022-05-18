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
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
//import javazoom.jl.player.Player;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.player.Player;

import Sound.SoundJLayer;



  

//import screens.ScreenSwitcher;
/**
 * The screen showing instructions before the game starts
 * @author Asha
 *
 */
public class MenuPanel extends Screen {
	private Rectangle button;
	private DrawingSurface surface;
	private String phaseType;
	private int nextScreen;
	private int instructionsScreen;
	private Rectangle instructionsButton;
	
	
	
	/**
	 * Constructs a menu panel window with the purpose of showing instructions and starting the game
	 * @precondition phaseType is either eggPhase, caterpillarPhase, or butterflyPhase
	 * @param drawer - the drawing surface 
	 */
	public MenuPanel(DrawingSurface drawer, String phaseType) {
		//Need to add width and height to super
		super(800,600);
		
		this.surface = drawer;
		this.phaseType = phaseType;
		nextScreen = 1;
	
		button = new Rectangle(800/2-100,600/2-45,210,40);
		instructionsButton = new Rectangle(800/2-120,315,235,40);
		instructionsScreen = 1;
		
	}
	
	
	//edited by Emily 5/5
	/**
	 * Draws the surface
	 * @param drawer 
	 */
	public void draw() {
		
		System.out.println(nextScreen);
		
		setCurrScreen(true);
		
		surface.background(255,255,255);
		surface.image(surface.loadImage("img/fMenuPanel.gif"), 0, 0, 800, 600);
		surface.fill(255);
		
		if(phaseType.equals("eggPhase")) {
			nextScreen = 2;
			instructionsScreen = 1;
		} else if(phaseType.equals("caterpillarPhase")) {
			nextScreen = 5;
			instructionsScreen = 4;
		} else if(phaseType.equals("butterflyPhase")){
			nextScreen = 9;
			instructionsScreen = 8;

		}
		
//		surface.fill(255);
//		surface.rect(instructionsButton.x, instructionsButton.y, instructionsButton.width, instructionsButton.height);
//		surface.fill(0);
//		String str = "Start!";
//		float w = surface.textWidth(str);
//		surface.text(str, instructionsButton.x+instructionsButton.width/2-w/2, instructionsButton.y+instructionsButton.height/2);
	}
			

    
	
	//edited by Emily 5/10
	/**
	 * Checks if the mouse presses the start button. If so, the screen changes.
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY));
        if(button.contains(p)) {
        	setCurrScreen(false);
        	surface.switchScreen(nextScreen);
        }
        
        if(instructionsButton.contains(p)) {
        	setCurrScreen(false);
        	surface.switchScreen(instructionsScreen);
        }
	
		
	}


	
	
}
