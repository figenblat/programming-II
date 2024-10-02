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

public class OrderQueue implements QueueADT<Order>,  Iterable<Order>{
	
	private LinkedOrder front;
	private LinkedOrder back;
	private int size;
	
	/*
	 * creates and returns a new OrderIterator beginning
	 * with the current vazlue of front
	 */
	public Iterator<Order> iterator(){
		OrderIterator orderQueue = new OrderIterator(front);
		return orderQueue;
		
	}
	
	/*
	 * method that adds a new LinkedOrder containing newElement
	 * to the back of the queue, updating the size variable
	 * and front/back references appropriately
	 * @param newElement- Order to be added to back of queue
	 * 
	 */

	@Override
	public void enqueue(Order newElement) {
		
		LinkedOrder upNext = new LinkedOrder(newElement);
		
		if(front ==null && back ==null) {
			back = upNext;
			front = upNext;
			size++;
			return;
		}
		
		back.setNext(upNext);
		back = upNext;
		size ++;
		
		
	}
	
	/*
	 * method that removes the next LinkedOrder from the front 
	 * of the queue and returns its order, updating the size
	 * variable and front/back references appropriately
	 * @throws NoSuchElementException - if queue is empty
	 * @return Order- order that is removed
	 */

	@Override
	public Order dequeue() throws NoSuchElementException {
		
		Order order = front.getOrder();
		
		if (order == null) {
			throw new NoSuchElementException("Queue is empty");
		}
		else if(size == 1) {
			back = null;
			front =null;
			size--;
			return order;
			
		}
		else {
			front = front.getNext();
			size--;
			return order;
		}
	}
	/*
	 * method that returns the order from the LinkedOrder at the front
	 * of the queue without removing the LinkedOrder from the queue.
	 * @return the order at the front of the queue
	 */

	@Override
	public Order peek() {
		return front.getOrder();
	}
	
	/*
	 * method that returns true if and only if the queue is empty
	 * @return true - if the queue is empty
	 * @return false - if the queue is not empty
	 */

	@Override
	public boolean isEmpty() {
		if (front == null) {
			size =0;
			return true;
		}
		else {
			return false;
		}
		
	}

	
	/* Creates and returns a String representation 
	 * of this OrderQueue* using an enhanced-for loop. 
	 * For example, a queue with three Orders 
	 * might look like this:
	 * 1001: fries (2) -> 1002: shake (1) -> 1003: burger(3) -> END
	 * @return A String representation of the queue
	 */
	@Override 
	public String toString() {
		if(this.size== 0)
			return"";
		String qString="";
		for(Order o:this) {
			qString+=o.toString();
			qString+=" -> ";
			}
		qString+="END";
		return qString;
		}

	

}
