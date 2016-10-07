/*
Defines a leo
*/

import java.awt.*;

public class CoolCat {
	public static final Rectangle LEO_START_AREA = A3Constants.LEO_START_AREA;
    
	public static final int GAME_SCREEN_AREA_TOP = A3Constants.GAME_SCREEN_AREA_TOP;
	public static final int GAME_SCREEN_AREA_BOTTOM = A3Constants.GAME_SCREEN_AREA_BOTTOM;
	public static final int GAME_SCREEN_AREA_LEFT = A3Constants.GAME_SCREEN_AREA_LEFT;
	public static final int GAME_SCREEN_AREA_RIGHT = A3Constants.GAME_SCREEN_AREA_RIGHT;
    
	public static final int UP = A3Constants.UP;
	public static final int DOWN = A3Constants.DOWN;
	public static final int LEFT = A3Constants.LEFT;
	public static final int RIGHT = A3Constants.RIGHT;
    
	private Rectangle area;
	private int direction;
	private int speed;
	private Color catColor;
    
	public CoolCat(){
		//changeColor();
		catColor = new Color(251, 172, 61);
		int x, y, w, h;
		x = LEO_START_AREA.x;
		y = LEO_START_AREA.y;
		w = LEO_START_AREA.width;
		h = LEO_START_AREA.height;
		area = new Rectangle(x,y,w,h);
		this.direction = RIGHT;
		//setspeed;
		speed = (int)(Math.random()*5+4);
	}
	
	public Rectangle getArea(){
		return this.area;
	}
	
	public void setDirection(int direction){
		this.direction = direction;
	}
	
	public boolean hasReachedHome(Rectangle homeArea){
		Rectangle currentRect = area;
		if (currentRect.intersects(homeArea)){
			return true;
		} else {
			return false;
		}
	}
	public void changeSpeed(int s){
		speed = s;
	}
	
	public void changeSize(int s){
		area.width = s;
		area.height = s;
	}
    
	public void move(){
        
		if (direction == RIGHT && area.x + area.width + speed <= GAME_SCREEN_AREA_RIGHT) {
			area.x += speed;
		} else if (direction == RIGHT && area.x + area.width + speed > GAME_SCREEN_AREA_RIGHT){
			area.x = GAME_SCREEN_AREA_RIGHT - area.width;
		} else if (direction == LEFT && area.x - speed >= GAME_SCREEN_AREA_LEFT){
			area.x -= speed;
		} else if (direction == LEFT && area.x - speed < GAME_SCREEN_AREA_LEFT){
			area.x = GAME_SCREEN_AREA_LEFT;
		} else if (direction == UP && area.y - speed >= GAME_SCREEN_AREA_TOP){
			area.y -= speed;
		} else if (direction == UP && area.y - speed < GAME_SCREEN_AREA_TOP){
			area.y = GAME_SCREEN_AREA_TOP;
		} else if (direction == DOWN && area.y + area.height + speed <= GAME_SCREEN_AREA_BOTTOM){
			area.y += speed;
		} else if (direction == DOWN && area.y + area.height + speed > GAME_SCREEN_AREA_BOTTOM){
			area.y = GAME_SCREEN_AREA_BOTTOM - area.height;
		}
	}
    
	public void changeColor() {
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		catColor = new Color(red, green, blue);
	}
	
	public void setColor(Color c){
		catColor = c;
	}
		
	public void draw(Graphics g){
		g.setColor(catColor);
		g.fillOval(area.x, area.y, area.width, area.height);
	}
}
