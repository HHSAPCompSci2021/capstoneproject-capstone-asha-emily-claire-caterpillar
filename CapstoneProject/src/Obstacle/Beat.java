package Obstacle;

public class Beat extends Element{

	private boolean view;
	
	public Beat(String i, double x, double y, double s) {
		super(i,x,y,s);
		view = true;
		
	}
	
	public boolean getView() {
		return view;
	}
	
	public void setView(boolean v) {
		view = v;
	}
}
