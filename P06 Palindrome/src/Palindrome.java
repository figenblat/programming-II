//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P06 Palindrome
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

public class Palindrome {
	static String returned = "";
/*
 * method that takes a char start and returns a string with a palindrome
 * goes towards A
 * @param char start - the char to start the palindrome 
 * @return string returned - the string containing the palindrome
 */
	public static String mirrorA(char start) throws IllegalArgumentException{
		
		if(Character.isLowerCase(start) == true) {
			throw new IllegalArgumentException("The letter is lowercase, which is not permitted.");
		}
		if(Character.isLetter(start)==false) {
			throw new IllegalArgumentException("The character is not a letter, which is not permitted");
		}
		
		if (start =='A'||start == 65) {
			int index = returned.length()/2;
			returned = returned.substring(0,index) + "A" + returned.substring(index);
			return returned;
			
		}
		else {
			
			String addedChar = Character.toString(start);
			returned = addedChar + " " + mirrorA((char)(start-1)) +" " + addedChar;
			
			
		}
		
		return returned;
		
	}
	/*
	 * method that takes a char start, skips letters depending on the 
	 * int step and returns a string with a palindrome
	 * goes towards A
	 * @param char start - the char to start the palindrome 
	 * @param int step - the int number of letters to step 
	 * @return string returned - the string containing the palindrome
	 */
	public static String mirrorA(char start, int step) throws IllegalArgumentException{
		
		if(Character.isLowerCase(start)) {
			throw new IllegalArgumentException("The letter is lowercase, which is not permitted.");
		}
		if(Character.isLetter(start)==false) {
			throw new IllegalArgumentException("The character is not a letter, which is not permitted");
		}
		if (step >= 0 == false) {
			throw new IllegalArgumentException("Step is zero or negative, which is not permitted");
		}
		
		if (start == 'A' || start ==65) {
			returned = Character.toString(start);
			return returned;
		}
		else {
			String addedChar = Character.toString(start);
			if (start - step<65) {
				returned = addedChar + " " +addedChar;
			}
			else {
				returned = addedChar +" " + mirrorA(start-=step,step) + " " + addedChar;
				
			}
		
		}
		
		return returned;
	}
	/*
	 * method that takes a char start and returns a string with a palindrome
	 * goes towards Z
	 * @param char start - the char to start the palindrome 
	 * @return string returned - the string containing the palindrome
	 */
	public static String mirrorZ(char start) throws IllegalArgumentException{
		
		if(Character.isLowerCase(start)) {
			throw new IllegalArgumentException("The letter is lowercase, which is not permitted.");
		}
		if(Character.isLetter(start)==false) {
			throw new IllegalArgumentException("The character is not a letter, which is not permitted");
		}
		
		if (start =='Z' || start == 90) {
			returned = Character.toString(start);
			return returned;
		}
		else {
			String addedChar = Character.toString(start);
			returned = addedChar +" " + mirrorZ((char)(start+1)) +" " +addedChar;
			
		}
		return returned;
	}
	/*
	 * method that takes a char start, skips letters depending on the 
	 * int step and returns a string with a palindrome
	 * goes towards Z
	 * @param char start - the char to start the palindrome 
	 * @param int step - the int number of letters to step 
	 * @return string returned - the string containing the palindrome
	 */
	public static String mirrorZ(char start, int step) throws IllegalArgumentException{
		
		if(Character.isLowerCase(start)) {
			throw new IllegalArgumentException("The letter is lowercase, which is not permitted.");
		}
		if(Character.isLetter(start)==false) {
			throw new IllegalArgumentException("The character is not a letter, which is not permitted");
		}
		if (step >= 0 == false) {
			throw new IllegalArgumentException("Step is zero or negative, which is not permitted");
		}
		
		if (start =='Z' || start == 90) {
			returned = Character.toString(start);
			return returned;
		}
		else {
			String addedChar = Character.toString(start);
			if (start + step>90) {
				returned = addedChar + " " +addedChar;
			}
			else {
				returned = addedChar +" " + mirrorZ(start+=step,step) + " " + addedChar;
				
			}
			
		}
		return returned;
	}
}
