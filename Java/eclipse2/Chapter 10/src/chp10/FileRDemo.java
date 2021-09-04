package chp10;
//Program Name : FileRDemo.java  Student starting File for Files Activity 1
//             Example of Reading from a file
//Author : P Baker
//Date : 
//Brief Description:  We will use this starting file to show an example
//                  of reading and writing to stream files.
//
//IOExceptions are checked exceptions.  So either must catch or list
//in method header.  We chose the later.
//
//Using Eclipse note:  Create a Java package under src.  All files must be
//                   inside the same Java package.  In my example
//                   I created a package called ch10Files.  So the path 
//                   for all files will be src/ch10Files/~~~~

import java.io.*; //needed for FileReader
import java.text.DecimalFormat;
import java.util.Scanner;


public class FileRDemo {

	public static void main(String[] s) throws IOException 
	{
		//declare and instantiate the input file object and open the file
		Scanner inFile = new Scanner(new FileReader("src/chp10/StudentGrades.txt"));
		PrintWriter outFile = new PrintWriter("src/chp10/GradeReport.txt");
		DecimalFormat fmt = new DecimalFormat("0.##");
		
		String line; //variable to put each line as read
		int exam1, exam2, exam3;
		String firstname, lastname;

		/*use while because don't know how many lines in the file
		  hasNextLine returns false when the end of the file is reached. */
		outFile.println("Java Class Grade Report");
		outFile.println("-----------------------");
		while ( inFile.hasNextLine())
		{
				line = inFile.nextLine();
				
				Scanner tokens = new Scanner(line);
				tokens.useDelimiter(" |,");
				
			firstname = tokens.next();
			lastname = tokens.next();
				exam1 = tokens.nextInt();
				exam2 = tokens.nextInt();
				exam3 = tokens.nextInt();
				
				double average = (exam1 + exam2 +exam3) / 3.0;
				
				System.out.println(firstname.substring(0, 1) + ". " + lastname + "has an exam average of " + average + ". ");
				outFile.println(firstname.substring(0, 1) + ". " + lastname + "has an exam average of " + average + ".");
				
				//System.out.println(line);
				//outFile.println(line);

		tokens.close();
		}

			        //close the file
		inFile.close();
		outFile.flush();
		outFile.close();
	} 
}