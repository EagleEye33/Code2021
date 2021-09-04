package Stacks;
import java.util.Stack;
import java.util.Scanner;

public class ReverseStack {
	

	

	private Stack s = new Stack();

    public void ReverseStack( String str )
    {
    	
        for(int j = 0; j < str.length(); j++)
        {
            s.push( str.charAt( j ) );
        }

        while(s.isEmpty() != true)
        {    
            System.out.print(s.pop());
        }
    	}
    
    
    public static void main (String[] args)

    {	
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter some words");
    	String words = scanner.nextLine();
    	
    	ReverseStack stacky = new ReverseStack();
    	stacky.ReverseStack(words);
    }
}
