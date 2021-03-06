package Screen;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Player.Player;
import processing.core.PApplet;
import asha.shapes.Circle;
import processing.*;
import core.DrawingSurface;
import processing.core.PApplet;
/**
 * Represents a Player's gameplay statistics
 * @author Asha
 *
 */
public class HealthBar {
	private ArrayList<Rectangle> hungerRect;
	private Player player;
	
	/**
	 * Creates a HealthBar
	 * @param player - player (Butterfly or Caterpillar)
	 */
	public HealthBar(Player player) {
		this.player = player;
	
		hungerRect = new ArrayList<Rectangle>();
	
		int startX = 30;
		for(int i = 0; i < 7; i++) {
			hungerRect.add(new Rectangle(startX, 30, 40, 20));
			startX += 25;
			
		}
		
	}
	/**
	 * Draws the GUI
	 * @param surface - DrawingSurface
	 */
	public void draw(DrawingSurface surface) {
		
		int satisfiedHunger = player.getNumCollectible();
		int score = player.getTotalNumCollectible();
		int collisions = player.getTotalCollisions();
		
		//Hunger levels here (shown by rectangles filled in with green)
		if(satisfiedHunger > 7) {
			satisfiedHunger = 7;
		}
		
		for(int i = 0; i < satisfiedHunger; i++) {
			Rectangle curr = hungerRect.get(i);
			surface.fill(115, 195, 108);
			surface.rect(curr.x, curr.y, curr.width, curr.height);
		}
		
		surface.fill(255);
		
		if(satisfiedHunger < 7) {
			for(int i = satisfiedHunger; i < 5; i++) {
				Rectangle curr = hungerRect.get(i);
				surface.rect(curr.x, curr.y, curr.width, curr.height);
			}
		}
		
		//Player's hunger level
		surface.text("Collectibles Recieved: " + satisfiedHunger, 30, 20);
		
		//The player's score for all the collectibles
		surface.text("Score: " + score, 30, 65);
		
		//Obstacle collisions - when more advanced we can make these hearts
		surface.text("Collisions: " + collisions + "/3", 30, 75);
		
	}

}
