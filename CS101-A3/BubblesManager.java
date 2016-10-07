/*
New feature, randomly displays number of bubble on the wall area, manage the bubbles,  return speed/color/size.
*/

import java.awt.*;

public class BubblesManager {

	private Bubble[] bubbles;
	private int numberOfBubbles;
	private int maxBubbles;	
	private int numberOfBubbleHasCollected;
	private int size;
	private int speed;
	private Color bubbleColor;

	public BubblesManager(int maxBubbles){
		this.maxBubbles = maxBubbles;
		this.bubbles = new Bubble[maxBubbles];
		this.numberOfBubbles = 0;
		this.numberOfBubbleHasCollected = 0;
		for (int i = 0; i < maxBubbles;i++){
			addABubble();
		}
	}

	public void addABubble(){
		int num = (int)(Math.random()*3);
		if (numberOfBubbles < maxBubbles){
			bubbles[numberOfBubbles] = new Bubble(num);
			numberOfBubbles++;
		}
	}
	
	public int getMaxbubbles(){
		return maxBubbles;
	}

	public int currentnumberOfBubbles(){
		return numberOfBubbles;
	}
	
	public int getbubblesHasCollected(){
		numberOfBubbleHasCollected = 0;
		for (Bubble a : bubbles){
			if (!a.getIsVisible())
				numberOfBubbleHasCollected++;
		}
		return numberOfBubbleHasCollected;
	}
	
	
	public int getANewSize(){
		return size;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public Color getColor(){
		return bubbleColor;
	}
	
	public void changeColor(){
		for (int i = 0; i < numberOfBubbles; i++){
			bubbles[i].changeColor();
		}
	}

	public boolean checkIfLeoAreaIntersectsABubble(Rectangle leoArea){
		for(int i = 0; i < numberOfBubbles; i++){
			if (bubbles[i].intersectsTheBubble(leoArea)){
				bubbles[i].setIsVisible();
				size = bubbles[i].getSizeOfBubble();
				speed = bubbles[i].getSpeed();
				bubbleColor = bubbles[i].getColor();
				return true;
			}
		}
		return false;
	}

	public void drawTheBubbles(Graphics g){
		for (int i = 0; i < numberOfBubbles; i++){
			if (bubbles[i] != null && bubbles[i].getIsVisible()){
				bubbles[i].draw(g);
			}
		}
	}
}
