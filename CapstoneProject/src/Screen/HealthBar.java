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

public class HealthBar {
	private ArrayList<Rectangle> hungerRect;
	private Player player;
	
	
	public HealthBar(Player player) {
		this.player = player;
	
		hungerRect = new ArrayList<Rectangle>();
	
		int startX = 30;
		for(int i = 0; i < 5; i++) {
			hungerRect.get(i).add(new Rectangle(startX, 30, 20, 20));
			startX += 30;
			
		}
		
	}
	
	public void draw(DrawingSurface surface) {
		
		int satisfiedHunger = player.getNumCollectible();
		int score = player.getTotalNumCollectible();
		int collisions = player.getTotalCollisions();
		
		//Hunger levels here (shown by rectangles filled in with green)
		surface.text("Hunger Level: " + satisfiedHunger, 30, 10);
		
		for(int i = 0; i < satisfiedHunger; i++) {
			Rectangle curr = hungerRect.get(i);
			surface.fill(115, 195, 108);
			surface.rect(curr.x, curr.y, curr.width, curr.height);
		}
		
		surface.fill(0);
		
		for(int i = satisfiedHunger; i < 5; i++) {
			Rectangle curr = hungerRect.get(i);
			surface.rect(curr.x, curr.y, curr.width, curr.height);
		}
		
		//The player's score for all the collectibles
		surface.text("Score: " + score, 30, 60);
		
		//Obstacle collisions - when more advanced we can make these hearts
		surface.text("Collisions: " + collisions + "/3", 30, 80);
		
	}

}
