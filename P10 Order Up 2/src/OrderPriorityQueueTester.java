import java.util.NoSuchElementException;

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

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * OrderPriorityQueue.
 * 
 * You MAY add additional public static boolean methods to this class if you like, and any private
 * static helper methods you need.
 */
public class OrderPriorityQueueTester {
  
  /**
   * Checks the correctness of the isEmpty method of OrderPriorityQueue.
   * 
   * You should, at least:
   * (1) create a new OrderPriorityQueue and verify that it is empty
   * (2) add a new Order to the queue and verify that it is NOT empty
   * (3) remove that Order from the queue and verify that it is empty again
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testIsEmpty() {
    Order.resetIDGenerator();
    boolean t1 = false;
    boolean t2 = false;
    boolean t3 = false;
    //test 1
    OrderPriorityQueue test = new OrderPriorityQueue(10);
    if(test.isEmpty()==true) {
    	System.out.println("test 1 for testIsEmpty() passed");
    	t1 = true;
    }
    
  
    //test 2 
    Order order1 = new Order("Pizza", 10);
    
    test.insert(order1);
    
    if(test.isEmpty()==false) {
    	System.out.println("test 2 for testIsEmpty() passed");
    	t2 = true;
    }
    
    //test 3
    test.removeBest();
    
    if(test.isEmpty()==true) {
    	System.out.println("test 3 for testIsEmpty() passed");
    	t3 = true;
    }
    
    if(t1 == true && t2 == true && t3 == true) {
    	return true;
    }
    else {
    	return false;
    }
  }
  
  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * You should, at least:
   * (1) create a new OrderPriorityQueue and add a single order with a large prepTime to it
   * (2) use the OrderPriorityQueue toString method to verify that the queue's internal structure
   *     is a valid heap
   * (3) add at least three more orders with DECREASING prepTimes to the queue and repeat step 2.
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testInsertBasic() {
    Order.resetIDGenerator();
    boolean t1=false;
    boolean t2= false;
    
    //test 1 - creating new OrderPriorityQueue and adding a single order
    OrderPriorityQueue test = new OrderPriorityQueue(10);
    Order cake = new Order("Cake", 60);
    test.insert(cake);
   
   
    if(test.toString().equals("1001(60)")) {
    	t1 = true;
    	System.out.println("test 1 testInsertBasic() passed");
    	
    }
    
    //test.toString();
    
    Order pasta = new Order("Pasta", 50);
    Order burger = new Order("Burger", 40);
    Order frenchFries = new Order("French Fries", 30);
    
    test.insert(pasta);
    test.insert(burger);
    test.insert(frenchFries);
   
    
    if(test.toString().equals("1001(60), 1002(50), 1003(40), 1004(30)")) {
    	t2 = true;
    	System.out.println("test 2 testInsertBasic() passed");
    }
    
    if(t1==true && t2==true) {
    	return true;
    }
    else {
    	return false; 
    }
    	
  }
    
  
  /**
   * Checks the correctness of the percolateUp method of OrderPriorityQueue.
   * 
   * You should, at least:
   * (1) create an array of at least four Orders that represents a valid heap
   * (2) add a fifth order at the next available index that is NOT in a valid heap position
   * (3) pass this array to OrderPriorityQueue.percolateUp()
   * (4) verify that the resulting array is a valid heap
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testPercolateUp() {
    Order.resetIDGenerator();
    OrderPriorityQueue test = new OrderPriorityQueue(10);
    Order cake = new Order("Cake", 60);
    Order pasta = new Order("Pasta", 50);
    Order burger = new Order("Burger", 40);
    Order frenchFries = new Order("French Fries", 30);
    Order pastry = new Order("Pastry", 100);
    
    test.insert(cake);
    test.insert(pasta);
    test.insert(burger);
    test.insert(frenchFries);
    test.insert(pastry);
    
    
    
    if(test.toString().equals("1005(100), 1001(60), 1003(40), 1004(30), 1002(50)")) {
    	System.out.println("all tests in testPercolateUp() passed");
    	return true;
    }
    else {
    	return false;
    }
  }
  
  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * You should, at least:
   * (1) create a new OrderPriorityQueue with at least 6 orders of varying prepTimes, adding them
   *     to the queue OUT of order
   * (2) use the OrderPriorityQueue toString method to verify that the queue's internal structure
   *     is a valid heap
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testInsertAdvanced() {
    Order.resetIDGenerator();
    
    OrderPriorityQueue test = new OrderPriorityQueue(10);
    Order cake = new Order("Cake", 60);
    Order pasta = new Order("Pasta", 50);
    Order burger = new Order("Burger", 40);
    Order frenchFries = new Order("French Fries", 30);
    Order ketchup = new Order("Ketchup", 1);
    Order salad = new Order("Salad", 10);
    
   
    test.insert(burger);
    test.insert(salad);
    test.insert(ketchup);
    test.insert(cake);
    test.insert(pasta);
    test.insert(frenchFries);
    
    
    
    if(test.toString().equals("1001(60), 1002(50), 1005(1), 1006(10), 1003(40), 1004(30)")) {
    	System.out.println("all tests in testInsertAdvanced() passed");
    	return true;
    }
    else {
    	return false;
    }
  }
  
  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * You should, at least:
   * (1) create an array of at least five Orders where the Order at index 0 is NOT in valid heap
   *     position
   * (2) pass this array to OrderPriorityQueue.percolateDown()
   * (3) verify that the resulting array is a valid heap
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testPercolateDown() {
    Order.resetIDGenerator();
    
    OrderPriorityQueue test = new OrderPriorityQueue(10);
    Order cake = new Order("Cake", 60);
    Order pasta = new Order("Pasta", 50);
    Order burger = new Order("Burger", 40);
    Order frenchFries = new Order("French Fries", 30);
    Order ketchup = new Order("Ketchup", 1);
   
    
   
    test.insert(burger);
    test.insert(cake);
    test.insert(pasta);
    test.insert(frenchFries);
    test.insert(ketchup);
    
   
    
    if(test.toString().equals("1001(60), 1003(40), 1002(50), 1004(30), 1005(1)")) {
    	System.out.println("all tests in testPercolateDown() passed");
    	return true;
    }
    else {
    	return false;
    }
  }
  
  /**
   * Checks the correctness of the removeBest and peekBest methods of OrderPriorityQueue.
   * 
   * You should, at least:
   * (1) create a new OrderPriorityQueue with at least 6 orders of varying prepTimes, adding them
   *     to the queue in whatever order you like
   * (2) remove all but one of the orders, verifying that each order has a SHORTER prepTime than
   *     the previously-removed order
   * (3) peek to see that the only order left is the one with the SHORTEST prepTime
   * (4) check isEmpty to verify that the queue has NOT been emptied
   * (5) remove the last order and check isEmpty to verify that the queue HAS been emptied
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testPeekRemove() {
    Order.resetIDGenerator();
    
    boolean t1 = false;
    boolean t2 = false;
    boolean t3 = false;
    boolean t4 = false;
    boolean t5 = false;
    boolean t6 = false;
    boolean t7 = false;
    
    OrderPriorityQueue test = new OrderPriorityQueue(10);
    Order cake = new Order("Cake", 60);
    Order pasta = new Order("Pasta", 50);
    Order burger = new Order("Burger", 40);
    Order frenchFries = new Order("French Fries", 30);
    Order ketchup = new Order("Ketchup", 1);
    Order salad = new Order("Salad", 10);
    
  
    test.insert(cake);
    test.insert(pasta);
    test.insert(burger);
    test.insert(frenchFries);
    test.insert(salad);
    test.insert(ketchup);
    
    //testing removeBest()
    test.removeBest();
    if (test.toString().equals("1002(50), 1003(40), 1004(30), 1006(10), 1005(1)")) {
    	System.out.println("test1 for testPeekRemove() passed");
    	t1 = true;
    }
    test.removeBest();
    if (test.toString().equals("1003(40), 1004(30), 1006(10), 1005(1)")) {
    	System.out.println("test2 for testPeekRemove() passed");
    	t2 = true;
    }
    test.removeBest();
    if (test.toString().equals("1004(30), 1006(10), 1005(1)")) {
    	System.out.println("test3 for testPeekRemove() passed");
    	t3 = true;
    }
    test.removeBest();
    if (test.toString().equals("1006(10), 1005(1)")) {
    	System.out.println("test4 for testPeekRemove() passed");
    	t4 = true;
    }
    test.removeBest();
    if (test.toString().equals("1005(1)")) {
    	System.out.println("test5 for testPeekRemove() passed");
    	t5 = true;
    }
    
    //testing Peek
    if(test.peekBest().equals(ketchup)) {
    	System.out.println("test6 for testPeekRemove() passed");
    	t6 = true;
    }
    
    //testing isEmpty()
    
    if(test.isEmpty()==false) {
    	System.out.println("test7 for testPeekRemove() passed");
    	t7 = true;
    }
    
    if(t1==true && t2==true && t3==true && t4==true &&
    		t5==true && t6==true && t7==true) {
    	System.out.println("all tests in testPeekRemove() passed");
    	return true;
    }
    else {
    	return false;
    }
  }
  
  /**
   * Checks the correctness of the removeBest and peekBest methods, as well as the constructor of 
   * the OrderPriorityQueue class for erroneous inputs and/or states
   * 
   * You should, at least:
   * (1) create a new OrderPriorityQueue with an invalid capacity argument, and verify that the 
   *     correct exception is thrown
   * (2) call peekBest() on an OrderPriorityQueue with an invalid state for peeking, and verify that
   *     the correct exception is thrown
   * (3) call removeBest() on an OrderPriorityQueue with an invalid state for removing, and verify
   *     that the correct exception is thrown
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testErrors() {
    Order.resetIDGenerator();
    boolean t1 = false;
    
    //test for invalid capacity
    try {
    	OrderPriorityQueue test = new OrderPriorityQueue(-1);
    }
    catch(IllegalArgumentException e){
    	System.out.println(e);
    	
    	}
    
    //test for invalid peeking
    try {
    	OrderPriorityQueue test = new OrderPriorityQueue(10);
    	test.peekBest();
    }
    catch(NoSuchElementException e){
    	System.out.println(e);
    }
    
    //test for remove best 
    
    try {
    	OrderPriorityQueue test = new OrderPriorityQueue(10);
    	test.removeBest();
    }
    catch(NoSuchElementException e) {
    	System.out.println(e);
    }
    	
    
    return true; 
  }
  
  /**
   * Calls the test methods individually and displays their output
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("isEmpty: "+testIsEmpty());
    System.out.println("insert basic: "+testInsertBasic());
    System.out.println("percolate UP: "+testPercolateUp());
    System.out.println("insert advanced: "+testInsertAdvanced());
    System.out.println("percolate DOWN: "+testPercolateDown());
    System.out.println("peek/remove valid: "+testPeekRemove());
    System.out.println("error: "+testErrors());
  }

}
