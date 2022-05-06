package Screen;
/**
 * Represents the screen. To be expanded upon in other phases.
 * @author Emily
 *
 */
public abstract class Screen {
	public final int DRAWING_WIDTH, DRAWING_HEIGHT;
	
	/**
	 * Creates a screen
	 * @param width - the width of the screen
	 * @param height - the height of the screen
	 */
	public Screen(int width, int height) {
		this.DRAWING_WIDTH = width;
		this.DRAWING_HEIGHT = height;
	}
	
	/**
	 * Sets up the main features of the screen
	 */
	public void setup() {
		
	}
	
	/**
	 * Draws the screen
	 */
	public void draw() {
		
	}
	
	/**
	 * Checks if the mouse is pressed
	 */
	public void mousePressed() {
		
	}
	/**
	 * Checks if the mouse is pressed
	 */
	public void mouseReleased() {

	}
	/**
	 * Switches the screen
	 * @param i - the index of the screen to switch too
	 */
	public void switchScreen(int i) {
		
	}
	
}
