package Player;

import processing.core.PImage;

public abstract class Player {

	private PImage design;
	private boolean isAlive;
	private static int totalCollectablesEaten;
	private int collectablesEaten;
	private int numCollectableNeedToEat;
	
	/**
	 * Constructs an Player that is alive with the number of collectables needed. The collectablesEaten should continue to increase 
	 * regardless of phase.
	 * @param numCollectableNeedToEat - the int of collectables that must be eaten
	 */
	public Player(int numCollectableNeedToEat) {
		this.numCollectableNeedToEat = numCollectableNeedToEat;
		collectablesEaten = 0;
		isAlive = true;
	}
	
	/**
	 * Eats the collectable; increases the number of collectables eaten (both total and part for player)
	 */
	public void eatCollectable() {
		totalCollectablesEaten++;
		collectablesEaten++;
	}
	
	/**
	 * Returns the total number of collectables eaten throughout the game
	 * @return the total number of collectables eaten
	 */
	public int getTotalNumCollectable() {
		return totalCollectablesEaten;
	}
	
	/**
	 * Returns the number of collectables eaten in this phase
	 * @return
	 */
	public int getNumCollectable() {
		return collectablesEaten;
	}

	/**
	 * Moves the player by the amount specified
	 * @param x - how much the player horizontally moves
	 * @param y - how much the player vertically moves
	 */
	public abstract void moveByAmount(double x, double y);
	
	/**
	 * Stating the bounds of the window for the player
	 * @param windowWidth - the width of the window (screen)
	 * @param windowHeight - the height of the window (screen)
	 */
	public abstract void applyWindowLimits(int windowWidth, int windowHeight);
	
//	Can we just add the shapes library instead here? public Rectangle getBounds
	

	/**
	 * Draws the player on the screen
	 */
	public abstract void draw();
	
	
}
