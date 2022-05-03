package core;
import java.applet.Applet;
import java.util.ArrayList;

import Screen.ButterflyPanel;
import Screen.CaterpillarPanel;
import Screen.EggPanel;
import Screen.MenuPanel;
import Screen.Screen;
import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	private ArrayList<Screen> screens;
	
	public DrawingSurface() {
		
		
		MenuPanel menu = new MenuPanel(this);
		screens.add(menu);
		
		EggPanel egg = new EggPanel(this);
		screens.add(egg);
		
		CaterpillarPanel cater = new CaterpillarPanel(this);
		screens.add(cater);
		
		ButterflyPanel butter = new ButterflyPanel(this);
		screens.add(butter);
		
	}
}
