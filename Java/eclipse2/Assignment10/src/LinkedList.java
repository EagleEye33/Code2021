// Assignment #: Arizona State University CSE205 #10
//         Name: Wyatt Colyn
//    StudentID: 121-547-4364
//      Lecture: TTh 4:30-5:45 p.m
//  Description: The LinkedList defines a linked list using its node class
//  object and also defines a iterator class to traverse the linked list.

import java.util.NoSuchElementException;

public class LinkedList
{
	ListIterator iterator = listIterator();
   //The only instance variable that points to the first node
   private Node first;

   //nested class to represent a node
   private class Node
   {
      public Object data;
      public Node next;
   }

   // Constructs an empty linked list.
   public LinkedList()
   {
      first = null;
   }

   //Returns the first element in the linked list.
   public Object getFirst()
   {
      if (first == null)
         throw new NoSuchElementException();
      return first.data;
   }

   //Removes the first element in the linked list.
   public Object removeFirst()
   {
      if (first == null)
         throw new NoSuchElementException();
      Object element = first.data;
      first = first.next;
      return element;
   }

   //Adds an element to the front of the linked list.
   public void addFirst(Object element)
   {
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      first = newNode;
   }

   //toString() method prints the elements out from front to tail
   public String toString()
   {
      ListIterator iterator = listIterator();
      String result  = "{ ";
      while (iterator.hasNext())
      {
         result += iterator.next() + " ";
      }
      result += "}\n";

      return result;
   }

  //*****************************************************************
  //size() method returns the number of nodes inside this LinkedList
  //*****************************************************************
   public int size()
   {
      ListIterator iterator = listIterator();
      int count = 0;
      while (iterator.hasNext())
      {
         count++;
         iterator.next();
      }
      return count;
   }

  //*************** Below is where you should add your own codes ***********

    //*****************************************************************
    //searchElement() method returns the index of the first occurrence of the parameter object
    //in the linked list if it exists. It returns -1 if it does not exit.
    //*****************************************************************
	public int searchElement(Object element) 
	{
		ListIterator iterator = listIterator();
		int q = 0;
		do {
			if (iterator.next().equals(element))
				return q;
			q++;
		} while (iterator.hasNext());
		return -1;
	}

	// *****************************************************************
	// getElement() method returns the element at the parameter index
	// If the index is out of bounds, throw an IndexOutOfBoundsException.
	// *****************************************************************
	public Object getElement(int index) 
	{
		ListIterator iterator = listIterator();
		int q = 0;
		int nn = size();
		if (index > nn || index < 0)
			throw new IndexOutOfBoundsException("Index not found");
		do {
			if (q == index)
				return iterator.next();
			q++;
			iterator.next();
		} while (iterator.hasNext());
		return "";
	}

	// *****************************************************************
	// setElement() method sets the parameter object at the parameter index in
	// the linked list.
	// If the index is out of bounds, throws an IndexOutOfBoundsException
	// *****************************************************************
	public void setElement(int index, Object element) 
	{
		ListIterator iterator = listIterator();
		int q = 0;
		int nn = size();
		if (index > nn || index < 0)
			throw new IndexOutOfBoundsException("Index not found");
		iterator.next();
		do {
			if (q == index) 
			{
				iterator.set(element);
				break;
			}
			iterator.next();
			q++;

		} while (q != index + 1);

	}

	// *****************************************************************
	// insertElement() method inserts the parameter object at the parameter
	// index.
	// If the index is out of bounds, throws an IndexOutOfBoundsException
	// Note: the element can be inserted at the end, i.e. inserted at size()
	// index/position
	// *****************************************************************
	public void insertElement(int index, Object element)
	{
		int nn = size();
		ListIterator iterator = listIterator();
		if (index > nn || index < 0)
			throw new IndexOutOfBoundsException("Index not found");
		for (int i = 0; i <= index; i++)
		{
			if (i == index)
			{
				iterator.add(element);
				break;
			}
			iterator.next();
		}
	}

	// *****************************************************************
	// removeElement()method removes and returns element at parameter index and
	// throw
	// an IndexOutOfBoundsException if the index is out of bounds
	// *****************************************************************
	public Object removeElement(int index) 
	{
		ListIterator iterator = listIterator();
		int q = 0;
		int nn = size();
		iterator.next();
		if (index > nn || index < 0)
			throw new IndexOutOfBoundsException("Index not found");
		do {
			if (q == index) 
			{
				iterator.remove();
				break;
			}
			iterator.next();
			q++;
		} while (q != index + 1);

		return "";

	}

	// *****************************************************************
	// countHowMany(Object) method returns the number of occurences of the
	// parameter object in the LinkedList
	// *****************************************************************
	public int countHowMany(Object searchedObject)
	{
		ListIterator iterator = listIterator();
		int count = 0;
		do {
			if (iterator.next().equals(searchedObject))
				count++;
		} while (iterator.hasNext());

		return count;
	}

