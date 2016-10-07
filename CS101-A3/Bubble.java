/*
New feature, randomly displays a bubble on the wall area, return speed/color/size.
*/

import java.awt.*;

public class Bubble {
	public static final Rectangle ALL_WALLS_AREA = A3Constants.ALL_WALLS_AREA;
	public static final int LARGE_BUBBLE_SIZE = 30;
	public static final int MEDIUM_BUBBLE_SIZE = 20;
	public static final int SMALL_BUBBLE_SIZE = 15;

	public static final int GAME_SCREEN_AREA_BOTTOM = A3Constants.GAME_SCREEN_AREA_BOTTOM;
	public static final int GAME_SCREEN_AREA_TOP = A3Constants.GAME_SCREEN_AREA_TOP;
	public static final Color BUBBLE_COLOUR = new Color(255, 170, 248);

	private Rectangle area;
	private boolean isVisible;
	private int x,y,s;
	private Color bubbleColor;
	private int speed;

	public Bubble(int size){
		if( size == 1){
			this.s = MEDIUM_BUBBLE_SIZE;
			this.speed = (int)(Math.random()*5+4);
		} else if (size == 2){
			this.s = LARGE_BUBBLE_SIZE;
			this.speed = (int)(Math.random()*5+2);
		} else {
			this.s = SMALL_BUBBLE_SIZE;
			this.speed = (int)(Math.random()*5+6);
		}
		changePosition();
		this.area = new Rectangle(x,y,s,s);
		this.isVisible = true;
		changeColor();
	}

	public Rectangle getArea(){
		return this.area;
	}

	public boolean intersectsTheBubble(Rectangle leoArea){
		Rectangle currentArea = area;
		if (currentArea.intersects(leoArea)){
			return true;
		} else {
			return false;
		}
	}
	
	public void setIsVisible(){
		isVisible = false;
	}
	
	public int getSizeOfBubble(){
		return area.width;
	}
	
	public Color getColorOfBubble(){
		return bubbleColor;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public Color getColor(){
		return  bubbleColor;
	}
	
	public boolean getIsVisible(){
		return isVisible;
	}

	public void changePosition(){
		y = (int)(Math.random() * (ALL_WALLS_AREA.height - ALL_WALLS_AREA.y - s) + ALL_WALLS_AREA.y);
		x = (int)(Math.random() * (ALL_WALLS_AREA.width - ALL_WALLS_AREA.x - s) + ALL_WALLS_AREA.x);
	}
	
	public void changeColor() {
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		bubbleColor = new Color(red, green, blue);
	}

	public void draw(Graphics g){
		g.setColor(bubbleColor);
		g.fillOval(area.x, area.y, area.width, area.height);
	}
}

