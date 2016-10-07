/*
Defines a wall in the wall area
*/

import java.awt.*;

public class SlidingWall {
	public static final Rectangle ALL_WALLS_AREA = A3Constants.ALL_WALLS_AREA;
	public static final int MAX_SLIDE_HEIGHT = 120;
	public static final int MIN_SLIDE_HEIGHT = 40;
	public static final int MAX_SLIDE_WIDTH = 25;
	public static final int MIN_SLIDE_WIDTH = 10;
    
	public static final int GAME_SCREEN_AREA_BOTTOM = A3Constants.GAME_SCREEN_AREA_BOTTOM;
	public static final int GAME_SCREEN_AREA_TOP = A3Constants.GAME_SCREEN_AREA_TOP;
	public static final Color WALL_COLOUR = A3Constants.WALL_COLOUR;
    
	public static final int UP = A3Constants.UP;
	public static final int DOWN = A3Constants.DOWN;
    
	private Rectangle area;
	private int speed;
	private boolean isVisible;
	private int direction;
    
	public SlidingWall(){
		int x,y,w,h;
		int randomNum = (int)(Math.random() * 2);  //0=UP,1=DOWN
		h = (int)(Math.random() * (MAX_SLIDE_HEIGHT - MIN_SLIDE_HEIGHT) + MIN_SLIDE_HEIGHT);
		if (randomNum == 0){
			this.direction = UP;
			y = GAME_SCREEN_AREA_BOTTOM;
		} else {
			this.direction = DOWN;
			y = (GAME_SCREEN_AREA_TOP - h);
		}
		x = (int)(Math.random() * (ALL_WALLS_AREA.width - ALL_WALLS_AREA.x) + ALL_WALLS_AREA.x);        
		w = (int)(Math.random() * (MAX_SLIDE_WIDTH - MIN_SLIDE_WIDTH) + MIN_SLIDE_WIDTH);		
		this.area = new Rectangle(x,y,w,h);
        
        
		this.isVisible = true;
		changeSpeed();
	}
	public boolean getIsVisible(){
		if ( direction == UP && area.y > GAME_SCREEN_AREA_TOP - area.height || direction == DOWN && area.y < GAME_SCREEN_AREA_BOTTOM ){
			return true;
		} else {
			return false;
		}
	}
    
	public Rectangle getArea(){
		return this.area;
	}
    
	public boolean intersectsTheWall(Rectangle leoArea){
		Rectangle currentArea = area;
		if (currentArea.intersects(leoArea)){
			return true;
		} else {
			return false;
		}
	}
    
	public void changeSpeed(){
		speed = (int)(Math.random()*5+12);
	}
    
	public void move(){
		//changeSpeed();
		if ( direction == DOWN ){
			area.y += speed;
		} else {
			area.y -= speed;
		}
	}
    
	public void draw(Graphics g){
		g.setColor(WALL_COLOUR);
		g.fillRect(area.x, area.y, area.width, area.height);
	}
}

