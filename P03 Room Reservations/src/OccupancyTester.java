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




public class OccupancyTester {
	
	
	public static boolean testPerson() {
		Person p = new Person("Noa");
		Person k = new Person("April");
		Person y = new Person("April");
		Person z = new Person("May");
		
		
		boolean getName = true;
		boolean isWaiting = true;
		boolean toggleWaiting = true;
		boolean equals = true;
		
		
		
		// for person 1 AKA "Noa"
		
		String expectedN = "Noa";
		String actualN = p.getName();
		
		if (expectedN == actualN) {
			System.out.println(p.getName());
			System.out.println("getName() working");
		}
		else {
			System.out.println(p.getName());
			System.out.println("getName() fails");
			getName = false;
		}
		
		boolean waitingExpected = true;
		boolean waitingActual = p.isWaiting();
		
		if (waitingActual == waitingExpected) {
			System.out.println("isWaiting() working");
			
		}
		else {
			System.out.println("isWaiting() fails");
			isWaiting = false;
		}
		
		boolean toggleExpected = false;
		p.toggleWaiting();
		boolean toggleActual = p.isWaiting();
		
		if (toggleExpected == toggleActual) {
			System.out.println("toggleWaiting() working");
		}
		else {
			System.out.println("toggleWaiting() fails");
			toggleWaiting = false;
		}
		
		
		// for person 2 AKA "April"
		
		String expectedK = "April";
		String actualK = k.getName();

		if (expectedK == actualK) {
			System.out.println("getName() working");
		}
		else {
			System.out.println("getName() fails");
			getName = false;
		}
		
		boolean waitingExpectedK = true;
		boolean waitingActualK = k.isWaiting();
		
		if (waitingActualK == waitingExpectedK) {
			System.out.println("isWaiting() working");
			
		}
		else {
			System.out.println("isWaiting() fails");
			isWaiting = false;
		}
		boolean toggleExpectedK = false;
		k.toggleWaiting();
		boolean toggleActualK = k.isWaiting();
		
		if (toggleExpectedK == toggleActualK) {
			System.out.println("toggleWaiting() working");
		}
		else {
			System.out.println("toggleWaiting() fails");
			toggleWaiting = false;
		}
		
		
		//testing equals
		
		if (k.equals(y) == true) {
			System.out.println("equals() working");
			
		}
		else {
			System.out.println("equals() fails");
			equals = false;
			
		}
		
		if(y.equals("May") == true) {
			System.out.println("equals() fails");
			equals = false;
		}
		else {
			System.out.println("equals() working");
		}
		
		
	
		
		if (isWaiting && toggleWaiting && getName && equals) {
			return true;
		}
		else {
			return false;
		}
		
		
		
	
	}
	
	
	public static boolean testRoomConstructor() {
		
		boolean roomConstructor = true; 
		boolean roomConstructor1 = true; 
		boolean roomConstructor2 = true; 
		boolean roomConstructor3 = true; 
		
		Room a = new Room ("CS 30O", 20);
		
		if (Room.getNames().toString().isEmpty()) {
			System.out.println("Fails test with valid class and capacity");
			roomConstructor1 = false;
			
		}
		else {
			System.out.println("Passes test with valid class and capacity");
			
		}
		
	try {
		Room b = new Room ("Math 221", 10);
		Room c = new Room ("Math 221", 100);
	
		}
		catch (IllegalArgumentException e){
			System.out.println(e);
			System.out.println("Passes test with duplicate class names (throws IllegalArgumentException");
			roomConstructor2 = true;
			
		}
		
		try {
			Room d = new Room ("Math 221", 0);
				
			
		}
		catch (IllegalArgumentException e) {
			System.out.println(e);
			System.out.println("Passes test with class capacity of zero or less (throws IllegalArgumentException");
			roomConstructor3 = true;
		}
	
	
			
		if ( roomConstructor1 && roomConstructor2 && roomConstructor3) {
			 roomConstructor = true;
		}
		else {
			roomConstructor = false;
		}
	
		return roomConstructor;
		
	}
	
	
	public static boolean testRoomAccessors() {
		//test one
		Room one = new Room("English", 40);
		boolean getName = true;
		boolean getOccupancy = true;
		boolean getCOVIDCapacity = true;
		boolean getCapacity = true;
		boolean contains = true;
		
		String expected = "English";
		String actual = one.getName();
		
		if (actual == expected) {
			System.out.println("getName() in room class working");
			
		}
		else {
			System.out.println("getName() in room class failed");
			getName = false;
		}
		
		int expectedOccupancy = 0;
		int actualOccupancy = one.getOccupancy();
		if (expectedOccupancy == actualOccupancy) {
			System.out.println("getOccupancy() working");
		}
		else {
			System.out.println("getOccupancy() failed");
			getOccupancy = false;
		}
		
		int expectedCOVIDCapacity = 20;
		int actualCOVIDCapacity = one.getCOVIDCapacity();
		
		if (expectedCOVIDCapacity == actualCOVIDCapacity) {
			System.out.println("getCOVIDCapacity() working");
		}
		else {
			System.out.println("getCOVIDCapacity() failed");
			getCOVIDCapacity = false;
		
		}
		
		int expectedCapacity = 40;
		int actualCapacity = one.getCapacity();
		
		if (expectedCapacity == actualCapacity) {
			System.out.println("getCapacity() working");
		}
		else {
			System.out.println("getCapacity() failed");
			getCapacity = false;
		
		}
		
		//test 2 
		Room two = new Room ("Marketing", 100);
		String expected1 = "Marketing";
		String actual1 = two.getName();
		
		if (actual1 == expected1) {
			System.out.println("getName() in room class working");
			
		}
		else {
			System.out.println("getName() in room class failed");
			getName = false;
		}
		
		int expectedOccupancy1 = 0;
		int actualOccupancy1 = two.getOccupancy();
		if (expectedOccupancy1 == actualOccupancy1) {
			System.out.println("getOccupancy() working");
		}
		else {
			System.out.println("getOccupancy() failed");
			getOccupancy = false;
		}
		
		int expectedCOVIDCapacity1 = 50;
		int actualCOVIDCapacity1 = two.getCOVIDCapacity();
		
		if (expectedCOVIDCapacity1 == actualCOVIDCapacity1) {
			System.out.println("getCOVIDCapacity() working");
		}
		else {
			System.out.println("getCOVIDCapacity() failed");
			getCOVIDCapacity = false;
		
		}
		
		int expectedCapacity1= 100;
		int actualCapacity1 = two.getCapacity();
		
		if (expectedCapacity1 == actualCapacity1) {
			System.out.println("getCapacity() working");
		}
		else {
			System.out.println("getCapacity() failed");
			getCapacity = false;
		
		}
		
		
		Person i = new Person("Bob");
		
		
		two.checkIn(i);
		
		
		if (two.contains(i)) {
			System.out.println("contains() working");
		}
		else {
			System.out.println("contains() failed. Person not in the room.");
			contains = false;
		}
		
		
		return true;
	}
	
	
	public static boolean testRoomCheckIn() {
		Person a = new Person("Doug");
		Room one = new Room("Science", 40);
		
		one.checkIn(a);
		
		if(one.contains(a)) {
			System.out.println("checkIn() working");
			return true;
		}
		else {
			System.out.println("checkIn() fails");
			return false;
		}
	}
	
	
	public static boolean testRoomCheckOut() {
		Person b = new Person ("Jackie");
		Room two = new Room("History", 200);
		two.checkIn(b);
		two.checkOut(b);
		
		if(two.contains(b)) {
			System.out.println("checkOut() fails");
			return false;
		}
		else {
			System.out.println("checkOut() working");
			return true;
		}
	}
	
	
	public static boolean testRoomToString() {
		Room three = new Room("APUSH", 10);
		Person c = new Person("Meryl");
		Person d = new Person("Sammy");
		three.checkIn(c);
		three.checkIn(d);
		
		String outputExpected = "APUSH\n===\nMeryl\n-\nSammy\n-\n-\n-\n-\n-\n-\n-\n";
		String outputActual = three.toString();
		System.out.println(three.toString());
		
		if(outputExpected.contentEquals(outputActual)) {
			System.out.println("toString() working");
			return true;
		}
		else {
			System.out.println("toString() fails");
			return false;
		}
	}
	

	public static void main(String[] args) {
		testPerson();
		testRoomConstructor();
		testRoomAccessors();
		testRoomCheckIn();
		testRoomCheckOut();
		testRoomToString();		

	}

}
