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

public class AddWolfButton extends Button{

	public AddWolfButton( float x, float y) {
		super("Add Wolf", x, y);
		
	}

	
	@Override
	  public void mousePressed() {
	   if (isMouseOver())
	     // System.out.println("Add Wolf button was pressed.");
	    	
	    	 Button.processing.objects.add(new Wolf());
	  }

}
