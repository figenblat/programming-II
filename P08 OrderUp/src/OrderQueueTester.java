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


public class OrderQueueTester {
	public static boolean testOrderIterator() {
		boolean working1 = false;
		boolean working2 = false;
		boolean working3 = false;
		
		
		Order one = new Order("Pasta", 5);
		Order two = new Order("Chicken", 20);
		Order three = new Order("Bread", 1);
		Order four = new Order("Veggies", 10);
		
		LinkedOrder pasta = new LinkedOrder(one);
		LinkedOrder chicken = new LinkedOrder(two);
		LinkedOrder bread = new LinkedOrder(three);
		LinkedOrder veggies = new LinkedOrder(four);
		
		
		pasta.setNext(chicken);
		chicken.setNext(bread);
		bread.setNext(veggies);
		
		OrderIterator test = new OrderIterator(pasta);
	
		
		
		//test 1 - OrderIterator
		
		LinkedOrder expected;
		LinkedOrder actual;
		
		expected = pasta;
		actual = pasta;
		
		
		if (expected == actual) {
			System.out.println("OrderIterator constructor working.");
			working1 = true;
			
		}
		else {
			working1 = false;
		}
		
		//test 2 - hasNext()
		
		
		
		boolean expectedHN = true;
		boolean actualHN = test.hasNext();
		
		if (expectedHN == actualHN) {
			System.out.println("hasNext() working as expected.");
			working2 = true;
		}
		else {
			working2 = false;
		}
		
		//test 3 = next()
		
		String expectedO = "1002: Chicken (20)" ;
		String actualO = test.next().toString();
		
		
		if (expectedO.equals(actualO)) {
			System.out.println("next() working as expected.");
			working3 = true;
			
		}
		else {
			working3 = false;
		}
		
		if (working1 == true && working2 == true && working3 == true) {
			System.out.println("All OrderIterator tests working.");
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public static boolean testEnqueue(){
		
		
		Order one = new Order("Pasta", 5);
		
		
		OrderQueue order = new OrderQueue();
		
		order.enqueue(one);
		
		
		if (order.peek() == one) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	public static boolean testDequeue() {
		Order one = new Order("Pasta", 5);
		Order two = new Order("Chicken", 20);
		Order three = new Order("Bread", 1);
		Order four = new Order("Veggies", 10);
		
		OrderQueue order = new OrderQueue();
		order.enqueue(one);
		order.enqueue(two);
		order.enqueue(three);
		order.enqueue(four);
		
		order.dequeue();
		
		if (order.peek()==two) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public static boolean testPeek() {
		Order one = new Order("Pasta", 5);
		Order two = new Order("Chicken", 20);
		Order three = new Order("Bread", 1);
		Order four = new Order("Veggies", 10);
		
		OrderQueue order = new OrderQueue();
		order.enqueue(one);
		order.enqueue(two);
		order.enqueue(three);
		order.enqueue(four);
		
		if (order.peek()==one) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static boolean runAllTests() {
		testOrderIterator();
		testEnqueue();
		
		if (testOrderIterator() == true && testEnqueue() ==true && testDequeue() == true && testPeek() == true ) {
			System.out.println("Everything is working");
			return true;
		}
		else {
			return false;
		}
		
	}

	public static void main(String[] args) {
		runAllTests();
		

	}

}
