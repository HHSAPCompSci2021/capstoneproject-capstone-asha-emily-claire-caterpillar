package Obstacle;

import Player.Player;
import processing.core.PImage;

public class Collectable{
	private boolean eatenYet;
	String collectableType;
	String typeDesign;
	//Either leaf (caterpillar) or flower (butterfly)
	
	/**
	 * Constructs a collectable (either a leaf or flower)
	 * @precondition collectableType is either a "leaf" or "flower"
	 * @param collectableType - leaf or flower
	 */
	public Collectable(String collectableType) {
		this.collectableType = collectableType;
		eatenYet = false;
		//If leaf, change to leaf design
		//If flower, change to flower design
	
	}
	
	/**
	 * The collectable is collected. The total number of collectables and the number of collectables per phase increase.
	 * The collectable becomes eaten and on other methods managed by the panel should disappear.
	 * @param player - A Player object that will collect this collectable
	 */
	public void eat(Player player) {
		player.eatCollectable();
		
	}
	
	
	
	
	
}
