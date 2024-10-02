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

public class PlantCarrotsButton extends Button {
	
	public PlantCarrotsButton( float x, float y) {
		super("Plant Carrots", x, y);
		
		
	}
	
	@Override
	  public void mousePressed() {
	    if (isMouseOver())
	      //System.out.println("Plant carrots button was pressed.");
	    	Carrots.plant();
	  }
	
	

}
