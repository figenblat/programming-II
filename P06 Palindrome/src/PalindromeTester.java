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

public class PalindromeTester {
	public static Boolean testMirrorA() {
		boolean test1 = false;
		boolean test2 = false;
		boolean test3 = false;
		boolean working = false;
		//test case 1 with E being entered
		String expected1 = "E D C B A B C D E";
		String actual1 = Palindrome.mirrorA('E');
		if (expected1.matches(actual1)) {
			System.out.println("Expected: " + expected1 + " and actual: " + actual1);
			System.out.println("mirrorA(char start) working with valid UpperCase char input.");
			test1 = true;
		}
		
		System.out.println("---------------End Test 1----------------");
		//test 2 with lowercase e
		
		
		try {
		 Palindrome.mirrorA('e');
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
			System.out.println("mirrorA(char start) working when invalid LowerCase char inputed.");
			test2 = true;
		}
		
		System.out.println("---------------End Test 2----------------");
		
		//test 3 with non-letter char
		
		try {
			Palindrome.mirrorA('3');
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
			System.out.println("mirrorA(char start) working when invalid non char inputed.");
			test3 = true;
		}
		
		System.out.println("---------------End Test 3----------------");
		
		if (test1 == true && test2 == true && test3 ==true) {
			working = true;
			System.out.println("mirrorA(char start) working as expected, and all tests passed");
		}
		
		System.out.println("---------------End testMirrorA()----------------");
		
		return working;
		
		
		
	}
	public static Boolean testMirrorAStep() {
		boolean test1 = false;
		boolean test2 = false;
		boolean test3 = false;
		boolean test4 = false;
		boolean working = false;
		//test case 1 with E being entered and step being 2
		String expected1 = "E C A C E";
		String actual1 = Palindrome.mirrorA('E', 2);
		
		
		if (expected1.matches(actual1)) {
			System.out.println("Expected: " + expected1 + " and actual: " + actual1);
			System.out.println("mirrorA(char start, int step) working with valid UpperCase char input and step input.");
			test1 = true;
		}
		
		System.out.println("---------------End Test 1----------------");
		
		//test 2 with lowercase e
		try {
		 Palindrome.mirrorA('e', 1);
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
			System.out.println("mirrorA(char start, int step) working when invalid LowerCase char inputed.");
			test2 = true;
		}
		System.out.println("---------------End Test 2----------------");
		//test 3 with non-letter char
		
		try {
			Palindrome.mirrorA('3', 3);
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
			System.out.println("mirrorA(char start, int step) working when invalid non char inputed.");
			test3 = true;
		}
		
		System.out.println("---------------End Test 3----------------");
		
		//test 4 with invalid step (<=0)
		
		try {
			Palindrome.mirrorA('T', -3);
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
			System.out.println("mirrorA(char start, int step) working when invalid step (<=0) inputed.");
			test4 = true;
		}
		System.out.println("---------------End Test 4----------------");
		
		if (test1 == true && test2 == true && test3 ==true && test4 == true) {
			working = true;
			System.out.println("mirrorA(char start, int step) working as expected, and all tests passed");
		}
		System.out.println("---------------End testMirrorAStep()----------------");
		return working;
		
		
		
	}
	public static Boolean testMirrorZ() {
		boolean test1 = false;
		boolean test2 = false;
		boolean test3 = false;
		boolean working = false;
		//test case 1 with E being entered
		String expected1 = "V W X Y Z Y X W V";
		String actual1 = Palindrome.mirrorZ('V');
		if (expected1.matches(actual1)) {
			System.out.println("Expected: " + expected1 + " and actual: " + actual1);
			System.out.println("mirrorZ(char start) working with valid UpperCase char input.");
			test1 = true;
		}
		
		System.out.println("---------------End Test 1----------------");
		
		//test 2 with lowercase v
		try {
		 Palindrome.mirrorZ('v');
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
			System.out.println("mirrorZ(char start) working when invalid LowerCase char inputed.");
			test2 = true;
		}
		
		System.out.println("---------------End Test 2----------------");
		
		//test with non-letter char
		
		try {
			Palindrome.mirrorZ('7');
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
			System.out.println("mirrorZ(char start) working when invalid non char inputed.");
			test3 = true;
		}
		
		System.out.println("---------------End Test 3----------------");
		
		if (test1 == true && test2 == true && test3 ==true) {
			working = true;
			System.out.println("mirrorZ(char start) working as expected, and all tests passed");
		}
		System.out.println("---------------End testMirrorZ()----------------");
		return working;
		
	}
	public static Boolean testMirrorZStep() {
		boolean test1 = false;
		boolean test2 = false;
		boolean test3 = false;
		boolean test4 = false;
		boolean working = false;
		//test case 1 with E being entered and step being 2
		String expected1 = "V X Z X V";
		String actual1 = Palindrome.mirrorZ('V', 2);
		
		
		if (expected1.matches(actual1)) {
			System.out.println("Expected: " + expected1 + " and actual: " + actual1);
			System.out.println("mirrorZ(char start, int step) working with valid UpperCase char input and step input.");
			test1 = true;
		}
		
		System.out.println("---------------End Test 1----------------");
		
		//test 2 with lowercase e
		try {
		 Palindrome.mirrorZ('v', 1);
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
			System.out.println("mirrorZ(char start, int step) working when invalid LowerCase char inputed.");
			test2 = true;
		}
		System.out.println("---------------End Test 2----------------");
		//test 3 with non-letter char
		
		try {
			Palindrome.mirrorZ('3', 3);
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
			System.out.println("mirrorZ(char start, int step) working when invalid non char inputed.");
			test3 = true;
		}
		
		System.out.println("---------------End Test 3----------------");
		
		//test 4 with invalid step (<=0)
		
		try {
			Palindrome.mirrorZ('T', -3);
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
			System.out.println("mirrorZ(char start, int step) working when invalid step (<=0) inputed.");
			test4 = true;
		}
		System.out.println("---------------End Test 4----------------");
		
		if (test1 == true && test2 == true && test3 ==true && test4 == true) {
			working = true;
			System.out.println("mirrorA(char start, int step) working as expected, and all tests passed");
		}
		System.out.println("---------------End testMirrorZStep()----------------");
		return working;
		
		
		
		
	}
	
	public static Boolean runAllTests() {
		boolean working = false;
		if (testMirrorA() == true && testMirrorAStep() == true && testMirrorZ() == true && testMirrorZStep() == true) {
			System.out.println("All testMethods working and returning true");
			working = true;
		}
		
		return working;
	}
	
	public static void main(String[] args) {
		//testMirrorA();
		//testMirrorAStep();
		//testMirrorZ();
		//testMirrorZStep();
		runAllTests();

	}

}
