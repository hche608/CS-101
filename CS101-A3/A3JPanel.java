/*
* Purpose: defines many constants 
*
* 
* Author: Hao CHEN
* UPI: hche608
* Date: S2 2013
* 
* How to
* collocts all the bubble on the wall area while aviod the sliding walls before get home.
*
* inherits all featurns of a bubble when leo intersects the bubble.
*
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class A3JPanel extends JPanel implements ActionListener, KeyListener, MouseListener{
	public static final int JFRAME_AREA_WIDTH = A3Constants.JFRAME_AREA_WIDTH;
	public static final int JFRAME_AREA_HEIGHT = A3Constants.JFRAME_AREA_HEIGHT;;
    
	public static final Rectangle HOME_AREA = A3Constants.HOME_AREA;
	public static final Rectangle LEO_LEFT_AREA = A3Constants.LEO_LEFT_AREA;
	public static final Rectangle ALL_WALLS_AREA = A3Constants.ALL_WALLS_AREA;
	public static final Rectangle EXITING_SLIDES_AREA = A3Constants.EXITING_SLIDES_AREA;
    
	public static final Color NICE_GRAY_COLOUR = A3Constants.NICE_GRAY_COLOUR;
	public static final Color GAME_SCREEN_COLOUR = A3Constants.GAME_SCREEN_COLOUR;
	public static final Color SLIDES_AREA_COLOUR = A3Constants.SLIDES_AREA_COLOUR;
	public static final Color LEO_AREA_COLOUR = A3Constants.LEO_AREA_COLOUR; 
	public static final Color HOME_AREA_COLOUR = A3Constants.HOME_AREA_COLOUR;
	public static final Color WALL_COLOUR = A3Constants.WALL_COLOUR;
    
	public static final int MAX_WALLS = A3Constants.MAX_WALLS;
    
	public static final Font TINY_FONT = A3Constants.TINY_FONT;
	public static final Font LARGE_FONT = A3Constants.LARGE_FONT;
	public static final Font HUGE_FONT = A3Constants.HUGE_FONT;
    
	public static final int LARGE_FONT_SIZE = A3Constants.LARGE_FONT_SIZE;
	public static final int HUGE_FONT_SIZE = A3Constants.HUGE_FONT_SIZE;
    
	public static final Point TICKS_POSITION = A3Constants.TICKS_POSITION;
	public static final Point WINNER_LOSER_INFO_POSITION = A3Constants.WINNER_LOSER_INFO_POSITION;  
	public static final Point INFORMATION_POSITION1 = A3Constants.INFORMATION_POSITION1;
	public static final Point INFORMATION_POSITION2 = A3Constants.INFORMATION_POSITION2;
	public static final Point INFORMATION_POSITION3 = A3Constants.INFORMATION_POSITION3;
    
	public static final int TICKS_ALLOWED = A3Constants.TICKS_ALLOWED; 
	public static final int UP = A3Constants.UP;
	public static final int DOWN = A3Constants.DOWN;
	public static final int LEFT = A3Constants.LEFT;
	public static final int RIGHT = A3Constants.RIGHT;
    
	private Rectangle leftArea;
	private Rectangle rightArea;
	private Rectangle gameArea;
	private Rectangle bottomArea;
	private Timer t;
    
	private CoolCat cat;
	private HomeSquare home;
    
	private int ticksTaken; 
	private int tickCounter;
	private int count;
	private int mode;

    
	private WallsManager walls;
	private BubblesManager bubbles;
    
	private boolean leoHasWon;
	private boolean gameHasEnded;  
	private boolean getAllBubbles;
    
	private boolean isShowingTitleScreen;
    
	public A3JPanel() {
		isShowingTitleScreen = true;
        
		setBackground(Color.GREEN);
		leftArea = new Rectangle(LEO_LEFT_AREA);
		rightArea = new Rectangle(HOME_AREA);
		gameArea = new Rectangle(ALL_WALLS_AREA);
		bottomArea = new Rectangle(EXITING_SLIDES_AREA);
        
		cat = new CoolCat();
		home = new HomeSquare();
		mode = 1;
		chooseMode(mode);
        
		t = new Timer(125,this);
        
		ticksTaken = A3Constants.TICKS_ALLOWED;
		tickCounter = 0;
		count = 0;
        
		leoHasWon = false;
		gameHasEnded = false;
		getAllBubbles = false;
        
		addKeyListener(this);
		addMouseListener(this);
        
	}
	//-------------------------------------------------------
	// Reset everything ready for a new game
	//-------------------------------------------------------
	public void reset(){
		t.stop();
		isShowingTitleScreen = false;
		cat = new CoolCat();
		home = new HomeSquare();
		chooseMode(mode);
		ticksTaken = A3Constants.TICKS_ALLOWED;
		tickCounter = 0;
		count = 0;
		leoHasWon = false;
		gameHasEnded = false;
		getAllBubbles = false;
	}
	//-------------------------------------------------------
	// Handle KeyEvents
	//-------------------------------------------------------
	public void keyPressed(KeyEvent e){
		if (e.getKeyCode()==KeyEvent.VK_LEFT){
			cat.setDirection(CoolCat.LEFT);
		} else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			cat.setDirection(CoolCat.RIGHT);
		} else if (e.getKeyCode()==KeyEvent.VK_UP){
			cat.setDirection(CoolCat.UP);
		} else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			cat.setDirection(CoolCat.DOWN);
		}
		// Change colour if the 'c' key is pressed.
		else if (e.getKeyChar()=='c'){
			cat.changeColor();
			home.changeColor();
			bubbles.changeColor();
			repaint();
		}
		// Stop if the 's' key is pressed.
		else if (e.getKeyChar()=='s'){
			if (!t.isRunning()&&!leoHasWon&&!gameHasEnded){
				t.start();
			} else {
				t.stop();
			} 
		}
		// Reset if the 'r' key is pressed.
		else if (e.getKeyChar()=='r'){
			reset();
		}
		// Return to the title screen if the 't' key is pressed.
		else if (e.getKeyChar()=='t'){
			if(!isShowingTitleScreen){
				t.stop();
				isShowingTitleScreen = true;
				repaint();				
			} else if(isShowingTitleScreen){
				isShowingTitleScreen = false;
				repaint();
			}
		} 
		// Choose different mode when the '1' or '2' or '3' key is pressed.
		else if (!t.isRunning() && e.getKeyChar()=='0'){
			reset();
			mode = 0;
			chooseMode(mode);          
		}
		else if (!t.isRunning() && e.getKeyChar()=='1'){
			reset();
			mode = 1;
			chooseMode(mode);          
		} else if (!t.isRunning() && e.getKeyChar()=='2'){
			reset();
			mode = 2;
			chooseMode(mode);          
		} else if (!t.isRunning() && e.getKeyChar()=='3'){
			reset();
			mode = 3;
			chooseMode(mode);         
		} 
	}
	public void keyReleased(KeyEvent e){
		
	}
	public void keyTyped(KeyEvent e){
		
	} 
	//-------------------------------------------------------
	// Handle MouseEvents
	//------------------------------------------------------- 
	public void mousePressed(MouseEvent e){
		if (!t.isRunning()&&isShowingTitleScreen){
			reset();
		} else if(t.isRunning()&&!isShowingTitleScreen){
			t.stop();
		} else if(!t.isRunning()&&!isShowingTitleScreen&&!leoHasWon&&!gameHasEnded){
			t.start();
		}        
	}
	public void mouseClicked(MouseEvent e){
			
	}
	public void mouseEntered(MouseEvent e){
				
	}
	public void mouseReleased(MouseEvent e){
					
	}
	public void mouseExited(MouseEvent e){
						
	}

	//-------------------------------------------------------
	// Handle ActionEvents
	//------------------------------------------------------- 
	public void actionPerformed(ActionEvent e){        
		cat.move();
		home.move();
		if (Math.random()>0.05){
			walls.addAWall();
		}		
		walls.moveTheWalls();       
		walls.tidyUpWalls();
			        
		tickCounter++;
		countDown();
			
		checkCollectAllBubbles();
		checkLeoInterserectsABubble();			
		if(bubbles.getbubblesHasCollected() != 0 && bubbles.getbubblesHasCollected() != count){				
			effectByABubble();
			count++;
		}
							
		if (setResultAndGetEndOfGame() == false){
			t.stop();
		}        
		repaint();
	}
	//-------------------------------------------------------
	// Draw everything
	//-------------------------------------------------------
    
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawGameArea(g, NICE_GRAY_COLOUR, LEO_LEFT_AREA);
		drawGameArea(g, HOME_AREA_COLOUR, HOME_AREA);
		drawGameArea(g, SLIDES_AREA_COLOUR, ALL_WALLS_AREA);
		drawGameArea(g, GAME_SCREEN_COLOUR, EXITING_SLIDES_AREA);
        
		bubbles.drawTheBubbles(g);
		walls.drawTheWalls(g);        
		home.draw(g);
		cat.draw(g);        
		drawGameArea(g, Color.GREEN, EXITING_SLIDES_AREA);
		drawWinOrLose(g);
		drawTitleArea(g);
        
	}
	//-------------------------------------------------------
	// Drawing helper methods
	//-------------------------------------------------------
	public void drawGameArea(Graphics g, Color c, Rectangle area){
		g.setColor(c);
		g.fillRect(area.x, area.y, area.width, area.height);
        
		g.setColor(WALL_COLOUR);
		g.setFont(A3Constants.VERY_SMALL_FONT);
		g.drawString("Time", TICKS_POSITION.x + 1, TICKS_POSITION.y - 16);
		
		String countDown = "" + ticksTaken;
		g.setColor(WALL_COLOUR);
		g.setFont(A3Constants.SMALL_FONT);
		g.drawString(countDown, TICKS_POSITION.x + 8, TICKS_POSITION.y);
		
		if (mode == 0){
			g.setColor(Color.BLUE);
			g.setFont(A3Constants.VERY_SMALL_FONT);
			g.drawString("Test", TICKS_POSITION.x, TICKS_POSITION.y + 20);
			//Test infomation
			String num = "" + walls.currentNumberOfWalls();
			g.setColor(WALL_COLOUR);
			g.setFont(A3Constants.MEDIUM_FONT);
			g.drawString(num, TICKS_POSITION.x, TICKS_POSITION.y + 40);
        
			String num2 = "" + walls.getNumberOfWalls();
			g.setColor(WALL_COLOUR);
			g.setFont(A3Constants.MEDIUM_FONT);
			g.drawString(num2, TICKS_POSITION.x, TICKS_POSITION.y + 60);
			
			String num3 = "" + bubbles.getbubblesHasCollected();
			g.setColor(WALL_COLOUR);
			g.setFont(A3Constants.MEDIUM_FONT);
			g.drawString(num3, TICKS_POSITION.x, TICKS_POSITION.y + 80);
        
			String num4 = "" + leoHasWon + " " + gameHasEnded + " " + getAllBubbles;
			g.setColor(WALL_COLOUR);
			g.setFont(A3Constants.MEDIUM_FONT);
			g.drawString(num4, TICKS_POSITION.x, TICKS_POSITION.y + 100);
			
			String num5 = "" + bubbles.getANewSize();
			g.setColor(WALL_COLOUR);
			g.setFont(A3Constants.MEDIUM_FONT);
			g.drawString(num5, TICKS_POSITION.x, TICKS_POSITION.y + 120);
			
			
		} else if (mode == 1){
			g.setColor(Color.GREEN);
			g.setFont(A3Constants.VERY_SMALL_FONT);
			g.drawString("Easy", TICKS_POSITION.x + 1, TICKS_POSITION.y + 20);
		} else if (mode == 2){
			g.setColor(Color.YELLOW);
			g.setFont(A3Constants.TINY_FONT);
			g.drawString("Normal", TICKS_POSITION.x + 1, TICKS_POSITION.y + 20);
		} else if (mode == 3){
			g.setColor(Color.RED);
			g.setFont(A3Constants.VERY_SMALL_FONT);
			g.drawString("Hard", TICKS_POSITION.x + 1, TICKS_POSITION.y + 20);
		}
					
	}
	//-------------------------------------------------------
	// Display Winner or Loser methods
	//-------------------------------------------------------         
    
	public void drawWinOrLose(Graphics g){
		if (leoHasWon && gameHasEnded && getAllBubbles){
			g.setColor(Color.RED);
			g.setFont(A3Constants.HUGE_FONT);
			g.drawString("You pass CS101!",WINNER_LOSER_INFO_POSITION.x + 10, WINNER_LOSER_INFO_POSITION.y + 100);
			g.setColor(Color.GREEN);
			g.setFont(A3Constants.MEDIUM_FONT);
			g.drawString("Try again press 'r'",WINNER_LOSER_INFO_POSITION.x + 120, WINNER_LOSER_INFO_POSITION.y + 150);
		} else if ((!leoHasWon || !getAllBubbles) && gameHasEnded){
			g.setColor(Color.RED);
			g.setFont(A3Constants.HUGE_FONT);
			g.drawString("You lose!",WINNER_LOSER_INFO_POSITION.x + 75, WINNER_LOSER_INFO_POSITION.y + 100);
			g.setColor(Color.GREEN);
			g.setFont(A3Constants.MEDIUM_FONT);
			g.drawString("Try again press 'r'",WINNER_LOSER_INFO_POSITION.x + 120, WINNER_LOSER_INFO_POSITION.y + 150);
		}
	}
	//-------------------------------------------------------
	// Display Title Screen methods
	//-------------------------------------------------------     
	public void drawTitleArea(Graphics g){
		if (isShowingTitleScreen){
			g.setColor(NICE_GRAY_COLOUR);
			g.fillRect(LEO_LEFT_AREA.x,LEO_LEFT_AREA.y,JFRAME_AREA_WIDTH,JFRAME_AREA_HEIGHT);
			g.setColor(Color.WHITE);
			g.setFont(A3Constants.MEDIUM_FONT);
			g.drawString("hche608, completed all stages",TICKS_POSITION.x + 20, TICKS_POSITION.y);
			g.drawString("To see the game, press mouse or press 't' key",TICKS_POSITION.x + 40, TICKS_POSITION.y + 20);
			g.drawString("To start/stop, press 's' or press mouse again",TICKS_POSITION.x + 60, TICKS_POSITION.y + 40);
			g.setColor(SLIDES_AREA_COLOUR);
			g.setFont(A3Constants.HUGE_FONT);
			g.drawString("Bubbleeeeee",TICKS_POSITION.x + 100, TICKS_POSITION.y + 100);
			g.setColor(Color.PINK);
			g.setFont(A3Constants.SMALL_FONT);
			g.drawString("New Features",TICKS_POSITION.x + 40, TICKS_POSITION.y + 140);
			g.drawString("To choose mode, press '0'(Test),'1'(Easy),'2'(Normal),'3'(Hard)",TICKS_POSITION.x + 40, TICKS_POSITION.y + 160);
			g.drawString("To change the colors, press 'c', To reset, press 'r'",TICKS_POSITION.x + 40, TICKS_POSITION.y + 180);
			g.drawString("To see /hide this screen, press 't'",TICKS_POSITION.x + 40, TICKS_POSITION.y + 200);
			g.setColor(Color.YELLOW);
			g.drawString("How to ... ",TICKS_POSITION.x + 40, TICKS_POSITION.y + 220);
			g.drawString("Collects all the bubbles, avoids the walls, get home square",TICKS_POSITION.x + 60, TICKS_POSITION.y + 240);
			g.drawString("The small bubble +speed, -size",TICKS_POSITION.x + 60, TICKS_POSITION.y + 260);
			g.drawString("The medium bubble changes speed randomly",TICKS_POSITION.x + 60, TICKS_POSITION.y + 280);
			g.drawString("The big bubble -speed, +size",TICKS_POSITION.x + 60, TICKS_POSITION.y + 300);
		}
	}
    
	//-------------------------------------------------------
	// Result And Get End Of Game methods
	//-------------------------------------------------------
    
	private boolean setResultAndGetEndOfGame(){
		if (cat.hasReachedHome(home.getArea())){
			leoHasWon = true;
			gameHasEnded = true;
			return false;
		} else if (walls.checkIfLeoAreaIntersectsAWall(cat.getArea())){
			gameHasEnded = true;
			return false;
		} return true;
	}
		
	//-------------------------------------------------------
	// Check number of the bubbles has collected methods
	//-------------------------------------------------------
	private void checkCollectAllBubbles(){
		if (bubbles.getbubblesHasCollected() == bubbles.getMaxbubbles()){
			getAllBubbles = true;
		}
	}
	
	//-------------------------------------------------------
	// Display Count Down methods
	//-------------------------------------------------------        
	private void countDown(){
		if (tickCounter % 8 == 0){
			ticksTaken--;
		}
		if (ticksTaken == 0){
			gameHasEnded = true;
			t.stop();
		}
	}
	//-------------------------------------------------------
	// Check Leo Intersects Bubble methods
	//-------------------------------------------------------        
	private boolean checkLeoInterserectsABubble(){
		return bubbles.checkIfLeoAreaIntersectsABubble(cat.getArea());
	}	
	//-------------------------------------------------------
	// Effected by Bubble methods
	//-------------------------------------------------------        
	private void effectByABubble(){
		if (bubbles.getbubblesHasCollected() != 0){					
			cat.changeSize(bubbles.getANewSize());
			cat.changeSpeed(bubbles.getSpeed());
			cat.setColor(bubbles.getColor());
		}
	}		
	//-------------------------------------------------------
	// Choose Mode methods  1=EASY, 2=NORMAL, 3=HARD, 0=TEST
	//------------------------------------------------------- 
    
	private void chooseMode(int num){
		if(num == 0){
			bubbles = new BubblesManager(2);
			walls = new WallsManager(1);
			ticksTaken = 40;
		}else if (num == 2){
			bubbles = new BubblesManager(8);
			walls = new WallsManager(11);
			ticksTaken = 50;
		}else if(num == 3){
			bubbles = new BubblesManager(11);
			walls = new WallsManager(13);
			ticksTaken = 60;
		}else{
			bubbles = new BubblesManager(5);
			walls = new WallsManager(8);
			//ticksTaken = 40;
		}
		repaint();
	}
} 



