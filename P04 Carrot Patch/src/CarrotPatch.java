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


import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class CarrotPatch extends PApplet {
	private PImage backgroundImage;
	protected ArrayList<GUIListener> objects;
	
	
	
	// main method
	public static void main(String[] args) {
		PApplet.main("CarrotPatch");
		

	}
	/**
	   * Defines the initial environment properties such as screen size and to load background images
	   * and fonts as the program starts. It also initializes the backgroundImage, the data fields, and
	   * sets the display window for the different graphic objects which will be drawn in this
	   * application
	   */
	  @Override
	  public void setup() {
	    carrotPatchSettings(); // define the graphic settings of this application 
	    // TODO:
	    
	    Carrots.settings(this);
	    Button.setProcessing(this);
	    Animal.setProcessing(this);
	    Rabbit.setProcessing(this);
	    AddRabbitButton.setProcessing(this);
	    Wolf.setProcessing(this);
	    AddWolfButton.setProcessing(this);
	   

		// create the list of objects
		objects = new ArrayList<GUIListener>();
		
		// load the background image 
		backgroundImage = this.loadImage("images" + File.separator+ "background.png");
		

	    // Sets this CarrotPatch as display window for all the graphic Objects (Button, Animal, and
	    // Carrots)
		
		

	    // Adds buttons to the display window
		
		PlantCarrotsButton plantCarrots = new PlantCarrotsButton(43f, 16f);
		AddRabbitButton addRabbit = new AddRabbitButton( 129f, 16f);
		AddWolfButton addWolf = new AddWolfButton(215f,16f);
		RestartButton restart = new RestartButton(301f,16f);
		
		objects.add(plantCarrots);
		objects.add(addRabbit);
		objects.add(addWolf);
		objects.add(restart);
		

	  }

	  /**
	   * Sets the display window title, text allignment, image mode, rectangle mode, and activates this
	   * PApplet object to listen to the mouse events and user inputs
	   */
	  private void carrotPatchSettings() {
	    this.getSurface().setTitle("Carrot Patch"); // Displays text in the title of the display window
	    this.textAlign(PApplet.CENTER, PApplet.CENTER); // Sets the current alignment for drawing text
	                                                    // to CENTER
	    this.imageMode(PApplet.CENTER); // Sets the location from which images are drawn to CENTER
	    this.rectMode(PApplet.CORNERS); // Sets the location from which rectangles are drawn.
	    // rectMode(CORNERS) interprets the first two parameters of rect() method as the location of one
	    // corner, and the third and fourth parameters as the location of the opposite corner.
	    // rect() method draws a rectangle to the display window
	    this.focused = true; // Confirms that our Processing program is "focused," meaning that it is
	                         // active and will accept mouse or keyboard input.
	  }


	  /**
	   * Sets the size of the application display window
	   */
	  @Override
	  public void settings() {
	    size(800, 600); // sets the size of the display window to 800 x 600 pixels
	  }

	  /**
	   * Callback method called in an infinite loop. It draws the Jungle Park's window display
	   */
	  public void draw() {
	  	// TODO: 
	  	
	    // draw the background image at the center of the display window
		 this.image(backgroundImage, this.width/2, this.height/2);

	    // Draw carrots
		 Carrots.draw();

	    // traverse the objects list and draw all the interactive objects
		  for(int i = 0; i<objects.size();i++) {
			  if(objects.get(i) != null) {
				 objects.get(i).draw();
			  }
		  }

	  }

	  /**
	   * Callback method called each time the mouse is pressed
	   */
	  @Override
	  public void mousePressed() {
	    // TODO: traverse the objects list and call mousePressed() method defined for every interactive
	    // object
		  
		  for (int i = 0; i < objects.size();i++) {
			  if (objects.get(i) != null ) { 
				  objects.get(i).mousePressed();
				  break;
			  }
				  
			  }
		  }

	  

	  /**
	   * Callback method called each time the mouse is released
	   */
	  @Override
	  public void mouseReleased() {
	    // TODO:
	    // traverse the objects list and call mouseReleased() method defined for every interactive
	    // object
		  
		  for (int i = 0; i< objects.size();i++) {
			  if (objects.get(i) != null) {
				  objects.get(i).mouseReleased();
			  }
		  }
			  
		  }

	  

	  /**
	   * Callback method called each time the user presses a key
	   */
	  @Override
	  public void keyPressed() {

	    switch (Character.toUpperCase(this.key)) {
	      case 'R':
	        // TODO:
	        objects.add(new Rabbit());

	        break;
	      case 'W':
	        // TODO:
	    	  objects.add(new Wolf());

	        break;
	      case 'D':
	        // TODO:
	        // Remove an animal from this carrot patch if the mouse is over it
	        // Traverse the objects list and consider only animal objects in your search
	        // Only one animal will be removed. If the mouse is over more than one animal
	        // (overlapping animals) when the key-D is pressed, the first one in the objects
	        // list (stored at the lowest index) will be removed.
	    	  
	    	 for (int i =0; i<objects.size();i++) {
	    		if(objects.get(i).isMouseOver()) {
	    			 if(objects.get(i) instanceof Rabbit || objects.get(i) instanceof Wolf) {
	    				 objects.remove(i);
	    				 break;
	    				 
	    			}
	    			 
	    		 }
	    	 }

	    }

	  }

	  /**
	   * Removes all the animals and planted carrots from this carrot patch
	   */
	  public void removeAll() {
	    // TODO

	    // Remove all the carrots from this CarrotPatch.
	    // [Hint] check whether there is a method in the Carrots class which can help implement this
	    // behavior
		  
		  Carrots.removeAll();


	    // Traverse the objects ArrayList and remove only the instances of Animal from the list
	    // [Hints]:
	    // DO NOT USE a for-each loop, use a normal for loop or a while loop
	    // If you use a for loop to traverse the objects list and remove the animals, make sure
	    // to decrement the index i each time you remove an animal before going to the next iteration.
	    // Otherwise, the next element will be skipped
		  
		  for(int i = 0; i<objects.size();i++) {
			  if(objects.get(i) instanceof Rabbit || objects.get(i) instanceof Wolf) {
				  objects.remove(i);
				  i--;
			  }
		  }


	  }
}
