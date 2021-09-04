//Hopsital class
// Author: Wyatt Colyn
// Date Written: April 26, 2018

package activity1;

import java.text.NumberFormat;
import java.util.Random;
public class Doctor extends HospitalEmployee {
	
	private String specialty;
	private int hospitalEmployeeCount;
	
	public Doctor() {
		super.empName = "Doc";
		empNumber = 1337;
		hoursWorked = 45;
		payRate = 42.50;
		specialty = "ForceChoke";
		
	}

	public  Doctor(String eName, int eNumber, int hours, double pay, String special)
	{
		payRate = pay;
		hoursWorked = hours;
		empNumber = eNumber; 
		empName = eName;
		specialty = special;
		hospitalEmployeeCount++;
	}
	
	public String getSpecialty()
	{
		return specialty;
	}
	public void setSpecialty(String special)
	{
		specialty = special;
	}
	public double calculateBonus(String shift)
	{
		
		double percent=0;
		if (shift.equalsIgnoreCase("Night Shift")) {
			percent=10;
		} else if (shift.equalsIgnoreCase("Evening Shift")) {
			percent= 5;
		} else {
			percent= 0;
		}
	    double bonus = calculateGrossPay() * percent / 100.0;
	      return bonus;

	}
	public String createLogin()
	{
		Random rand = new Random();
		int random = rand.nextInt(9);
		String name;
		name = getEmpName().substring(0,2);
		int end = getEmpNumber();
		return name + random + end;
		
	}
	public String toString()
	{
		 NumberFormat fmt = NumberFormat.getCurrencyInstance();
		   return ("empName: " + empName + "\t empNumber: " + empNumber + "\t hoursWorked: " +
		    hoursWorked + "\t payRate: " + fmt.format(payRate) + "\n" + " specialty: "+ specialty);
	}
}
/*
Welcome to our Hospital
=======================
Beginning state of luke:
empName: Luke	 empNumber: 5432	 hoursWorked: 40.0	 payRate: $20.50
Luke Skywalker is a satisfactory HospitalEmployee. Bonus = $300.00
Beginning state of Darth:
empName: Chris Smith	 empNumber: 9876	 hoursWorked: 0.0	 payRate: $0.00 specialty: Plastic Surgery
Darth Vader is a  Doctor and works the evening shift. $127.50
Darth Vader's login is: Da89876

Number of HospitalEmployees created : 3
*/