import java.lang.*;
import java.util.*;
/***
* @Author: Deja Dunlap
* @Date: March 5, 2021
* @ You are given N lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in yth position of xth  line.
*/
class Main {
  public static void main(String[] args) {
    //creates scanner
    Scanner in = new Scanner(System.in);

    //takes in the number of list you would like to create
    int numList = Integer.parseInt(in.nextLine()); 
    ArrayList<Integer>[] al = new ArrayList[numList];
    int counter = 0; 
  
    while (counter < numList) {
      //read in the list and splits it into String array
      String currentLine = in.nextLine();
      String[] currentString = currentLine.split(" ");

      //creates new arraylist in array
      al[counter]  = new ArrayList<Integer>();

      //convert String elements to int elements in arraylist
      for (int i = 0; i < currentString.length; i++){
         try {
           al[counter].add(Integer.parseInt(currentString[i]));  
        } catch (NumberFormatException e) {
           System.out.println("This is not a number");
           System.out.println(e.getMessage());
        } // ends try-catch
     }//ends for loop

      counter++;
    }//ends while loop

    //takes in the number of queries
    int numQueries = Integer.parseInt(in.nextLine());
    int[] indexOfAnswer = new int[numQueries];
    int[] listOfAnswer = new int[numQueries];

    //takes in the queries stats and stores them in arrays
    int queries = 0; 
    while (queries < numQueries){
      String currentQuery = in.nextLine();
      String[] currentString = currentQuery.split(" ");
      try {
      listOfAnswer[queries] = Integer.parseInt(currentString[0]);
      indexOfAnswer[queries] = Integer.parseInt(currentString[1]);
      } catch (NumberFormatException e) {
          System.out.println("This is not a number");
          System.out.println(e.getMessage());
      } // ends try-catch
      queries++;
    }

    //prints out the query answers
    for (int i = 0; i < queries; i++){
      try {
        System.out.println(al[listOfAnswer[i] - 1].get(indexOfAnswer[i]));
      } catch (IndexOutOfBoundsException e) {
        System.out.println("ERROR!");
      } // end try-catch
    }// ends for
    
    in.close();
  } //ends main method
} //ends main class