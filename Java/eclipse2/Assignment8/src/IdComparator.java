import java.util.Comparator;

// Assignment #: Arizona State University CSE205 #8
//         Name: Wyatt Colyn
//    StudentID: 121-547-4364
//      Lecture: TTh 4:30 - 5:45 p.m
//  Description: sorts by ID
public class IdComparator implements Comparator<Food>
{

	  public int compare(Food first, Food second)
	  {
		  if(first.getId() < second.getId())
			  return -1;
		  if(first.getId() > second.getId())
			  return 1;
		  if(first.getId() == second.getId())
			  return 0;
		return 0;
	  }
}