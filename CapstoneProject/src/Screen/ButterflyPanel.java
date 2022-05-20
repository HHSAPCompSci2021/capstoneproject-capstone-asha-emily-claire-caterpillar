package Screen;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Obstacle.Collectible;
import Obstacle.Element;
import Obstacle.Obstacle;
import Obstacle.Predator;
import Player.Butterfly;
import Sound.SoundJLayer;
import core.DrawingSurface;
import processing.core.PImage;
/**
 * The screen during the Butterfly phase
 * @author Claire
 *
 */
public class ButterflyPanel extends Screen {
	
	/*
	 * DrawingSurface where the panels are being made
	 */
	private DrawingSurface surface;
	
	/*
	 * Array List of all of the elements that the player must avoid
	 */
	private ArrayList<Element> obs;
	
	private ArrayList<Element> obs1;
	
	/*
	 * Array List of all of the collectibles that the player must try and collect
	 */
	private ArrayList<Collectible> col;
	
	/*
	 * The butterfly object that the player controls
	 */
	private Butterfly b;
	
	private HealthBar h;
	
	private PImage p1, p2, p3;
	
	private ArrayList<PImage> obsImg;
	
	private ArrayList<PImage> preImg;
	
	private ArrayList<String> obsImg1;
	
	private ArrayList<String> preImg1;
	

	
	/**
	 * Constructs a ButterflyPanel 
	 * @param s - a DrawingSurface to construct the panel on
	 */
	public ButterflyPanel(DrawingSurface s) {
		super(800,600);
		surface = s;
		
		
//		SoundJLayer soundToPlay = new SoundJLayer("audio/Butterfly Panel Music.mp3");
//		soundToPlay.play();
	
		
	}
	
	/**
	 * Sets up the panel
	 */
	public void setup() {
		
		obsImg = new ArrayList<PImage>();
		preImg = new ArrayList<PImage>();
		obsImg1 = new ArrayList<String>();
		preImg1 = new ArrayList<String>();

		
		p1 = surface.loadImage("img/Butterfly1.gif");
		p2 = surface.loadImage("img/Butterfly2.gif");
		p3 = surface.loadImage("img/Butterfly3.gif");
		
		
		preImg.add(surface.loadImage("img/Bat.png"));
		preImg.add(surface.loadImage("img/Crow.png"));
		preImg.add(surface.loadImage("img/Robin.png"));
		preImg.add(surface.loadImage("img/Toad.png"));
		
		obsImg.add(surface.loadImage("img/Airplane.png"));

		preImg1.add("img/Bat.png");
		preImg1.add("img/Crow.png");
		preImg1.add("img/Robin.png");
		preImg1.add("img/Toad.png");
		
		obsImg1.add("img/Airplane.png");

		
		
		obs = new ArrayList<Element>();
		obs1 = new ArrayList<Element>();
		col = new ArrayList<Collectible>();
		
		addRandomElement(obs);
		addRandomElement(obs1);
		addRandomCollectible(col);

		b = new Butterfly(5, 100, 100, p1);
		h = new HealthBar(b);
		b.setCollectiblesEaten(0);
		b.setTotalCollisions(0);
		
	}
	
	/**
	 * Adds a number of predators to random locations
	 * @param a - list of elements to add
	 */
	public void addRandomElement(ArrayList<Element> a) {
		
	
		
		for(int i = 0; i < 25; i++) {
			
			boolean bottom = false;
			PImage e;
			int y = 0;

			double choice = (Math.random());
			double choice1 = (Math.random());
			double choice2 = Math.random();
			
			
			//System.out.println(choice);
			int x = (((int)(Math.random() * 200) + 800) / 10) * 10;
			double speed = 10 + (i * 0.5);
			if(choice >= 0.9) {
				y = 64;
			} else if(choice >= 0.7) {
				y = 128;
			} else if(choice >= 0.5) {
				y = 256;
			} else if(choice >= 0.3) {
				y = 384;
			} else {
				y = 480;
				bottom = true;
			} 
		
			
			if(choice2 >= 0.5) {
				
				if(bottom) {
					e = preImg.get(3);
				} else if(choice1 >= 0.8) {
					e = preImg.get(0);
				} else if(choice1 >= 0.4) {
					e = preImg.get(1);
				}  else {
					e = preImg.get(2);
				} 
				
				if(bottom) {
					if(a.equals(obs)) {
						a.add(new Predator(e, 800, y, speed, 68,124));
					} else  {
						a.add(new Predator(e, 870, y, speed, 68,124));
					}
					
				} else {
					if(a.equals(obs)) {
						a.add(new Predator(e, 800, y, speed, 64,64));
					} else  {
						a.add(new Predator(e, 870, y, speed, 64,64));
					}
				}	
				//img.add(createImage());
				//return new Predator("img/Predator.gif", 800, y, 10);
				//System.out.println(false);
				
				
	
			} else {
				
				if(bottom) {
					e = obsImg.get(0);
				} else if(choice1 >= 0.7) {
					e = obsImg.get(0);
				} else if(choice >= 0.4) {
					e = obsImg.get(0);
				}  else {
					e = obsImg.get(0);
				} 
				if(a.equals(obs)) {
					a.add(new Obstacle(e, 800, y, speed, 64, 64));
				} else {
					a.add(new Obstacle(e, 870, y, speed, 64, 64));
				}
				//return new Obstacle("img/Kite.gif", 800, y, 10);
				//System.out.println(true);
	
			}
			
		}	
	}
	
