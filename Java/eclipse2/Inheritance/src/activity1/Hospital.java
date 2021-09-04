package activity1;

import java.text.NumberFormat;

public class Hospital {


public static void main (String [] args)
{
	HospitalEmployee luke = new HospitalEmployee("Luke",5432,40.0,20.50);
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	System.out.println("Welcome to our Hospital");
	System.out.println("=======================");
	System.out.println("Beginning state of luke:");
	System.out.println(luke.toString());
	System.out.println("Luke Skywalker is a satisfactory HospitalEmployee. Bonus = "+fmt.format(luke.calculateBonus("satisfactory")));
	
	
	Doctor darth = new Doctor("Darth",9876,17,150.00,"Plastic Surgery");
	System.out.println("Beginning state of Darth:");
	System.out.println(darth.toString());
	System.out.println("Darth Vader is a  Doctor and works the evening shift. Bonus="+fmt.format(darth.calculateBonus("Evening Shift")));
	System.out.println("Darth Vader's login is: "+ darth.createLogin());
	System.out.println("");
	System.out.println("Number of HospitalEmployees created : " + darth.getHospitalEmployeeCount());
	Doctor Sith = new Doctor();
	System.out.println(Sith.toString());
	System.out.println("Number of HospitalEmployees created : " + darth.getHospitalEmployeeCount());
	


}
}