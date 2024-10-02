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

public class AddRabbitButton extends Button {

	public AddRabbitButton( float x, float y) {
		super("Add Rabbit", x, y);
		
	}
	@Override
	  public void mousePressed() {
	    //if (isMouseOver()) 
	     // System.out.println("Add Rabbits button was pressed.");
	    	
	    	Button.processing.objects.add(new Rabbit());
	    	
	    	

	}
}
