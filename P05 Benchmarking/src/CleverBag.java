//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P05 Benchmarking
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
import java.util.Random;
import java.util.Scanner;

public class CleverBag extends SimpleBag{
	private int size;

	/*
	 * initializes the private integer field ,size, which will 
	 * track the current number of initialized Strings in the 
	 * parent class data array.
	 * @param seed
	 */
	public CleverBag(int seed){
		super (seed);
		size = 0;
		
				
	}
	
	@Override
	/*
	 * Reads the contents of the file as in the parent class
	 * but instead inserts the new words at the end of the array and
	 *  then updates the size field accordingly
	 * @param File f - the file being read
	 */
	public void loadData(File f)  {
		try {
		Scanner sc = new Scanner (f);
		sc.nextLine();
		int index = 0;
		
		
		
		
		while (sc.hasNextLine()) {
			String next = sc.next();
			data[index]= next;
			index++;
			size++;
			}
		
		sc.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	@Override 
	/*
	 * Generates a random integer between 0 and the current size
	 * Removes and returns the String at that index
	 * Fills gaps by moving the last String into the gap and decrementing size
	 * If the bag contains no strings, this method returns null.
	 * @return removed - the string that is removed from the array data
	 * @return null - if the bag contains no strings
	 */
	public String removeRandom() {
		
		Random rand = new Random();
		String removedString;
		
		if (size == 0) {
			return null;
		}
		
		int index = rand.nextInt(size);
		removedString = data[index];
		data[index] = data[size-1];
		size--;
		return removedString;
		
	}

}
