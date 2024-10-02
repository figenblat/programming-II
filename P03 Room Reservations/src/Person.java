//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P03 Room Reservation
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



public class Person {
	// String name which represents the name of the person
	private String name="";
	// boolean which represents the waiting status of a person
	private boolean isWaiting;
	
	/*
	 * method which creates a new person 
	 * @param name - the name of the new Person object 
	 */
	public Person (String name) {
		this.name = name;
		isWaiting = true;
		
	}
	/*
	 * method to receive the name of the person
	 * @return name - the name of the person
	 */
	public  String getName() {
		
		
		return this.name;
	}
	/*
	 * method to receive the waiting status of the person 
	 * @return isWaiting - whether the person's waiting status is true or false
	 */
	public boolean isWaiting() {
		
		return this.isWaiting;
	}
	/*
	 * method to toggle the waiting status from true to false and vice versa
	 */
	public void toggleWaiting() {
		if (isWaiting == false) {
			isWaiting = true;
		}
		else {
			isWaiting = false;
		}
		
	}
	/* 
	 * method to check whether the person already exists
	 * @param Object o - the person being compared 
	 * @return true if the object being compared is equal to Person
	 */
	public boolean equals (Object o) {
		if (o instanceof Person) {
			return this.name.equals(((Person) o).name);
		}
		return false;
	}
	
	
	
	
	

}
