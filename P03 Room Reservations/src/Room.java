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


import java.util.ArrayList;

public class Room {
	private static ArrayList<String> names = new ArrayList<String>();

	private String name;
	//private Person[] occupants = new Person[getCapacity()];
	private int currentOccupancy;
	private int capacity;
	private Person[]occupants;

	/*
	 * sets all odd indexes of the occupants array to null
	 */
	public void setNull() {
		for (int i = 0; i < occupants.length; i++) {
			if (i % 2 != 0) {
				occupants[i] = null;
			}

		}
	}

	/*
	 * Method that returns the current list of Room names as an array of Strings
	 * @return the current list of rooms as a String array
	 */

	public static String[] getNames() {

		String[] namesArray = names.toArray(new String[0]);
		return namesArray;

	}
	
	/*
	 * Initializes the instance variables for the room object
	 * @param name - the name of the new room 
	 * @param capacity - the capacity of the new room
	 * @return IllegalArgumentException - if capacity is below zero or name already in use
	 */

	public Room(String name, int capacity) throws IllegalArgumentException{
		if (capacity <= 0 || names.contains(name)) {
			throw new IllegalArgumentException("Capacity is at or below zero.");
		} 
		
		this.name = name;
		
		for (int i = 0; i<names.size();i++) {
			if (name==names.get(i)){
				throw new IllegalArgumentException(" Name of room already in use.");	
			}
		}
		this.currentOccupancy=0;
		occupants = new Person[capacity];
		names.add(name);

	}

	
	/*
	 *  gets the name of the room
	 *  @return name - the name of the room
	 */

	public String getName() {
		return name;

	}
	
	/*
	 * gets the current occupancy of the room 
	 * @return currentOccupancy - the current occupancy of the room
	 */

	public int getOccupancy() {
		return currentOccupancy;

	}
	/*
	 * returns the capacity of a room during the COVID Pandemic 
	 * which is equal to half of the normal capacity 
	 * @return covidCapacity - the capacity allowed during COVID
	 */

	public int getCOVIDCapacity() {
		/*
		int covidCapacity;

		if (capacity % 2 == 0) {
			covidCapacity = capacity / 2;
		} else {
			covidCapacity = (int) Math.ceil(capacity / 2);
		}

		return covidCapacity;
		*/
		
		return ((occupants.length +1)/2);

	}
	
	/*
	 * returns the overall capacity regardless of COVID
	 * @return capacity - the normal capacity of a classroom
	 */

	public int getCapacity() {

		return occupants.length;

	}
	
	/* 
	 * determines whether a person is present in the occupants array/in the room 
	 * @param person P - the person you are checking is in the occupants array 
	 * @return true if the provided person is found within the occupants array 
	 */

	public boolean contains(Person p) {
		boolean contains = false;
	if(occupants!=null) {
		for (int i = 0; i <= occupants.length-1; i++) {

			if (occupants[i] == p) {

				contains = true;
				
			} 
		}
	}
	else {
		contains = false;
		}
	return contains;

	}

	
	/*
	 * checks a person into a room (adds them to the occupants array) if they are eligible to be added
	 * @param Person in - the person attempting to be checked in 
	 * @return true if the person is successfully added to the occupants array and checked into the room 
	 */

	public boolean checkIn(Person in) {

		if (currentOccupancy == getCOVIDCapacity()) {
			return false;
		}

		if (in == null) {
			throw new IllegalArgumentException("Person attempted to be added is null");

		}
		for (int i = 0; i < occupants.length; i++) {

			if (occupants[i] == in) {

				throw new IllegalArgumentException("Person attempted to be added already in the room.");

			}

		}

		for (int i = 0; i < occupants.length; i++) {
			if (occupants[i * 2] == null) {
				occupants[i * 2] = in;
				currentOccupancy++;
				in.toggleWaiting();
				return true;
			}
		}
		
		return false;

	}

	/*
	 * method to check a person out of a room, effectively removing them from the occupants array
	 * @param Person out - the person to be checked out of the room 
	 * @return true - if Person out was successfully checked out of the room/removed from the occupants array
	 */

	public boolean checkOut(Person out) {

		if (out == null) {
			
			throw new IllegalArgumentException("Person to be checked out DNE/null");

		} 
		for (int i = 0; i < occupants.length; i++) {
			
			if (occupants[i] == out) {
				
				occupants[i] = null;
				
				out.toggleWaiting();
				
				currentOccupancy--;
				
				return true;
			}
			
			
		}
		
			return false;
			

		}
	/*
	 * prints a representation of the room and its occupants, empty spaces represented by "-"
	 * @return a string representation of the room with its occupants
	 */



	public String toString() {

		String toString = name + "\n===\n";

		for (int i = 0; i < occupants.length; i++) {
			
			if (occupants[i] == null) {
				
				toString += "-\n";

			} else {
				
				toString += occupants[i].getName() + "\n";
				
			}
			
		}
		
		return toString;

	}

	/*
	 * method to clear all created rooms
	 */
	public static void clearRooms() {
		names.clear();
	}
}
