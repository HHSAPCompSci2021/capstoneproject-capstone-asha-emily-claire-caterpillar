package Player;
/**
 * Represents the player during the butterfly phase.
 * @author Claire
 *
 */
public class Butterfly extends Player{
	
	private double xVol, yVol;
	
	/**
	 * Constructs a Butterfly
	 */
	public Butterfly() {
		super(5);
	}
	
	/**
	 * Constructs a Butterfly with a default velocity
	 * @param xv - horizontal velocity
	 * @param yv - vertical velocity 
	 */
	public Butterfly(double xv, double yv) {
		super(5);
		xVol = xv;
		yVol = yv;
	}

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
