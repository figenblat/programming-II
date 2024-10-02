//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P10 Order Up 2
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

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * A max-heap implementation of a priority queue for Orders, where the Order with the LONGEST prep 
 * time is returned first instead of the strict first-in-first-out queue as in P08.
 * 
 * TODO: Make sure Order implements Comparable<Order> so that this class can implement the
 * PriorityQueueADT without error!
 */
public class OrderPriorityQueue implements PriorityQueueADT<Order>{

  // Data fields; do not modify
  private Order[] queueHeap;
  private int size;
  
  
  private static Comparator<Order> comparator;

  
  /**
   * Constructs a PriorityQueue for Orders with the given capacity
   * 
   * @param capacity the initial capacity for the queue
   * @throws IllegalArgumentException if the given capacity is 0 or negative
   */
  public OrderPriorityQueue(int capacity) {
	  if(capacity <=0) {
		  throw new IllegalArgumentException("Invalid capacity.");
	  }
	  size=0;
	  queueHeap = new Order[capacity];
  }
  
  /**
   * Inserts a new Order into the queue in the appropriate position using a heap's add logic.
   * 
   * @param newOrder the Order to be added to the queue
   */
  @Override
  public void insert(Order newOrder) {
	 
    if(queueHeap[0] ==null) {
    	queueHeap[0] = newOrder;
    	size++;
    }
    else if(queueHeap.length == size) {
    	Order[] newQueueHeap;
    	int capacity = queueHeap.length;
		newQueueHeap= Arrays.copyOf(queueHeap, capacity *2);
    	capacity = capacity*2;
    	
    }
    else {
    	queueHeap[size]= newOrder;
    	if(queueHeap[size].compareTo(queueHeap[size-1])==1) {
    		percolateUp(queueHeap, size);
    		size++;
    	}
    	else if(queueHeap[size].compareTo(queueHeap[size-1])==-1) {
    		percolateDown(queueHeap, size, size);
    		size++;
    	}
    	else {
    		size++;
    	}
    	
    	
    }
    
    		
 }
  
  
  
  /**
   * A utility method to percolate Order values UP through the heap; see figure 13.3.1 in zyBooks
   * for a pseudocode algorithm.
   * 
   * @param heap an array containing the Order values to be percolated into a valid heap
   * @param orderIndex the index of the Order to be percolated up
   */
  protected static void percolateUp(Order[] heap, int orderIndex) {
	int parent = (orderIndex-1)/2;
	if(heap[orderIndex].getPrepTime()>heap[parent].getPrepTime()) {
		Order temp = heap[orderIndex];
		heap[orderIndex]=heap[parent];
		heap[parent]=temp;
		percolateUp(heap,parent);
	}
	  
  }
  
  
  /**
   * Return the Order with the longest prep time from the queue and adjust the queue accordingly
   * 
   * @return the Order with the current longest prep time from the queue
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public Order removeBest() {
	  if (isEmpty()) {
		  throw new NoSuchElementException("Queue is empty.");
	  }
	  Order longest = queueHeap[0];
	  for(int i = 0; i<size;i++) {
		  queueHeap[i]=queueHeap[i+1];
	  }
	  size--;
	  return longest;
  }
  
  /**
   * A utility method to percolate Order values DOWN through the heap; see figure 13.3.2 in zyBooks
   * for a pseudocode algorithm.
   * 
   * @param heap an array containing the Order values to be percolated into a valid heap
   * @param orderIndex the index of the Order to be percolated down
   * @param size the number of initialized elements in the heap
   */
  protected static void percolateDown(Order[] heap, int orderIndex, int size) {
     if (orderIndex>=size) {
    	 return;
     }
     int right = 2*orderIndex+2;
     int left = 2*orderIndex+1;
     int max = orderIndex;
     
     if(right<=size && heap[right].compareTo(heap[orderIndex])==1) {
    	 max = right;
     }
     else if (left<=size && heap[left].compareTo(heap[orderIndex])==1) {
    	 max = left;
     }
     
     if(orderIndex!=max) {
    	 Order temp = heap[orderIndex];
    	 heap[orderIndex]=heap[max];
    	 heap[max]=temp;
    	 percolateDown(heap,max,size);
     }
  }
  
  /**
   * Return the Order with the highest prep time from the queue without altering the queue
   * @return the Order with the current longest prep time from the queue
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public Order peekBest() {
	  if (isEmpty()) {
		  throw new NoSuchElementException("The queue is empty");
	  }
	  else {
		  Order longest = queueHeap[0];
		  return longest;
	  }
  }
  
  /**
   * Returns true if the queue contains no Orders, false otherwise
   * @return true if the queue contains no Orders, false otherwise
   */
  @Override
  public boolean isEmpty() {
    if (size==0) {
    	return true;
    }
    else {
    	return false;
    }
  }
  
  /**
   * Returns the number of elements currently in the queue
   * @return the number of elements currently in the queue
   */
  public int size() {
    return size;
  }
  
  /**
   * Creates a String representation of this PriorityQueue. Do not modify this implementation; this
   * is the version that will be used by all provided OrderPriorityQueue implementations that your
   * tester code will be run against.
   * 
   * @return the String representation of this PriorityQueue, primarily for testing purposes
   */
  public String toString() {
    String toReturn = "";
    for (int i=0; i < this.size; i++) {
      toReturn += queueHeap[i].getID()+"("+queueHeap[i].getPrepTime()+")";
      if (i < this.size-1) toReturn += ", ";
    }
    return toReturn;
  }
  
}
