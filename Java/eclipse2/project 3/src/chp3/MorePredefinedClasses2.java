package chp3;
import java.text.DecimalFormat;
import java.math.RoundingMode;
public class MorePredefinedClasses2 {
	/* 
	  Program Name : MorePredefinedClasses2.java
	  Author : P Baker
	  Date Written : 
	  Class : CSC110AA and CIS163AA
	  
	  Brief Description: 
			   Ch 3 -  Introduces some more predefined classes
			  -Math
			  -DecimalFormat
			  
	  */
	  

	  

		  	public static void main(String[] args)
		  	{
		
		  		double num1;
		  		double num2;
		  		double num3;
		
		 	
		
				    /*Example: Using the Math class. Ch 3.5
					   This class is automatically available.
					   No import statement is needed. 
					   This is a unique class, all methods are static, and
				      we do not create Math objects.  We just call the methods
				      with the class name.
		
				      Example:  Take the square root of a number (must be pos)
						Example:  Show how to use the pow function
				    */
		
				     num1 = Math.sqrt(4);
				     System.out.println("The square root of 4 is: " + num1);
					  num1 = Math.pow(4,3);
					  System.out.println("4 raised to the 3rd power is : " + num1);
		
				     num2 = 4.57;
					  num3 = Math.sqrt(num2);
				     System.out.println("The square root of " + num2 + ": " + num3);
		
				     /*Example:  Formatting data Ch 3.6
					    Now lets format that number so it only has 2 decimal places
				       Step 1.  import java.text.DecimalFormat;
		  		       Step 2.  Declare and instantiate a DecimalFormat object
		  		       Step 3.  Use the format method
				     */
		
				      DecimalFormat dFmt = new DecimalFormat("0.###");
				      dFmt.setRoundingMode(RoundingMode.DOWN);
					  System.out.println("The square root of " + num2 +  ": "
					  		+ dFmt.format(num3));
		
		
			  }
		
	 }

	

