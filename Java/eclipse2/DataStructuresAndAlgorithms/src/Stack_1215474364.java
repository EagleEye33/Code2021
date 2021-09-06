// quiz: ASU CSE205 Assignment #9
//         Name: Wyatt Colyn			
//    StudentID: 121-547-4364
//      Lecture: TTh 4:30-5:45 p.m
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;

public class Stack_1215474364 {
	private Node initialNode;
	private int N, maxSize;
	
	public Stack_1215474364()
	{
		this.initialNode = null;
		this.N = 0;
	}
	
	private class Node
	{
		Object value;
		Node nodePointer;
	}
	
	public void push(Object value)
	{
		if(isFull()) throw new StackOverflowError("Stack overflow");
		Node newestNode = new Node();
		newestNode.value = value;
		newestNode.nodePointer = initialNode;
		initialNode = newestNode;
		N++;
	}
	
	public void pop()
	{
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		Object removedValue = initialNode.value;
		initialNode = initialNode.nodePointer;
		N--;
		System.out.println("The value you popped was " + removedValue);
		//return removedValue;
		
	}
	
	private String display()
	{
		Node test = initialNode;
		Object p;
		while(test != null)
		{
			p = test.value;
			System.out.println(p);
			test = test.nodePointer;
		}
		return "";
	}
	
	public boolean isEmpty()
	{
		if(N == 0)
		return true;
			return false;
	}
	
	public boolean isFull()
	{
		if(N == maxSize)
			return true;
		return false;
	}
	public int getSize()
	{
		return N;
	}
	
	public void setSize(int n)
	{
		this.maxSize = n;
	}
	
	public static void main(String[] args) {
		Stack_1215474364 linkedListStack1 = new Stack_1215474364();
		Stack_1215474364 stack = linkedListStack1;
		linkedListStack1.setSize(10);
		Object obj;
		int NN;
		char input1;
try {
		Scanner scan = new Scanner(System.in);
		InputStreamReader ir = new InputStreamReader (System.in);
		BufferedReader stdin = new BufferedReader (ir);
		System.out.println("An initial stack of size 10 has been created");
		do
		{
		System.out.println("Select A to push an element. B to pop. C to display. E to create a new stack. Q to quit");
		System.out.println("What action would you like to perform?\n");
	    String l = stdin.readLine().trim();  
	    input1 = l.charAt(0);
	    input1 = Character.toUpperCase(input1);

	         if (l.length() == 1)          
	          {
	           switch (input1)
	            {
	             case 'A': 
	            	 try{
	            	 System.out.println("Enter an element: ");
	            	 obj = stdin.readLine().trim(); 
	            	 stack.push(obj);
	            	 System.out.println("Element added. Your stack size in now "  + stack.getSize() + "\n");
	            	 } catch (StackOverflowError e)
	            	 {
	            		 System.out.println("Stack overflow. Your element was not added.\n");
	            	 }
	           	break;
	             case 'B':
	            	 try{
	            	 stack.pop();
	            	 System.out.println("Your stack size in now " + stack.getSize() + "\n");
	            	 }catch (NoSuchElementException e)
	         		{
	         			System.out.println("stack underflow\n");
	         		}
	            break;
	             case 'C':
	            	 stack.display();
	            	 System.out.println();
	            break;
	             case 'E':
	            	 try{
	         		System.out.println("enter your new stack size: ");
	         		String input2  = stdin.readLine().trim();
	         		NN = Integer.parseInt(input2);
	         		//NN = scan.nextInt();
	         		Stack_1215474364 linkedListStack2 = new Stack_1215474364();
	         		stack = linkedListStack2;
	         		linkedListStack2.setSize(NN);
	         		System.out.println();
	            	 }catch (NumberFormatException e)
	            	 {
	            		 System.out.println("Numbers only\n");
	            	 }
	         	break;
	            }
	          }
			}while(input1 != 'Q');
		}
		catch (IOException exception)
	      {
	        System.out.print("IO Exception\n");
	      }
		}
	
	}