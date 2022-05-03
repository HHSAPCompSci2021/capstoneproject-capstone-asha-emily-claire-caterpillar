import java.util.ArrayList;

import Screen.CaterpillarPanel;
import Screen.Screen;

public class DrawingSurface extends pApplet{
	private ArrayList<Screen> screens;
	
	public DrawingSurface() {
		CaterpillarPanel cater = new CaterpillarPanel(this);
	}
}