	// *****************************************************************
	// removeDuplicate() method removes all occurences of the parameter objects
	// from the LinkedList
	// *****************************************************************
	public void removeDuplicate(Object removedObject) 
	{
		ListIterator iterator = listIterator();
		do {
			if (iterator.next().equals(removedObject))
				iterator.remove();
		} while (iterator.hasNext());
	}

	// *****************************************************************
	// insertAtFront(Object, int) method inserts the parameter object number of
	// times at the front of the linked list
	// for example, a call of insertAtFront("A", 3) will insert string "A" three
	// times in front of the linked list.
	// *****************************************************************
	public void insertAtFront(Object element, int howManyTimes)
	{
		ListIterator iterator = listIterator();
		for (int i = 0; i < howManyTimes; i++)
			iterator.add(element);
	}

	// *****************************************************************
	// appendAtEnd(Object, int) method appends the parameter object number of
	// times at the end of the linked list
	// for example, a call of appendAtEnd("B", 3) will append string "B" three
	// times at the end of the linked list.
	// *****************************************************************
	public void appendAtEnd(Object element, int howManyTimes)
	{
		int nn = size();
		ListIterator iterator = listIterator();
		for (int i = 0; i < nn; i++)
			iterator.next();
		for (int i = 0; i < howManyTimes; i++)
			iterator.add(element);

	}

	// *****************************************************************
	// insertInFront(Object element1, Object element2) method insert the
	// second parameter object, i.e. element2 immediately in front of the
	// first occurence of first parameter object - element1.
	// if element1 is not found inside the linked list, then insert element2
	// at the front/head of the linked list.
	// *****************************************************************
	public void insertInFront(Object element1, Object element2) 
	{
		ListIterator iterator = listIterator();
		int q = searchElement(element1);
		for (int i = 0; i < q; i++)
			iterator.next();
		iterator.add(element2);

	}

	// *****************************************************************
	// appendAfter(Object element1, Object element2) method appends the second
	// parameter object, i.e. element2 right after
	// the first occurence of first parameter object,
	// if element1 is not inside the linked list, then append element2 at the
	// front/head of the linked list.
	// *****************************************************************
	public void appendAfter(Object element1, Object element2) 
	{

		ListIterator iterator = listIterator();
		int q = searchElement(element1);
		for (int i = 0; i < q + 1; i++)
			iterator.next();
		iterator.add(element2);

	}

	// *****************************************************************
	// reverse(int howMany) reverse the first parameter number of elements
	// inside the linked list.
	// for example, if the original linked list is { A B C D E F G }, a call of
	// reverse(3) will
	// change the linked list to { C B A D E F G }. Note #1: you need to
	// consider the boundary value, i.e.
	// cases where howMany <= 0 or howMany > size()
	// Note #2: reverse(size()) should reverse the whole linked list
	// *****************************************************************
	public void reverse(int howMany) 
	{
		for (int i = 0; i < howMany - 1; i++) 
		{
			Object s = getElement(0);
			insertElement(howMany - i, s);
			removeElement(0);
		}
	}

//***********Don't change the following LinkedListIterator class******************

   //***************************************************************
   //Method creates an iterator on the current LinkedList
   //***************************************************************
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }

   //***************************************************************
   //nested class to define its iterator
   //***************************************************************
   private class LinkedListIterator implements ListIterator
   {

      private Node position;
      private Node previous;

      // Constructs an iterator that points to the front
      // of the linked list.   of the linked list.
      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

     // Moves the iterator past the next element, and returns
     // the traversed element's data.
      public Object next()
      {
    	 
         if (!hasNext())
            throw new NoSuchElementException();
         previous = position; // Remember for remove
 
         if (position == null)
            position = first;
         else
            position = position.next;

         return position.data;
      }

      // Tests if there is an element after the iterator position  position
      public boolean hasNext()
      {
         if (position == null)
            return first != null;
         else
            return position.next != null;
      }

      // Adds an element after the iterator position
      // and moves the iterator to the inserted element.
      public void add(Object element)
      {
         if (position == null)
         {
            addFirst(element);
            position = first;
         }
         else
         {
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            position.next = newNode;
            position = newNode;
         }
         previous = position;
      }

    // Removes the last traversed element. This method may
    // only be called after a call to the next() method.
      public void remove()
      {
    	 //System.out.println("position is: " + position);
         if (previous == position)
            throw new IllegalStateException();

         if (position == first)
         {
            removeFirst();
         }
         else
         {
            previous.next = position.next;
         }
         position = previous;
      }

      // Sets the last traversed element to a different value
      public void set(Object element)
      {
         if (position == null)
            throw new NoSuchElementException();
         position.data = element;
      }
   }
}