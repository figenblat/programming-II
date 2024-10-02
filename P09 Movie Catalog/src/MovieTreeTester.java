//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P09 Movie Catalog
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


// Add javadoc style class header here
// File Header comes here
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * MovieTree.
 *
 */

public class MovieTreeTester {

  /**
   * Checks the correctness of the implementation of both addMovie() and toString() methods
   * implemented in the MovieTree class. This unit test considers at least the following scenarios.
   * (1) Create a new empty MovieTree, and check that its size is 0, it is empty, and that its
   * string representation is an empty string "". (2) try adding one movie and then check that the
   * addMovie() method call returns true, the tree is not empty, its size is 1, and the .toString()
   * called on the tree returns the expected output. (3) Try adding another movie which is smaller
   * that the movie at the root, (4) Try adding a third movie which is greater than the one at the
   * root, (5) Try adding at least two further movies such that one must be added at the left
   * subtree, and the other at the right subtree. For all the above scenarios, and more, double
   * check each time that size() method returns the expected value, the add method call returns
   * true, and that the .toString() method returns the expected string representation of the
   * contents of the binary search tree in an increasing order from the smallest to the greatest
   * movie with respect to year, rating, and then name. (6) Try adding a movie already stored in the
   * tree. Make sure that the addMovie() method call returned false, and that the size of the tree
   * did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddMovieToStringSize() {
	  MovieTree addMovie = new MovieTree();
	  
	  boolean test1 = false;
	  boolean test2 = false;
	  boolean test3 = false;
	  boolean test4 = false; 
	  boolean test5 = false;
	  boolean test6 = false;
	  
	  
	  //test 1 
	  if (addMovie.size()==0 && addMovie.isEmpty()==true && addMovie.toString().equals("")) {
		  test1 = true;
	  }
	 
	  
	 //test2 
	  Movie clueless = new Movie(1995, 7.0, "Clueless");
	 
	  if (addMovie.addMovie(clueless)==true && addMovie.isEmpty() == false && addMovie.size() == 1 && addMovie.toString().equals("[(Year: 1995) (Rate: 7.0) (Name: Clueless)]" + "\n")) {
		  test2 = true;
	  }
	 
	  //test 3
	  
	  Movie up = new Movie(1997,6.0,"UP");
	  
	  
	  if (addMovie.addMovie(up) == true && addMovie.isEmpty() == false && addMovie.size()==2 && addMovie.toString().equals("[(Year: 1995) (Rate: 7.0) (Name: Clueless)]" + "\n" + 
	  		"[(Year: 1997) (Rate: 6.0) (Name: UP)]"+ "\n")) {
		  test3 = true;
	  }
	 
	  
	  
	  
	  //test 4 
	  Movie meanGirls = new Movie(1995, 9.0, "Mean Girls");
	  
	 
	  
	  if (addMovie.addMovie(meanGirls) == true && addMovie.isEmpty() == false &&  addMovie.size()==3 &&
			  addMovie.toString().equals("[(Year: 1995) (Rate: 9.0) (Name: Mean Girls)]" + "\n" + 
			  		"[(Year: 1995) (Rate: 7.0) (Name: Clueless)]" + "\n" + 
			  		"[(Year: 1997) (Rate: 6.0) (Name: UP)]" + "\n")) {
		  test4 = true;
	  }
	 
	  
	  
	  //test 5
	  Movie ted = new Movie(2000,7.0,"Ted"); 
	  Movie svu = new Movie(2000, 6.6, "SVU");
	 	
	  addMovie.addMovie(ted);
	  addMovie.addMovie(svu);
	  
	 
	  
	  if (addMovie.isEmpty() == false &&  addMovie.size()== 5
			  && addMovie.toString().equals("[(Year: 2000) (Rate: 6.6) (Name: SVU)]"+"\n" + 
				  		"[(Year: 1995) (Rate: 9.0) (Name: Mean Girls)]"+"\n" + 
				  		"[(Year: 2000) (Rate: 7.0) (Name: Ted)]"+"\n" + 
				  		"[(Year: 1995) (Rate: 7.0) (Name: Clueless)]"+"\n" + 
				  		"[(Year: 1997) (Rate: 6.0) (Name: UP)]"+"\n")) {
		  
		  test5 = true;
		  
	  }
	 
	 
	  //test 6 
	 
	 if (addMovie.addMovie(clueless)==false) {
		  test6 = true;
	  }
	 
	  System.out.println(test5);
	  if(test1 == true && test2 == true && test3 == true && test4 == true && test5 == true && test6 == true) {
		  System.out.println("testAddMovieToString() working");
		  return true;
	  }
	  else {
		  return false;
	  }
  

  }

  /**
   * This method checks mainly for the correctness of the MovieTree.contains() method. It must
   * consider at least the following test scenarios. (1) Create a new MovieTree. Then, check that
   * calling the contains() method on an empty MovieTree returns false. (2) Consider a MovieTree of
   * height 3 which contains at least 5 movies. Then, try to call contains() method to search for the
   * movie having a match at the root of the tree. (3) Then, search for a movie at the right and
   * left subtrees at different levels considering successful and unsuccessful search operations.
   * Make sure that the contains() method returns the expected output for every method call.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testContains() {
	  
	  boolean test1 = false;
	  boolean test2 = false;
	  boolean test3 = false;
	  // test 1 
	  MovieTree contains = new MovieTree();
	  
	  if (contains.contains(2000, 3.0, "Late Night") == true) {
		  test1 = false;
	  }
	  else {
		  test1 = true;
	  }
	  
	  //test 2
	  Movie clueless = new Movie(1995, 7.0, "Clueless");
	  Movie meanGirls = new Movie(1995, 9.0, "Mean Girls");
	  Movie up = new Movie(1997,6.0,"UP");
	  Movie ted = new Movie(2000,7.0,"Ted");
	  Movie SVU = new Movie(1995, 6.6, "SVU");
	  Movie crimMinds = new Movie (2012, 8.9, "Criminal Minds");
	  
	  contains.addMovie(crimMinds);
	  contains.addMovie(SVU);
	  contains.addMovie(ted);
	  contains.addMovie(up);
	  contains.addMovie(meanGirls);
	  
	  if (contains.contains(2012, 8.9, "Criminal Minds") == true) {
		  test2 = true;
	  }
	  
	  
	  //test 3 
	  if(contains.contains(1997, 7.0, "UP")== true && contains.contains(1995, 6.6, "SVU")== true) {
		  test3 = true;
	  }
	  
	  
	  if (test1==true && test2 == true && test3 == true)
	  {
		  System.out.println("testContains() working");
		  return true;
	  }
	  else {
		  return false;
	  }
	  
  }

  /**
   * Checks for the correctness of MovieTree.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty movie tree is zero. (2) ensures that
   * the height of a tree which consists of only one node is 1. (3) ensures that the height of a
   * MovieTree with the following structure for instance, is 4. 
   *       (*)
   *     /    \
   *  (*)      (*)
   *    \     /  \
   *    (*) (*)  (*)
   *             /
   *           (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
   MovieTree height = new MovieTree();
   Movie clueless = new Movie(1995, 7.0, "Clueless");
   Movie meanGirls = new Movie(1995, 9.0, "Mean Girls");
   Movie up = new Movie(1997,6.0,"UP");
   Movie ted = new Movie(2000,7.0,"Ted");
   Movie SVU = new Movie(1995, 6.6, "SVU");
   Movie crimMinds = new Movie (2012, 8.9, "Criminal Minds");
   
   //test 1 
   
   if (height.height()!= 0) {
	   return false;
   }
   
   //test 2 
   height.addMovie(clueless);
   if(height.height()!=1) {
	   return false;
   }
   
   //test 3
   height.addMovie(meanGirls);
   height.addMovie(up);
   height.addMovie(ted);
   height.addMovie(SVU);
   height.addMovie(crimMinds);
   
   if (height.height()!=4) {
	   return false;
   }
   System.out.println("testHeight() working.");
   return true;
   
  }

  /**
   * Checks for the correctness of MovieTree.getBestMovie() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetBestMovie() {
	  MovieTree bestMovie = new MovieTree();
	   Movie clueless = new Movie(1995, 7.0, "Clueless");
	   Movie meanGirls = new Movie(1995, 9.0, "Mean Girls");
	   Movie up = new Movie(1997,6.0,"UP");
	   Movie ted = new Movie(2000,7.0,"Ted");
	   Movie SVU = new Movie(1995, 6.6, "SVU");
	   Movie crimMinds = new Movie (2012, 8.9, "Criminal Minds");
	   bestMovie.addMovie(meanGirls);
	   bestMovie.addMovie(up);
	   bestMovie.addMovie(ted);
	   bestMovie.addMovie(SVU);
	   bestMovie.addMovie(crimMinds);
	   bestMovie.addMovie(clueless);
	   
	   Movie expected = ted;
	   Movie actual = bestMovie.getBestMovie();
	   
	   if (expected == actual) {
		   System.out.println("testGetBestMovie() working");
		   return true;
	   }
	   else {
		   return false;
	   }
  }

  /**
   * Checks for the correctness of MovieTree.lookup() method. This test must consider at least 3
   * test scenarios. (1) Ensures that the MovieTree.lookup() method throws a NoSuchElementException
   * when called on an empty tree. (2) Ensures that the MovieTree.lookup() method returns an array
   * list which contains all the movies satisfying the search criteria of year and rating, when called
   * on a non empty movie tree with one match, and two matches and more. Vary your search criteria
   * such that the lookup() method must check in left and right subtrees. (3) Ensures that the
   * MovieTree.lookup() method throws a NoSuchElementException when called on a non-empty movie tree
   * with no search results found.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
   // test 1
	  MovieTree lookup = new MovieTree();
	  try {
		  lookup.lookup(2000, 5.0);
		  return false;
	  }
	  catch(NoSuchElementException e) {
		  System.out.println(e);
		  
	  }
	  
	  //test 2 
	  Movie clueless = new Movie(1995, 7.0, "Clueless");
	  Movie meanGirls = new Movie(1995, 9.0, "Mean Girls");
	  Movie up = new Movie(1997,6.0,"UP");
	  Movie ted = new Movie(2000,7.0,"Ted");
	  Movie SVU = new Movie(1995, 6.6, "SVU");
	  lookup.addMovie(clueless);
	  lookup.addMovie(meanGirls);
	  lookup.addMovie(up);
	  lookup.addMovie(ted);
	  
	  String expected = "Clueless, Mean Girls, Ted";
	  String actual = lookup.lookup(1995, 7.5).toString();
	 
	 
	  if (expected != actual) {
		  return false;
		  
		  
	  }
	  
	  //test 3
	  try {
		  lookup.lookup(1995, 6.6);
		  return false;
	  }
	  catch(NoSuchElementException e){
		  System.out.println(e);
	  }
	  
	  System.out.println("testLookup() working.");
	  return true;
	  
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
	  testLookup();
	  testGetBestMovie();
	  testHeight();
	  testContains();
	  testAddMovieToStringSize();

  }

}