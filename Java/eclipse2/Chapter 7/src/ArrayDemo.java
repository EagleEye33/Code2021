

import java.util.Scanner;

public class ArrayDemo {
	public static void main(String[] args) {
		// double[] rain = new double[7];
		/*
		 * rain[0]=0.1; rain[1]=0.0; rain[2]=0.2; rain[3]=0.4; rain[4]=0.0; rain[5]=0.0;
		 * rain[6]=0.1;
		 */

		double[] rain = { 0.1, 0.0, 0.2, 0.4, 0.0, 0.0, 0.1 };
		String[] values = { "Hello", "World" };

		// Scanner[] scanner= {new Scanner(System.in),new Scanner(System.in)};

		// for(int x=0;x <= rain.length -1;x++)
		/*
		 * for(int x=0;x < rain.length;x++) { rain[x]=0.0; }
		 */
		for (int x = 0; x < rain.length; x++) {
			System.out.println("Index " + x + " = " + rain[x]);
		}
		System.out.println("Max = " + findMax(rain));
		System.out.println("Mim = " + findMin(rain));
		System.out.println("Average = " + average(rain));
		System.out.println("Sum = " +sum(rain));
	}

	public static double findMax(double[] arr) {
		double max = arr[0];
		for (int x = 1; x < arr.length; x++) {
			if (arr[x] > max) {
				max = arr[x];
			}
		}
		return max;
	}

	public static double findMin(double[] arr) {
		double min = arr[0];
		for (int x = 1; x < arr.length; x++) {
			if (arr[x] < min) {
				min = arr[x];
			}
		}
		return min;
	}

	public static double average(double[] arr) {
		double average = 0.0;
		double sum=sum(arr);
		average=sum/arr.length;
		return average;
	}
	public static double sum(double[] arr)
	{
		double sum=0.0;
		for(int x=0; x< arr.length;x++)
		{
			sum+= arr[x];
		}
		return sum;
	}
}
