public class ProductParser {
	
	public static Product parseStringToProduct(String lineToParse)
	{
		String []parse = new String[6]; //string array to hold argument
		parse = lineToParse.split("/"); //splits string around matches of the given expression and returns a String array

		Product pt = null; //product reference to hold child objects 
		
		if(parse[0].equalsIgnoreCase("clothing")) 
			pt = new Clothing(parse[1], Integer.parseInt(parse[2]), Double.parseDouble(parse[3]), parse[4], parse[5]); //creates and adds Clothing object to Product reference
		
		if(parse[0].equalsIgnoreCase("food")) 
			pt = new Food(parse[1], Integer.parseInt(parse[2]), Double.parseDouble(parse[3]), parse[4], Double.parseDouble(parse[5]), parse[6]); //creates and adds Food object to Product reference 
		
		return pt;
	}
}