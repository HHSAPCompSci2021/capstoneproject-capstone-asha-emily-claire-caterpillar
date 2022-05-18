package Screen;

import java.awt.Point;
import java.awt.Rectangle;

import core.DrawingSurface;

/**
 * The screen at the end of the game
 * @author Asha
 *
 */
public class EndPanel extends Screen{
	private Rectangle button;
	private DrawingSurface surface;
	
	public EndPanel(DrawingSurface surface) {
		super(800, 600);
		this.surface = surface;
		button = new Rectangle(800/2-100,600/2,210,40);
	}
	
	public void draw() {
		setCurrScreen(true);
		surface.background(255, 255, 255);
		surface.fill(255);
		surface.image(surface.loadImage("img/background2.gif"), 0, 0, 800, 600);
		surface.text("Congrats! You have completed your journey!", 40, 200);
		surface.rect(button.x, button.y, button.width, button.height);
		float w = surface.textWidth("Exit");
		surface.fill(0);
		surface.text("Exit", button.x+button.width/2-w/2, button.y+button.height/2);
	}
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY));
		 if(button.contains(p)) {
		    	setCurrScreen(false);
		    	System.exit(0);
		    }
	}

}


