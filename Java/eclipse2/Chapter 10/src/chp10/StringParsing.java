package chp10;

public class StringParsing {

	public static void main(String[] args) {
		String test = "Donald Duck,90,80,90";
		
		String[] testArray = test.split(" |,");
		
		for(String s :testArray) {
			System.out.print(s);
		}
		// TODO Auto-generated method stub

	}

}
