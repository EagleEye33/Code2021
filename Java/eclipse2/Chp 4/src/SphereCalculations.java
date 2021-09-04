
//********************************************************************
//  
//  SphereCalculations.java       Author: Lewis and Loftus & Baker
//  Date:  28 AUG 2008
//
//  Calculate  volume and surface area of a sphere
//  based on the same radius.
//
//  Use the constant Math.PI in all calculations.
//
//  Format numbers to 4 decimal places.
//  
//
//  Test data: radius = 7.5.
//
//  Results:
//             
//             Volume        = 1767.1459
//             Surface Area  = 706.8583
//********************************************************************

import java.util.Scanner;
import java.text.DecimalFormat;

public class SphereCalculations {
	// -----------------------------------------------------------------
	// Computes the volume and surface area of a sphere given its
	// radius.
	// -----------------------------------------------------------------
	public static void main(String[] args) {
		double radius ;
		double surfaceArea;
		double volume;

		Scanner sc = new Scanner(System.in);
		DecimalFormat fmt = new DecimalFormat("0.####");

		System.out.println("Welcome to the Sphere Calculator.");
		
		System.out.print("Enter the sphere's radius (0 to quit): ");
		radius = sc.nextDouble();
		
		do {
		

		volume = 4.0 / 3.0 * Math.PI * Math.pow(radius, 3);
		surfaceArea = 4 * Math.PI * Math.pow(radius, 2);

		System.out.println();
		System.out.println("The Results are: ");
		System.out.println("Radius: " + fmt.format(radius));
		System.out.println("Volume: " + fmt.format(volume));
		System.out.println("Surface area: " + fmt.format(surfaceArea));
		
		System.out.print("Enter the sphere's radius (0 to quit): ");
		radius = sc.nextDouble();
	
		} while (radius != 0);
	}
}