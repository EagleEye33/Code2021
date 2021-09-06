package InheritancePrograms;

	/*
	DYNAMIC METHOD DISPATCH

	Since a superclass reference variable can refer to a subclass object, JAVA uses this to resolve
	calls to overridden methods during runtime. When an overridden method is called using a superclass
	reference, JAVA determines the correct method to execute based on the type of the object that is
	being referred to. 

	NOTE - The superclass has to contain a method that is overridden by its subclassses inorder for
	this to work.
	*/
	class A
	{
		void methodPrint()
		{
			System.out.println("Inside A's methodPrint() method!");
		}
	}

	class B extends A
	{
		void methodPrint()
		{
			System.out.println("Inside B's methodPrint() method!");
		}
	}

	class C extends B
	{
		void methodPrint()
		{
			System.out.println("Inside C's methodPrint() method!");
		}
	}

	public class DemoDynamicDispatch
	{
		public static void main(String[] args)
		{
			// Create an object of each class
			A a = new A();
			B b = new B();
			C c = new C();

			// Create a reference variable for class A(Parent class)
			A ref;

			ref = a; // ref only refers to A's object
			ref.methodPrint();

			ref = b; // ref only refers to B's object
			ref.methodPrint();

			ref = c; // ref only refers to C's object
			ref.methodPrint();
			
			A ref1;
			ref1 = c;
			ref1.methodPrint();
		}
}
