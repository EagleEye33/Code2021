package chp5;
import java.text.NumberFormat;	

/*Program Name: 	 HospitalEmployee.java
//Author : Wyatt Colyn
Brief Description: Creates a tester class called Hospital that will use the methods in Hospital Employee
*/	

public class Hospital {

	public static void main(String[] args)
	{
		NumberFormat fmt = NumberFormat.getCurrencyInstance();

		
		System.out.println("Welcome to our Hospital");
	
		HospitalEmployee worker1 = new HospitalEmployee();
		
		System.out.println("\nBeginning State of Worker 1: " + worker1.toString());
		
		worker1.changePayRate(4.50);
		
		worker1.changeHoursWorked(30);
		
		System.out.println("\nAfter pay rate and hours worked increase: " + worker1.toString());
	
		worker1.getEmpName();
		
		System.out.println(" \nEmployee " + worker1.getEmpName() + " earned " + fmt.format(worker1.calculateGrossPay()));

		worker1.calculateBonus("excellent");
		
		System.out.println("\nAfter Bonus: " + worker1.getEmpName() + " recieved a bonus of " 
		+ worker1.calculateBonus("excellent") + " and earned a total of "
		+ fmt.format(worker1.calculateGrossPay() + worker1.calculateBonus("excellent")));
		
		System.out.println("\n====================================");
		
		HospitalEmployee worker2 = new HospitalEmployee("Larry Bird", 9998, 40, 26.10);

		System.out.println("\nState of Worker 1: " + worker1.toString());
		
		System.out.println("\nState of Worker 2: : " + worker2.toString());
	
		System.out.println("\nState of Workers after worker2 pay rate and hours worked reset. ");

		System.out.println("\nState of Worker 1: " + worker1.toString());
		
		worker2.setPay(12.25);
		
		worker2.setHoursWorked(15);
		
		System.out.println("\nState of Worker 2: : " + worker2.toString());
		
		System.out.println("\nEmployee " + worker2.getEmpName() + " earned " + fmt.format(worker2.calculateGrossPay()));
		
		System.out.println("\nAfter bonus: " + worker2.getEmpName() + " recieved a bonus of " + fmt.format(worker2.calculateBonus(1)));
		
		System.out.println("\nNumber of HospitalEmployees created: " + HospitalEmployee.getHospitalEmployeeCount());
		
		System.out.println("\nGood Bye");
/*
 Output: 
 
Welcome to our Hospital

Beginning State of Worker 1: 
Employee name: Wyatt Colyn    Employee Number: 9999    Hours Worked: 0.0    Pay Rate: $0.00

After pay rate and hours worked increase: 
Employee name: Wyatt Colyn    Employee Number: 9999    Hours Worked: 30.0    Pay Rate: $4.50
 
Employee Wyatt Colyn earned $135.00

After Bonus: Wyatt Colyn recieved a bonus of 500.0 and earned a total of $635.00

====================================

State of Worker 1: 
Employee name: Wyatt Colyn    Employee Number: 9999    Hours Worked: 30.0    Pay Rate: $4.50

State of Worker 2: : 
Employee name: Larry Bird    Employee Number: 9998    Hours Worked: 40.0    Pay Rate: $26.10

State of Workers after worker2 pay rate and hours worked reset. 

State of Worker 1: 
Employee name: Wyatt Colyn    Employee Number: 9999    Hours Worked: 30.0    Pay Rate: $4.50

State of Worker 2: : 
Employee name: Larry Bird    Employee Number: 9998    Hours Worked: 15.0    Pay Rate: $12.25

Employee Larry Bird earned $183.75

After bonus: Larry Bird recieved a bonus of $100.00

Number of HospitalEmployees created: 2

Good Bye
	
	*/
	
	}

}