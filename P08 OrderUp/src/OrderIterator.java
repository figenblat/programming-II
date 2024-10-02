//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P08 Order Up
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


import java.util.Iterator;
import java.util.NoSuchElementException;

public class OrderIterator implements Iterator<Order>{
	
	private LinkedOrder current;
	
	
	/*
	 * constructor which initializes current to the provided
	 * starting LinkedOrder
	 *@param start - the starting LinkedOrder
	 */
	public OrderIterator(LinkedOrder start){
		current = start;
		
	}
	
	/*
	 * method which returns true if and only if the 
	 * iteration has more orders
	 * @return true - if there are more orders
	 * @return false - if there are no more orders
	 */

	@Override
	public boolean hasNext() {
		LinkedOrder tempCurrent = current.getNext();
		if (tempCurrent == null) {
			return false;
			
		}
		else {
			return true;
		}
	}
	
	/*
	 * Method to return the next Order and updates the current
	 * field to the next Order
	 * @throws NoSuchElementException - iteration does not have more orders to return
	 * @return the order at current
	 */

	@Override
	public Order next() throws NoSuchElementException {
		LinkedOrder tempCurrent = current;
		
	
		if(!hasNext()) {
			
			throw new NoSuchElementException("No more orders to return.");
			
		}
		
		current = current.getNext();	
		return tempCurrent.getOrder();

	

	

	}
}
