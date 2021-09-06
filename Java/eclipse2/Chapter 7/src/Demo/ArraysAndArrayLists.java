package Demo;
//Import statement for Array Lists
import java.util.ArrayList;

//Import statement for Iterator
import java.util.Iterator;

import java.util.Random;

public class ArraysAndArrayLists {

  public static void main(String[] args) {

 	 // Create an array of integers
 	 int arr[] = new int[5];
 	 // fill the array with values
 	 for (int col = 0; col < arr.length; col++) {
 		 arr[col] = col;
 	 }

 	 // Print out the array
 	 for (int i = 0; i < arr.length; i++) {
 		 System.out.println(arr[i]);
 	 }
 	 System.out.println("");

 	 ArrayList listTest = new ArrayList();

 	 // add Elements to Arraylist:listTest.add(4);
 	 // position 0
 	 listTest.add("Hello");

 	 // position 1
 	 listTest.add("World");

 	 // position 2
 	 listTest.add("This is");

 	 // position 3
 	 listTest.add("An Array list");

 	 // position 4:
 	 listTest.add(7);

 	 // posistion 5
 	 listTest.add(8);

 	 // To get the element:listTest.get(4);
 	 listTest.get(4);

 	 // To remove items:listTest.remove(2);
 	 listTest.remove(2);

 	 // To go through each item in an ArrayList you need an iterator
 	 // Then you need to attach the iterator to the array list

 	 Iterator it = listTest.iterator();

 	 // looping through whole ArrayList
 	 while (it.hasNext()) {
 		 System.out.println(it.next());
 	 }
 	 
 	 System.out.println("");
 	 //Create a random number and fill an array with a for each and print the values
 	 Random rand = new Random();
 	 int number=8;
 	 for (int num : arr) {
 		 int randNum = rand.nextInt();
 		 num = randNum;

 	 }
 	 for (int num : arr) {
 		 System.out.print(num);
 	 }
 	 System.out.println("");
 	 //Fill a array list with a for loop and print it out with a for each.
 	 for (int col=0;col<10;col++) {
 		 number++;
 		 listTest.add(number);
 	 }

 	 for (Object val : listTest) {
 		 System.out.print(val + " ");
 	 }

  }
}

//Finished Program

