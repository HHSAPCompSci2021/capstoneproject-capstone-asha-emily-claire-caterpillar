package Screen;

import java.util.List;

import Obstacle.Obstacle;


public class CaterpillarPanel extends Screen{
	private DrawingSurface surface;
	private List<Obstacle> obstacles;
	
	public CaterpillarPanel(DrawingSurface surface)
	{
		this.surface = surface;
	}
}
