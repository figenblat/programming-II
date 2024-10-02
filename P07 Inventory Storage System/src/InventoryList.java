//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P07 Inventory Storage System
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

public class InventoryList {
	private LinkedBox head;
	private LinkedBox tail;
	private int size;
	private int yellowCount;
	private int blueCount;
	private int brownCount;

	public InventoryList() {
		 
		
		
	}
	
	/*
	 * returns the size of this list 
	 * @return - the size of this LinkedBox List
	 */
	
	public int size() {
	return this.size;
	}
	/*
	 * Checks whether this LinkedBoxList is empty
	 * @return true if this LinkedBoxList is empty,
	 *  false otherwise
	 */
	public boolean isEmpty() {
		if (size != 0 ) {
			return false;	
		}
		else {
			return true;
		}
		
	}
	/*
	 * Removes all of the elements from this list. 
	 * The list will be empty after this call returns.
	 */
	public void clear() {
		this.size=0;
		this.head=null;
		this.tail=null;
		this.yellowCount=0;
		this.blueCount=0;
		this.brownCount=0;
		
	}
	/*
	 *Adds a brown box at the end of this inventory list
	 *@param brownBox - new brown box to be added to this list
	 *@throws java.lang.IllegalArgumentException - with a
	 * descriptive error message if brownBox is null or if t
	 * he color of the specific brownBox is not equal to Color.BROWN
	 */
	public void addBrown(Box brownBox) {
		if (brownBox == null ||brownBox.getColor()!= Color.BROWN) {
			throw new IllegalArgumentException ("brownBox is either null, or is not the color brown");
		}
		else {
			LinkedBox addBrownBox = new LinkedBox(brownBox);
			tail.setNext(addBrownBox);
			brownCount ++;
			size++;
		}
	}
	/*
	 * Adds a new yellow box at the head of this list
	 * @param yellowBox - new box to be added to this list
	 * @throws java.lang.IllegalArgumentException - with a 
	 * descriptive error message if yellowBox is null 
	 * or if its color does not equal to Color.YELLOW
	 */
	public void addYellow(Box yellowBox) {
		if (yellowBox == null || yellowBox.getColor()!= Color.YELLOW) {
			throw new IllegalArgumentException ("yellowBox is either null, or is not the color yellow");
		}
		else {
			LinkedBox addYellowBox = new LinkedBox(yellowBox);
			head = addYellowBox;
			yellowCount ++;
			size++;
		}
	}
	/*
	 * Adds a new blue box at the top of blue boxes 
	 * if the list contains any blue box. Blue boxes must be added
	 *  at the bottom of yellow boxes and at the top of all 
	 *  the brown boxes if any. This means that a new blue 
	 *  box must be added at index yellowCount.
	 *  @param blueBox - new box to be added to this list
	 *  @throws java.lang.IllegalArgumentException 
	 *  - with a descriptive error message if blueBox 
	 *  is null or if it does not have a Color.BLUE color
	 */
	public void addBlue(Box blueBox) {
		LinkedBox blue1 = new LinkedBox(blueBox);
		LinkedBox yellow1 = new LinkedBox(new Box(Color.YELLOW));
	
		if (blueBox == null || blueBox.getColor()!= Color.BLUE) {
			throw new IllegalArgumentException ("blueBox is either null, or is not the color Blue");
		}
		
		if (head ==null) {
			head=yellow1;
			yellow1.setNext(blue1);
			blue1.setNext(null);
			yellowCount++;
			blueCount++;
		}
		
		else if(head!= null) {
			LinkedBox currentBox = head.getNext();
			if(currentBox.getBox().getColor()!= Color.YELLOW) {
				if(currentBox.getBox().getColor()==Color.BROWN) {
					blue1.setNext(currentBox);
					currentBox = blue1;
					blueCount ++;
				}
				else if(currentBox.getBox().getColor()==Color.BLUE) {
					currentBox.setNext(blue1);
					blue1.setNext(null);
				}
			}
		}
		
	}
	/*
	 * Returns the element stored at position index of this list without removing it.
	 * @param index- position within this list 
	 * @return the box stored at position index of this list
	 */
	public Box get(int index) {
		LinkedBox tempBox = head;
		Box boxReturned = null;
		
		for (int i = 0; i <size; i++) {
			if (i == index) {
				 boxReturned = tempBox.getBox();
			}
			else {
				tempBox = tempBox.getNext();
			}
			
		}
		return boxReturned;
	}
	/*
	 * Removes and returns the box at the head of this list if its color is yellow
	 * @return a reference to the removed element
	 */
	public Box removeYellow() {
		if (head.getBox().getColor()==Color.YELLOW) {
			Box removedYellow = new Box(Color.YELLOW);
			head = null;
			return removedYellow;
		}
		else {
			return null;
		}
		
	}
	/*
	 * Removes and returns the element at the tail of this list if it has a brown color
	 * @return a reference to the removed element
	 */
	public Box removeBrown() {
		if (tail.getBox().getColor()==Color.BROWN) {
			Box removedBrown = new Box(Color.BROWN);
			head = null;
			return removedBrown;
		}
		else {
			return null;
		}
	}
	/*
	 * removes and returns a box given its inventory number from this list
	 * @param inventoryNumber- inventory number of the box to be removed from this list
	 * @return a refrence to the removed element
	 */
	public Box removeBox(int inventoryNumber) {
		LinkedBox current = head;
		LinkedBox previous = null;
		//if (current!= null && previous.getBox().getInventoryNumber()!= inventoryNumber) {
			previous = current;
			current = current.getNext();
		//}
		
		Box remove = current.getBox();
		if (previous != null) {
			if(current.getNext()==null) {
				tail = previous;
			}
			previous.setNext(current.getNext());
		}
		else {
			head = head.getNext();
		}
		if (remove.getColor() == Color.BLUE) {
			blueCount --;
		}
		else if(remove.getColor()==Color.YELLOW) {
			yellowCount--;
		}
		else  {
			brownCount--;
		}
		size --;
		return remove;
	}
	/*
	 * returns the number of brown boxes stored in this list 
	 * @returns the BrownCount
	 */
	public int getBrownCount() {
		return brownCount;
	}
	/*
	 * returns the number of yellow boxes stored in this list 
	 * @return the yellowCount
	 */
	public int getYellowCount() {
		return yellowCount;
		
	}
	/*
	 * returns the number of blue boxes stored in this list 
	 * @return the blueCount
	 */
	public int getBlueCount() {
		return blueCount;
		
	}
	/*
	 * returns a string representation of the contents of this list 
	 */
	@Override
	public java.lang.String toString(){
		LinkedBox boxToString = head;
		String returnedString = "";
		if (size == 0) {
			return returnedString;
			
		}
		else {
			while(boxToString.getNext() != null) {
				returnedString += boxToString.toString() +" ->";
				boxToString = boxToString.getNext();
			}
		}
		returnedString += " ->END";
		return returnedString;
	}
}
