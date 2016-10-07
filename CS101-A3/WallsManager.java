/*
Defines number of the walls on the top/bottom of the wall area, and mange the walls.
*/

import java.awt.*;

public class WallsManager {
	//public static final int MAX_WALLS = A3Constants.MAX_WALLS;
	public static final Rectangle ALL_WALLS_AREA = A3Constants.ALL_WALLS_AREA;
    
    
	private SlidingWall[] walls;
	private int numberOfWalls;
	private int maxWalls;
    
	public WallsManager(int num){
		this.maxWalls = num;
		this.walls = new SlidingWall[maxWalls];
		this.numberOfWalls = 0;
	}
   
	public int getNumberOfWalls(){
		return maxWalls;
	}

	public void addAWall(){
		if (numberOfWalls < maxWalls){
			walls[numberOfWalls] = new SlidingWall();
			numberOfWalls++;
		}
	}
    
	public boolean checkIfLeoAreaIntersectsAWall(Rectangle leoArea){
		boolean check = false;
		for(int i = 0; i < numberOfWalls; i++){    
			if (walls[i].intersectsTheWall(leoArea)){
				check =  true;
			}
		}
		return check;
	}
    
	public void tidyUpWalls(){
		for (int i = 0; i < numberOfWalls; i++){
			if (walls[i].getIsVisible() == false){
				for(int j = i; j < numberOfWalls - 1; j++)
					walls[j] = walls[j+1];
				numberOfWalls--;			
			}
		}
	}
    
	public int currentNumberOfWalls(){
		return numberOfWalls;
	}
    
	public void moveTheWalls(){
		for(int i = 0; i < numberOfWalls; i++){
			walls[i].move();
		}
	}
	public void drawTheWalls(Graphics g){
		for (int i = 0; i < numberOfWalls; i++){
			walls[i].draw(g);
		}
	}
}
