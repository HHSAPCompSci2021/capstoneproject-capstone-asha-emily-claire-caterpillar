package Obstacle;

import Player.Player;
import processing.core.PImage;
/**
 * Represents a Collectible, such as a leaf or flower
 * @author Asha
 *
 */
public class Collectible{
	private boolean eatenYet;
	String collectibleType;
	String typeDesign;
	//Either leaf (caterpillar) or flower (butterfly)
	
	/**
	 * Constructs a collectible (either a leaf or flower)
	 * @precondition collectableType is either a "leaf" or "flower"
	 * @param collectibleType - leaf or flower
	 */
	public Collectible(String collectibleType) {
		this.collectibleType = collectibleType;
		eatenYet = false;
		
		if(collectibleType.equals("leaf")) {
			typeDesign = "img/Leaf.gif";
		} else {
			typeDesign = "img/Flower.gif";
		}
		
	
	}
	
	/**
	 * The collectible is collected. The total number of collectibles and the number of collectibles per phase increase.
	 * The collectible becomes eaten and on other methods managed by the panel should disappear.
	 * @param player - A Player object that will collect this collectible
	 */
	public void eat(Player player) {
		player.eatCollectable();
		eatenYet = true;
	}
	
	public boolean getEatenYet() {
		return eatenYet;
	}
	
	
	
}
