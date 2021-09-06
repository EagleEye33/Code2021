package activity1;
//Ch6 Activity 4 - Die Class  - SOLUTION
//Author : Lewis and Baker
//Date:
//Brief Description : This class represents
//  one die (singular of dice) with faces 
//  showing values between 1 and maxValue.  
//  Usually the maxValue is 6, but there 
//  are other dice with 8 sides, etc.  

import java.util.Random;

public class Die
{
//instance variables
private int faceValue;  //current value showing on die object
private int maxValue;   //the maximum face value allowed

//constructor - sets faceValue to 1 and maxValue to 6
public Die()
{
		faceValue = 1;
		maxValue = 6;
}

//faceValue mutator.  Only allows the faceValue
//to be set with valid values between 1 and maxValue
//otherwise no change is made to faceValue
public void setFaceValue(int value)
{
	  if (value >= 1 && value <= maxValue)
	      faceValue = value;
}

//faceValue accessor.  
//returns the object's current faceValue
public int getFaceValue()
{
    return faceValue;
}

//randomly generates a number between 1 and maxValue
//sets the faceValue to this number
public void roll()
{
  Random gen = new Random();
	 faceValue = gen.nextInt(maxValue) + 1;
}

public String toString()
{
   return ("faceValue : " + faceValue
	         +" maxValue : " + maxValue); 
}	
}//end of class Die