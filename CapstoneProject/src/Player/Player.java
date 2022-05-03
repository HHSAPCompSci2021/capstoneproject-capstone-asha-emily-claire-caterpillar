package Player;

import processing.core.PImage;

public abstract class Player {
	private PImage design;
	private boolean isAlive;
	private int collectablesEaten;
	private int numCollectableNeedToEat;
	
	public Player(int numCollectableNeedToEat) {
		this.numCollectableNeedToEat = numCollectableNeedToEat;
		isAlive = true;
	}

	
	public abstract void moveByAmount(double x, double y);
	
	public abstract void applyWindowLimits(int windowWidth, int windowHeight);
	
//	Can we just add the shapes library instead here? public Rectangle getBounds
	
	public abstract void eatCollectable();
	
	public abstract void draw();
	
	
}
