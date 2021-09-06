package chp5;

import java.util.*;
import java.lang.*;
import java.io.*;
 

class Cube {
	
	private int num1;
	
	public Cube (int num)
	
	{
		
	this.num1 = (int) Math.pow (num, 3);
	
	}
	
	public int getnum1()
	{
		return num1;
	}
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("That value raised to the third power is: " + num1);
		return builder.toString();
	}
	
}