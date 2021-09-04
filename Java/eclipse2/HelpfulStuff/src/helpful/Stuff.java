package helpful;

public class Stuff {

	public static void main (String[] args) {
		
		  //for(int counter=0; counter<=10; counter++)
		 // {
			  
		  
				//if(counter %2 != 0)
				//{
				//	counter = counter + 1;
				//	System.out.print(counter + "\t");
				//}
				//The output is 2 4 6 8 10
				//1 modulus 2 is equal to 1. 2 cannot go into 1, so the remainder is 1
		//  }
		  
		  //String a = new String("now is");
		  //String b = new String("the time");
		  //String c = new String(" the");
		  
		  // Date-type operations(String) 
		  
		  /*Instance Method Call   Return Type   Return Value
		   *a.length()				int					6
		   *a.charAt(4)				char				'i'
		   *a.substring(2, 5)		String				"w i"
		   *b.startsWith("the")		boolean				true
		   *a.indexOf("is")			int					4
		   *a.cocat(c)				String				"now is the"
		   *b.replace("t", "T"		String				"The Time"
		   *a.split(" ")			String[]			{ "now", "is" }
		   *b.equals(c)				boolean				false
		   */
		 
		  //Extract file name and extension from a command-line argument
				
		  //String s = args[0];
		  //int dot = s.indexOf(".");
		  //String base = s.substring(0, dot);
		  //String extension = s.substring(dot + 1, s.length());
		  
		  //translate DNA to mRNA
				
		  /*public static String translate(String dna)
		  {
			  dna = dna.toUpperCase();
			  String rna = dna.replaceAll("T", "U");
			  return rna;
		  }
		  */
		
		//User Input for an Array
		/*int length;
		 * Scanner input = new Scanner(System.in);
		 * 
		 * System.out.println(How many friends do you have?);
		 * length = input.nextInt();
		 * 
		 * String[] names = new String[length];
		 * 
		 * for(int counter = 0; counter < length; counter++){
		 * System.out.println("Enter name of friends "+(counter+1));
		 * names[counter] = input.next();
		 * }
		 * 
		 * input.close();
		 * 
		 * System.out.println("your friends are");
		 * for(int counter=0; counter < length; counter++) {
		 * System.out.println(names[counter]);
		 *
		 */
		
		/* null strings return null pointer exception
		String a = ""; is a empty string
		Check if string is empty(and not null):
		if(string != null && string.length() == 0
		{
		return true; 
		}
		*/
		}
			
}


