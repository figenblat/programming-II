//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P07 Inventory Storage System
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

public class InventorySystemTester {
	public static boolean testLinkedBox() {
		Box.restartNextInventoryNumber();
		
		Box box1 = new Box(Color.YELLOW);
		return true;
		
		
		
		
	}
	// checks for the correctness of the InventoryList.clear() method
	public static boolean testClear() {
		Box.restartNextInventoryNumber();
		InventoryList list = new InventoryList();
		
		list.clear();
		return true;
	}
	// checks for the correctness of the InventoryList.addYellow(),
	// InventoryList.addBlue(), and InventoryList.addBrown() methods
	public static boolean testAddBoxes() {
		Box.restartNextInventoryNumber();
		return true;
	}
	// checks for the correctness of the InventoryList.removeBox()
	// InventoryList.removeYellow(), and InventoryList.remove Brown()
	// methods
	public static boolean testRemoveBoxes() {
		Box.restartNextInventoryNumber();
		return true;
	}
	// checks for the correctness of the InventoryList.get() method
	public static boolean testGetBoxes() {
		Box.restartNextInventoryNumber();
		return true;
	}
	// a test suite method to run all your test methods
	public static boolean runAllTests() {
		boolean working = false;
		Box.restartNextInventoryNumber();
		testGetBoxes();
		testRemoveBoxes();
		testAddBoxes();
		testClear();
		testLinkedBox();
		
		if (testGetBoxes() == true && testRemoveBoxes()==true && testAddBoxes() == true 
				&& testClear() == true && testLinkedBox() == true) {
			working = true;
			
		}
		if (working == true) {
			System.out.println("All tests working");
		}
		else {
			System.out.println("Not all tests working");
		}
		return working;
	}

	public static void main(String[] args) {
		runAllTests();

	}

}
