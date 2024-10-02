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


public class SimpleBag {
	//create a protected String array named data
	protected String [] data;
	//create a protected Object named random
	protected Object random;
	
	/*
	 * Method which accepts a seed number, and initializes a String array named Data and an object named Random
	 * @param int seed 
	 */
	public SimpleBag(int seed){
		//initialize data
		data = new String[80000];
		//initialize random
		random = new Random(seed);
	   	
	}
	/*
	 * Reads the text contents of the provided file,
	 *  inserting each new space-separated word at the beginning of the data array
	 *  @param File f - the file to read from 
	 */
	public void loadData(File f) {
		
		
		
		try {
			Scanner sc = new Scanner(f);
			
			sc.nextLine();
			
			while (sc.hasNextLine()) {
				String next = sc.next();

				for(int i = data.length-1; i>0;i--) {
					data[i] = data[i-1];

				}
				data[0]= next;
				
			}
			
			sc.close();
		}
			catch (Exception  e) {
			System.out.println("file not found");
			e.printStackTrace();
		}
	
	
		
	}
	
	/*
	 * Counts the number of Strings (i.e. non-null) values in 
	 * the data array and generates a random index between 0 and 
	 * the number of Strings stored in this bag (exclusive). Removes the string
	 * at that random number
	 * @return removed - the string that is removed from the array data
	 */
	public String removeRandom() {
		int count = 0;
		for (int i = 0; i<data.length;i++) {
			if(data[i]!=null) {
				count++;
			}
		}
		if (count ==0) {
			return null;
		}
		
		//System.out.println(count);
		Random rand = new Random();
		
		int index = rand.nextInt(count);
		//System.out.println(index);
		
		String removed = data[index];
		//System.out.println(removed);
		
		
		
		for (int i = index; i<data.length-1;i++) {
			data[i]=data[i+1];
		}
		
		return removed;
		
	}
}

		
		
	
	
