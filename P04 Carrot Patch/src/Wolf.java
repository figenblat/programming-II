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

public class Wolf extends Animal{
	
	// path to the wolf image file
	private static final String WOLF = "images" + File.separator + "wolf.png";
	
	private static int scanRange = 120; // scanning range to look for a rabbit
	// in the neighborhood
	private static int nextID = 1; // identifier of the next Wolf to be created
	private static final String TYPE = "W"; // A String that represents the Wolf type
	private final int ID; // positive number that represents the order of this Wolf
	private int rabbitEatenCount; // Number of rabbits that the current Wolf has eaten so far
	
	/**
	* Creates a new Wolf object at a random position of the display window
	*
	* @param processing CarrotPatch object which represents the display window
	*/
	public Wolf() {
		super(WOLF);
		ID = nextID;
		this.label = TYPE + ID; // String that identifies the current rabbit
		nextID++;	
	}
	/*
	 * getter for the count of rabbits eaten by a wolf
	 */
	public int getRabbitEatenCount(){
		return rabbitEatenCount;
	} // gets rabbitEatenCount instance field
	/*
	 * getter for the scan range of the wolf
	 */
	public static int getScanRange(){
		return scanRange;
	} // gets the scanRange of a Wolf
	
	/**
	* Moves to the position of the specified rabbit passed as input, and eats it.
	* The eaten rabbit will be removed from the patch and he number of eaten
	* rabbits by this wolf is incremented by one.
	* @param rabbit rabbit to eat by this wolf
	*/
	public void eatRabbit(Rabbit rabbit) {
	// if the mouse is over the current Wolf, release it so the Wolf can move
	// ahead to the position of rabbit and eat it.
	if (isMouseOver())
	this.mouseReleased();
	// TODO
	// 1. set the position of the current Wolf to the position of the rabbit
	// 2. remove the rabbit from the patch
	// 3. increment the number of eaten rabbits by one
	setX(rabbit.getX());
	setY(rabbit.getY());
	
	for (int i = 0; i< Button.processing.objects.size(); i++) {
		if(Button.processing.objects.get(i) == rabbit) {
			Button.processing.objects.remove(i);
			rabbitEatenCount ++;
			break;
		}
	}
	
	
	}
	
	/**
	* Defines the action of this wolf in the carrot patch. This wolf lookup for
	* rabbits in its neighborhood (Wolf.scanRange) and eats the first found rabbit
	* only. This method also displays the number of rabbit eaten by this wolf if any.
	*/
	@Override
	public void action() {
	// TODO
	//Traverse processing.objects arraylist, search for the first rabbit which
	// is close to this wolf with respect to Wolf.scanRange, and eats it.
	// If no rabbit is found in the neighborhood, nothing will be done.
		
		for (int i = 0; i<Button.processing.objects.size();i++) {
		//	if(Wolf.scanRange ==  ) {
				
			//}
		}
		
	if (rabbitEatenCount > 0)
	displayrabbitEatenCount(); // display rabbitEatenCount
	}
	
	/**
	* Displays the number of eaten rabbits if any on the top of the Wolf image
	*/
	public void displayrabbitEatenCount() {
	processing.fill(0); // specify font color: black
	// display rabbitEatenCount on the top of the Wolf’s image
	processing.text(rabbitEatenCount, this.getX(), this.getY() - this.image.height / 2 - 6);
	}
}
