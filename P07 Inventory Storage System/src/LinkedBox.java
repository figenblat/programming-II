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

public class LinkedBox {
	private Box box;
	private LinkedBox next;
	
	
	/*
	 * creates a new LinkedBox node with given box and next fields
	 * @param box - the box carried by this linked box
	 * @param next - reference to the next linked box in the list
	 */
	public LinkedBox(Box box, LinkedBox next) {
		this.next=next;
		this.box = box;
	}
	/*
	 * creates a new LinkedBox with specified box and null as next field
	 * @param box - the box carried by this linked box
	 */
	public LinkedBox(Box box) {
		this.box =box;
		
	}
	/*
	 * returns the next linked box node
	 * @return the next 
	 */
	public LinkedBox getNext() {
		return next;
		
	}
	/*
	 * returns the data field box
	 * @return the box
	 */
	public Box getBox() {
		return box;
		
	}
	/*
	 * sets the link to the next linked box node 
	 * @param next - the next to set 
	 */
	public void setNext(LinkedBox next) {
		this.next = next;
	}
	/*
	 * returns a string representation of this Linked box
	 * @return a string representation of this linked megablock object
	 */
	@Override
	public java.lang.String toString(){
		if (getNext()!= null) {
			return box.toString() + " -> ";
		}
		else {
			return box.toString() +" -> END";
		}
		
	}
	
}
