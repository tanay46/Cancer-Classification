
/**
 * This class Tests the Nearest and k-Nearest Neighbor Algorithms on the Wisconsin Breast Data Set, and prints out the results.
 * 
 * @author Tanay Jaipuria
 * @version Version 1
 */

import java.io.*;
import java.util.*;

public class NearestNeighborTester
{
  /** a 2-d array containing the data from the dataset. */
  static double[][] data = new double[569][31];
  
  /** contains the row index of the data array which needs to be filled using the dataset */
  static int row=0;
  
  /** contains the column index of the data array which needs to be filled using the dataset */
  static int column=0;
  
  /** a constant used to represent that a tumor is malignant */
  static final double malignant = 1.0;
  
  /** a constant used to represent that a tumor is benign */
  static final double benign = 0.0;
  
  /**
   * Main method which runs the NearestNeighbor and k-NearestNeighbor algorithms and prints results.
   * @param args The arguements, the 1st and only one which should be the dataset.
   * @throws IOException Exception if the file is not found
   * @throws ArrayIndexOutOfBoundsException Exception which occurs if 1 comman line arguement was not entered
   */
  public static void main(String[] args) //main method
  { //begin main method
  boolean again=true;
  while(again) {
  try{
      readFile(args[0]);
      int numberofrepetitions = 100;
      double totalaccuracy = 0.0;
      //call nearest neighbor algorithm
      for(int i=0; i<numberofrepetitions; i++) //100 repetitions
      {
          NearestNeighbor n = new NearestNeighbor(); //create instance of NearestNeighbor class
          double accuracy = n.getNearestNeighborAccuracy(data); //call getNearestNeighborAccuracy method from object.
          totalaccuracy = totalaccuracy + accuracy;
      }
      System.out.println("The average accuracy is " + (totalaccuracy/numberofrepetitions) + " percent over " +numberofrepetitions + " repetitions"); // print accuracy
      for(int k=3;k<9;k=k+2) // run algo for 3 different k values
      {
        totalaccuracy=0;
        for(int i=0; i<numberofrepetitions; i++) // 100 repetitions
        {
          NearestNeighbor kn = new NearestNeighbor(); //create instance of NearestNeighbor class
          double accuracy = kn.kNearestNeighbor(k,data); //call kNearestNeighbor algorithm with the value of k
          totalaccuracy = totalaccuracy + accuracy;
        }
        System.out.println("The average accuracy is " + (totalaccuracy/numberofrepetitions) + " percent over " +numberofrepetitions + " repetitions, when the value of K is " +k); //print accuracy and k value
      }
      again = false;
    }
    catch(IOException e)
    {
        System.out.println("That file was not found. Please reenter the name of the file");
        Scanner scan = new Scanner(System.in);
        args[0]=scan.next();
    }
    catch(ArrayIndexOutOfBoundsException e){
	System.out.println("Enter a command line arguement!!");
    again=false;
    }  

  }
}//end main method
  /**
   * Reads one line of the data file at a time
   * @param filename the name of the dataset, which is wdbc.data by default
   */
  public static void readFile(String filename) throws IOException //reads one line of the data file at a time.
  { //begin readFile method
      Scanner scanner = new Scanner(new File(filename));
      scanner.useDelimiter(System.getProperty("line.separator")); 
      while (scanner.hasNext()) 
      {
        parseLine(scanner.next());
      }
      scanner.close();
  } //end readFile method
  /**  
   * Takes one line of data at a time, and parses the contents into an array
   * @param line the string of text to parse and put into the array. contains 32 items seperated by commas.
   */ 
  public static void parseLine(String line) //takes a line at a time, and parses the contents into an array
  { // begin parseLine method
      Scanner lineScanner = new Scanner(line);
      lineScanner.useDelimiter(","); //use comma as seperator
      double ignore = lineScanner.nextDouble(); //ignore id number
      String MorB = lineScanner.next(); // Malignant or Benign
      if(MorB.equals("B")) // if benign
          data[row][column]=benign; 
      else if(MorB.equals("M")) //if malignant
          data[row][column]=malignant;
      column++;
      while(lineScanner.hasNextDouble()) //while there is a double
      {
        data[row][column] = lineScanner.nextDouble(); //add it to the array
        column++;
      }
      lineScanner.close();
      row++; //increase row to prepare for next line.
      column=0;
  } //end parseLine method
} //end TestNearestNeighbor class
          
              
              
