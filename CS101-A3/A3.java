/*
* Purpose: application for the
* game.
* 
* Author: Adriana Ferraro
* Date: S2 2013
*/

import javax.swing.*;

public class A3 {
    
	public static final int JFRAME_AREA_WIDTH = A3Constants.JFRAME_AREA_WIDTH;
	public static final int JFRAME_AREA_HEIGHT = A3Constants.JFRAME_AREA_HEIGHT;;
    
	public static void main(String[] args) {
		JFrame gui = new A3JFrame("Bubbleeeeee by hche608", 3, 3, JFRAME_AREA_WIDTH, JFRAME_AREA_HEIGHT);
	}
}
