//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P04 Carrot Patch
// Course: CS 300 Spring 2021
//
// Author: Noa Figenblat
// Email: figenblat@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

public class RestartButton extends Button{

	public RestartButton( float x, float y) {
		super("Restart", x, y);
		
	}
	@Override
	  public void mousePressed() {
	    if (isMouseOver()) {
	      //System.out.println("Restart button was pressed.");
	    	Button.processing.removeAll();
	    	
	  }
	}

}
