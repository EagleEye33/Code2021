
public class BubbleSort {

	private static void main(String[] args)
	{
		int temp;
		int [] barray = {33, 45, 13, 20, 30, 33, 65};
		
		for(int i = 0; i < (barray.length-1); i++)
				{
			for(int j = (i+1); j < barray.length; j++)
			{
				if (barray[j] < barray[i])
				{
					temp = barray[i];
					barray[i] = barray[j];
					barray[j] = temp;
					
				}
			}
				}
	}
}
