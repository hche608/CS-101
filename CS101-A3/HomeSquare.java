/*
This is the method to control home square, it moves up/down randomly at 5% chance
*/

import java.awt.*;

public class HomeSquare {
	public static final Rectangle HOME_START_AREA = A3Constants.HOME_START_AREA;
	public static final Rectangle GAME_SCREEN_AREA = A3Constants.GAME_SCREEN_AREA;
	public static final Color NICE_GRAY_COLOUR = A3Constants.NICE_GRAY_COLOUR; 
    
	public static final Rectangle HOME_AREA = A3Constants.HOME_AREA;    
	public static final int UP = A3Constants.UP;
	public static final int DOWN = A3Constants.DOWN;
    
	private Rectangle area;
	private int speed;
	private int direction;
	private Color homeColor;
    
	public HomeSquare(){
		changeColor();
		int x, y, w, h;
		x = HOME_START_AREA.x;
		y = HOME_START_AREA.y;
		w = HOME_START_AREA.width;
		h = HOME_START_AREA.height;
		this.area = new Rectangle(x, y, w, h);
		direction = DOWN;
		changeSpeed();
	}
    
	public Rectangle getArea(){
		return this.area;
	}
    
	public void changeDirection(){
		if (direction == DOWN){
			direction = UP;
		} else if(direction == UP){
			direction = DOWN;
		}
        
	}
	public void changeSpeed(){
		speed = (int)(Math.random()*5+2);
	}
    
	public void move(){
		changeSpeed();
		int chance = (int)(Math.random()*99);
		if (chance < 5){
			changeDirection();
		}
		if (direction == DOWN && area.y + area.height + speed <= GAME_SCREEN_AREA.height){
			area.y += speed;
		} else if(direction == DOWN && area.y + area.height + speed > GAME_SCREEN_AREA.height){
			area.y = GAME_SCREEN_AREA.height - area.height;
			changeDirection();
		} else if(direction == UP && area.y - speed >= GAME_SCREEN_AREA.y){
			area.y -= speed;
		} else if(direction == UP && area.y - speed < GAME_SCREEN_AREA.y){
			area.y = GAME_SCREEN_AREA.y;
			changeDirection();
		}
	}
    
	public void changeColor() {
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		homeColor = new Color(red, green, blue);
	}
    
	public void draw(Graphics g){
		g.setColor(homeColor);
		g.fillRect(area.x, area.y, area.width, area.height);
	}
    
}