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
import java.io.FileWriter;
import java.io.IOException;

public class Benchmark {
	
	/*
	 * Runs both classes’ loadData() implementations on the same text file
	 * Tracks the time spent in milliseconds to complete each loadData()
	 * @param File f - the file being read 
	 * @param Simplebag s 
	 * @param CleverBag c
	 * @return String times
	 */
	public static String compareLoadData(File f, SimpleBag s, CleverBag c) {
		
		long timeSimpleBag;
		long timeCleverBag;
		long beggining;
		long end;
		
		//testing how long loadData() takes for SimpleBag 
		beggining = System.currentTimeMillis();
		s.loadData(f);
		end = System.currentTimeMillis();
		timeSimpleBag = end-beggining;
		
		
		//testing how long loadData() takes for CleverBag 
		beggining = System.currentTimeMillis();
		c.loadData(f);
		end = System.currentTimeMillis();
		timeCleverBag = end - beggining;
		
		String timeLoadData = "loadData() for SimpleBag: " + timeSimpleBag +"loadData() for CleverBag: " + timeCleverBag+ "\n";
	
		
		return timeLoadData;
		
	}
	
	/*
	 * Runs both classes’ removeRandom() method n times 
	 * Tracks the time spent in milliseconds to complete each type of remove
	 * @param int n 
	 * @param SimpleBag s
	 * @param CleverBag c
	 * @return String removeTimes
	 */
	public static String compareRemove(int n, SimpleBag s, CleverBag c) {
		
		long timeSimpleBag;
		long timeCleverBag;
		long beggining;
		long end;
		int i = 0;
		int j = 0;
		
		
		//testing removeRandom() for SimpleBag
		beggining = System.currentTimeMillis();
		while ( i < n) {
			s.removeRandom();
			i++;
		}
		end = System.currentTimeMillis();
		timeSimpleBag = beggining - end;
		
		
		//testing removeRandom() for CleverBag()
		beggining = System.currentTimeMillis();
		while (j<n) {
			c.removeRandom();
			j++;
		}
		end = System.currentTimeMillis();
		timeCleverBag = beggining - end;
		
		String removeTimes = n + " for removeRandom() in SimpleBag: " + timeSimpleBag +" and for removeRandom() in CleverBag: " + timeCleverBag + "\n";
		
		//System.out.println(removeTimes);
		return removeTimes;
	}
	
	/*
	 * Creates one instance each of a SimpleBag and a CleverBag
	 * Calls compareLoadData() to compare the two different data loads using the in parameter 
	 * Calls compareRemove() on each of the provided nValues to compare the two different remove 
	 * implementations
	 * Writes the results of the data load comparison followed by the remove comparisons to a file 
	 * specified by the out parameter
	 * Handles any exceptions raised by the methods it uses.
	 * @param File in - the file being tested 
	 * @param File out - file containing results 
	 * @param int[]nValues - array containing values to be removed
	 */
	public static void createResultsFile(File in, File out, int[] nValues) {
		SimpleBag s = new SimpleBag(100);
		CleverBag c = new CleverBag(100);
		
		try {
			//creating fileWriter and new file (file out)
			FileWriter fWriter;
			fWriter = new FileWriter(out);
			
			//writing to the file out using compareLoadData and compareRemove
			fWriter.write(compareLoadData(in, s, c));
			for (int i =0; i<nValues.length; i++) {
				fWriter.write(compareRemove(nValues[i],s,c));
			}
			//write contents to file and empty for further data
			fWriter.flush();
			//close the fileWriter
			fWriter.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	

	public static void main(String[] args) {
		SimpleBag trial = new SimpleBag(100);
		SimpleBag trial2 = new SimpleBag(100);
		File small = new File ("test.txt");
		File big = new File("frank.txt");
		File out = null;
		int[] n = {10, 100, 1000, 10000};
		
		trial.loadData(small);
		trial.removeRandom();
		//trial2.loadData(big);
		//trial2.removeRandom();
		
		
		
		try {
		big.createNewFile();
		small.createNewFile();
		}
		catch(IOException e) {
			
		}
		
		//createResultsFile(small,out, n);
		//createResultsFile(big, out, n);

	}

}