	/**
	 * Adds a number of collectables to random locations
	 * @param a - list of collectibles to add
	 */
	public void addRandomCollectible(ArrayList<Collectible> a) {

		for(int i = 0; i < 15; i++) {
			
			double speed = 10 + (i * 0.5);
			
			double choice = (Math.random());
			int y = 0; 
			
			if(choice >= 0.9) {
				y = 0;
			} else if(choice >= 0.7) {
				y = 192;
			} else if(choice >= 0.4) {
				y = 320;
			} else  {
				y = 448;
			} 
			
			int x = (((int)(Math.random() * 200) + 400) / 10) * 10;
			
			//Was this supposed to be added to the collectible array instead of obs
			col.add(new Collectible("flower", "img/Flower.gif", speed, 800 + (i * x), y));
			//System.out.println(false);
			
		}	
	}
	
	
	/**
	 * Draws the screen for the phase
	 */
	public void draw() {
		
	
		//System.out.println(obs);
		//System.out.println(obs1);

		if(surface.getDesign().equals("img/Butterfly1.gif")) {
			b.setDesign(p1);
		} else if(surface.getDesign().equals("img/Butterfly2.gif")) {
			b.setDesign(p2);
		} else  {
			b.setDesign(p3);
		}
		
		//System.out.println(true);
		surface.background(255,255,255);
		surface.fill(0);
		
		h.draw(surface);
		if(b.getIsAlive()) {
			//restart = false;
			if (surface.isPressed(KeyEvent.VK_UP) && b.getY() >= 0)
				b.moveByAmount(0, -10);
			if (surface.isPressed(KeyEvent.VK_DOWN) &&  b.getY() < 600 - 64)
				b.moveByAmount(0, 10);
			
			b.draw2(surface);
		
	
			//b.draw(surface);
			
			//int i = 0;
			boolean next = true;

			
			while(obs.size() > 0 && next) {
				next = false;
				obs.get(0).draw1(surface);
				sideScrolling(obs.get(0));
				
				if(obs.get(0).getX() < 0) {
					next = true;
					obs.remove(0);
				}
			}
			
			boolean next1 = true;
			while(obs1.size() > 0 && next1) {
				next1 = false;
				obs1.get(0).draw1(surface);
				sideScrolling(obs1.get(0));
				
				if(obs1.get(0).getX() < 0) {
					next1 = true;
					obs1.remove(0);
				}
			}
			
			boolean wow = true;

			
			
			while(col.size() > 0 && wow) {
				wow = false;
				col.get(0).draw(surface);
				sideScrolling(col.get(0));
				
				if(col.get(0).getX() < 0) {
					wow = true;
					col.remove(0);
				}
			}
		
			
			
//			for(Element e : obs) {
//				e.draw1(surface);
//			}
//			
//			for(Collectible c : col) {
//				c.draw(surface);
//			}
				
			//sideScrolling();
			
			
			for(Element e : obs) {
				
				
					if(e.collide(b.playerDesignRect())) {
						if(e instanceof Predator) {
							b.increaseCollisions((Predator)e);
						} else {
							e.moveByAmount(e.getX() - 64, DRAWING_HEIGHT);
							b.increaseCollisions((Obstacle)e);
						}
						
					} else {
						e.draw1(surface);	
					}						
						
			} 
			
			for(Collectible c : col) {
				if(c instanceof Collectible) {
					if(c.collide(b.playerDesignRect())) {
						System.out.print(true);
						
						
						c.moveByAmount(c.getX() - DRAWING_WIDTH, 0);
						((Collectible) c).eat(b);
					} else {
						c.draw(surface);
					}
				}
			}
			
			
			
		}	else {
			b.setTotalCollisions(0);
			b.setCollectiblesEaten(0);
			resetScreen();
		}
			
		if(b.getNumCollectible() == b.getNumCollectiblesNeedToEat())
		{
			nextScreen();
			return;
		}
		
		if(obs.size() == 0 && obs1.size() == 0) {
			resetScreen();
			b.setCollectiblesEaten(0);
			b.setTotalCollisions(0);

		}
		
		
	}

	
	public void resetScreen() {
		surface.reset("b");
		surface.switchScreen(14);
		
	}
	
	public void nextScreen() {
		surface.switchScreen(15);
	}
	
	/**
	 * Adds features to the screen in a side scrolling effect
	 * @param e - Element to move
	 */
	public void sideScrolling(Element e) {
		
		
		if(e.getX() > -64) { 
			e.move();
////		
//		for(Collectible c : col) {
//			if(c.getX() > -64) { 
//				c.move();
//				
//			} 
//		}
//		
//		
//		for(Element e : obs) {
//			if(e.getX() > -64) { 
//				e.move();
//				
//			} 
		}
		
		
	}
	

	
	

	
}
