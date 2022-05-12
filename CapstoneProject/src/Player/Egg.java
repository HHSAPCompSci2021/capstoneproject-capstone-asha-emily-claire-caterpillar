package Player;

import java.awt.Point;

import Screen.EggPanel;
import core.DrawingSurface;
import processing.core.PImage;
/**
 * Represents the Player during the Egg phase
 * @author Asha
 *
 */
public class Egg extends Player {
	private boolean isInEggPhase;
	private String selectedButterfly;
	
	/**
	 * Constructs and egg, with its selected images at the start
	 * @param selectedCaterpillar - the PImage of the selected caterpillar
	 * @param selectedButterfly - the PImage of the selected butterfly
	 */
	public Egg(String selectedButterfly) {
		super(0, 0, 0, "");
		this.selectedButterfly = selectedButterfly;
	}
	
	/**
	 * Constructs and egg, with its selected images at the start
	 */
	public Egg() {
		super(0, 0, 0, "");
		EggPanel eggPanel = new EggPanel(new DrawingSurface());
		this.selectedButterfly = eggPanel.selectDesign();
	}
	
	/**
	 * Getter method for the selected caterpillar image
	 * @return caterpillar image
	 */
	public String getSelectedCaterpillar() {
		String caterpillar = "img/Caterpillar.gif";
		return caterpillar;
	}
	
	/**
	 * Getter method for the selected butterfly image
	 * @return butterfly image
	 */
	public String getSelectedButterfly() {
		return selectedButterfly;
	}
	
	/**
	 * Sets whether or not to move on from the egg phase
	 * @param inEggPanel - boolean if in eggphase or not
	 */
	public void setIsInEggPhase(boolean inEggPanel) {
		isInEggPhase = inEggPanel;
	}
	
	/**
	 * Getter method for isInEggPhase
	 * @return isInEggPhase - whether or not the screen should be in egg phase
	 */
	public boolean getIsInEggPhase() {
		return isInEggPhase;
	}
	
	
	//All other methods not meant to be implemented
	@Override
	public void moveByAmount(double x, double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eatCollectable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}
