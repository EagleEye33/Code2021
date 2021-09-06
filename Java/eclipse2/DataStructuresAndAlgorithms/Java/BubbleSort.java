
public class BubbleSort {

	public void Bubblesort()
	{
		int temp = 0;
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

private static void main(String[] args)
	{
		BS = new BubbleSort();
		System.out.println(BS.Bubblesort());
	}
		