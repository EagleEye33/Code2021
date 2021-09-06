package activity1;

//********************************************************************
//Class Name: HospitalEmployee.java     Base class for Inheritance   
//Authors: Lewis and Loftus and 	Patricia Baker
//Brief Description:
//         Defines a HospitalEmployee - base class or super class
//       
//
//********************************************************************

import java.text.NumberFormat;

public class HospitalEmployee
{
protected String empName;
protected int empNumber;
protected double hoursWorked;
protected double payRate;
	
	private static int hospitalEmployeeCount = 0;


//-----------------------------------------------------------------
//  Sets up this hospital employee with default information.
//-----------------------------------------------------------------
public HospitalEmployee()
{
   empName =  "Chris Smith";
   empNumber = 9999;
   hoursWorked = 0;
   payRate = 0;
		
		hospitalEmployeeCount++;

}
	
	//overloaded constructor.
	public HospitalEmployee(String eName, int eNumber, double hours, double pay)
	{
		empName = eName;
		empNumber = eNumber;
		hoursWorked = hours;
		payRate = pay;
		
		hospitalEmployeeCount++;
	
	}

//-----------------------------------------------------------------
//  Sets the name for this employee.
//-----------------------------------------------------------------
public void setEmpName (String eName)
{
   empName = eName;
}


//-----------------------------------------------------------------
//  Sets the employee number for this employee.
//-----------------------------------------------------------------
public void setEmpNumber (int eNumber)
{
   empNumber = eNumber;
}

//-----------------------------------------------------------------
//  Sets the hours worked for this employee.
//-----------------------------------------------------------------
public void setHoursWorked (double hours)
{
    hoursWorked = hours;
 }

//-----------------------------------------------------------------
//  Sets the pay rate  for this employee.
//-----------------------------------------------------------------
public void setPayRate (double rate)
{
    payRate = rate;
 }


//-----------------------------------------------------------------
//  Returns this employee's name.
//-----------------------------------------------------------------
public String getEmpName()
{
   return empName;
}


//-----------------------------------------------------------------
//  Returns this employee's number.
//-----------------------------------------------------------------
public int getEmpNumber()
{
   return empNumber;
}

//-----------------------------------------------------------------
//  Returns hours worked.
//-----------------------------------------------------------------
public double getHoursWorked()
{
   return hoursWorked;
}

//-----------------------------------------------------------------
//  Returns employee payRate
//-----------------------------------------------------------------
public double getpayRate()
{
   return payRate;
}


	//-----------------------------------------------------------------
//  Returns this employee's gross pay.
//-----------------------------------------------------------------
public double calculateGrossPay()
{
   return (hoursWorked * payRate);
}


//-----------------------------------------------------------------
//  This adds or subtracts hours from the hoursWorked instance var.
//-----------------------------------------------------------------
public void changeHoursWorked(double hours)
{
   hoursWorked = hoursWorked + hours;
}

//-----------------------------------------------------------------
//  Changes the instance variable payRate by the amount
//-----------------------------------------------------------------
public void changePayRate(double amount)
{
	    payRate = payRate + amount;
}

//---------------------------------------------------------------
// Calculates a bonus based on a rating
	//  Returns 500 for excellent employees
	//  Returns 300 for satisfactory employees
	//  Returns 0 for all other ratings
//
//  good example to overload.  
//---------------------------------------------------------------
public double calculateBonus(String rating)
{
	  
	   double bonus = 0.0;
	   rating = rating.toLowerCase();

	   if (rating.equals("excellent") )
	   {
		   bonus = 500;
	   } else if (rating.equals("satisfactory") )
		{
		   bonus = 300;
		} //everyone else is 0
		
	   return bonus;
}


//overloaded calculateBonus
//bonus is calculated as a percent of gross pay
//percent = 10% passed in a 10

public double calculateBonus(double percent)
{
   double bonus = calculateGrossPay() * percent / 100.0;
   return bonus;

}

//-----------------------------------------------------------------
//  Returns a description of this employee as a string.
//-----------------------------------------------------------------
public String toString()
{
   NumberFormat fmt = NumberFormat.getCurrencyInstance();
   return ("empName: " + empName + "\t empNumber: " + empNumber + "\t hoursWorked: " +
    hoursWorked + "\t payRate: " + fmt.format(payRate) + "\n" );
}
	
	//static method that returns number of HospitalEmployee objects created
	public static int getHospitalEmployeeCount( )
	{
	
			return hospitalEmployeeCount;
	
	}


}