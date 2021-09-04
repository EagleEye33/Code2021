package InheritancePrograms;
import java.util.ArrayList;
public class DemoObjectClassUse {
	
		public static void main(String[] args)
		{
			// Create an ArrayList of size 3
			ArrayList arr = new ArrayList(3);

			// Add three objects to the list - String, Integer, Double
			arr.add(new String("Woohoo i got added!")); // Pos = 0
			arr.add(new Integer(24));					// Pos = 1 
			arr.add(new Double(45.235));				// Pos = 2

			/*
			Since the ArrayList has three objects of three different types, we want to 
			use the Object class ( remember superclass to all Java classes ) to refer
			to the different objects in our ArrayList
			*/
			for (Object obj : arr)
			{
				System.out.println(obj);
		}
	}
}

