package demo1;

import java.util.Scanner;

public class StatsArrayTester {

public static void main (String[] args)
{
Scanner scanner = new Scanner(System.in);
StatsArray stats = new StatsArray();
System.out.println("Welcome to our StatsArray\n");

stats.fillArrayFromUser();
System.out.println("your max value is" + stats.getMax());
}
}