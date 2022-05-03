package Player;

import processing.core.PImage;

public class Egg extends Player {
	private boolean isInEggPhase;
	private PImage selectedCaterpillar;
	private PImage selectedButterfly;
	
	public Egg(PImage selectedCaterpillar, PImage selectedButterfly) {
		super(0);
		this.selectedCaterpillar = selectedCaterpillar;
		this.selectedButterfly = selectedButterfly;
	}
	
	public PImage getSelectedCaterpillar() {
		return selectedCaterpillar;
	}
	
	public PImage getSelectedButterfly() {
		return selectedButterfly;
	}
	
	public void setIsInEggPhase(boolean inEggPanel) {
		isInEggPhase = inEggPanel;
	}
	
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
