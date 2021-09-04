package chp5;

/*Program Name: 	 HospitalEmployee.java
Author : Wyatt Colyn
Brief Description: Creates a class called Hospital Employee that represents
an employee in the hospital.
*/
import java.text.NumberFormat;	

public class HospitalEmployee {
	
	
	private String empName;
	private int empNumber;
	private double hoursWorked;
	private double payRate;
	private static int hospitalEmployeeCount = 0;
	
	public HospitalEmployee()
	{
		empName = "Wyatt Colyn";
		empNumber = 9999;
		hoursWorked = 0;
		payRate = 0.0;
		
		hospitalEmployeeCount++;
	}
	// returns the employee name
	public HospitalEmployee(String eName, int eNumber, double hours, double pay)
	{
		empName = eName;
		empNumber = eNumber;
		hoursWorked = hours;
		payRate = pay;
		
		hospitalEmployeeCount++;
	}
	
	public String getEmpName()
	{
		return empName;
	}
	
	public int getEmpNumber()
	{
		return empNumber;
	}
	
	public double gethoursWorked()
	{
		return hoursWorked;
	}
	
	public double getpayRate()
	{
		return payRate;
	}
	
	public void setEmpName(String eName)
	{
		empName = eName;
	}
	public void setEmpNumber(int eNumber)
	{
		empNumber = eNumber;
	}
	public void setHoursWorked(double hours)
	{
		hoursWorked = hours;
	}
	public void setPay(double pay)
	{
		payRate = pay;
	}
	public static int getHospitalEmployeeCount()
	{
		return hospitalEmployeeCount;
	}
	// calculates and returns the employee’s gross pay (hours worked * pay rate)
	public double calculateGrossPay()
	{
		return (hoursWorked*payRate);
	}
	
	// changes the instance variable hoursWorked by the hours .
	// hoursWorked should be updated to hoursWorked + hours.
	public void changeHoursWorked(double hours)
	{
		hoursWorked = hoursWorked + hours;
	}
	
	// changes the instance variable payRate by the amount.
	// payRate should be updated to payRate + amount.
	public void changePayRate(double amount)
	{
		payRate = payRate + amount;
	}
	
	// returns 500 if rating is “excellent”
	// returns 300 if rating is “satisfactory”
	// All other ratings return 0 . 
	public double calculateBonus(String rating)
	{
		double bonus = 0;
		
		if (rating.equals("excellent"))
			{
				bonus = 500.00;
			}
		else if (rating.equals("satisfactory"))
			{
				bonus = 300.00;
			}
		else
			{
				bonus = 0;
			}
		return bonus;
	}
	public double calculateBonus(int evaluation)
	{
		double bonus = 0;
		if (evaluation == 1)
		{
			bonus = 100;
		}
		else
		{
			bonus = 50;
		}
		return bonus;
	}
	// returns the current state of this employee as a String
	// (current values of all instance variables also called the current state)
	public String toString( )
	{
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		return ("\n" + "Employee name: " + empName + "    Employee Number: " + empNumber + "    Hours Worked: " + hoursWorked + "    Pay Rate: " + fmt.format(payRate));

	}
	
}