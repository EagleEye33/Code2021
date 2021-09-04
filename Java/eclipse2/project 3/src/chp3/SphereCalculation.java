/*Program Name: Sphere Calculation
 * Author: Wyatt Colyn
 * Brief Description: Calculates the volume and surface area of a sphere.
 * Pseudocode: Prompt the user for the radius with the scanner class. Calculate the corresponding volume and surface area for that sphere using Math constants
 *and floating points. Instantiate a decimal format object to round the answer to four decimal places.
 */

package chp3;
import java.text.DecimalFormat;
import java.util.Scanner;
public class SphereCalculation {

	public static void main(String[] args) {
		System.out.println("Welcome to the Sphere Calculator.");
		
		double radius;
		double volume;
		double surfacearea;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the sphere's radius: ");
		radius = scan.nextDouble();
		
		volume = (4.0/3.0) * Math.PI * Math.pow(radius, 3);
		surfacearea = (4.0) * Math.PI * Math.pow(radius, 2);

		DecimalFormat dFmt = new DecimalFormat("0.####");
		
		System.out.println("The results are:\n" +
		"Radius: " + radius + "\n" +
		"Volume: " + dFmt.format(volume) + "\n" +
		"Surface area: " + dFmt.format(surfacearea));
		
		/*Test Output 1:
		 * Welcome to the Sphere Calculator.
		Enter the sphere's radius: 4.2
		The results are:
		Radius: 4.2
		Volume: 310.3391
		Surface area: 221.6708
		
		Test Output 2:
		Welcome to the Sphere Calculator.
		Enter the sphere's radius: 7.5
		The results are:
		Radius: 7.5
		Volume: 1767.1459
		Surface area: 706.8583
		 */
	}

}