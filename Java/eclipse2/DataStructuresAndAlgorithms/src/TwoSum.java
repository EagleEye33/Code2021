public class TwoSum {
	
    public int[] twoSum(int[] nums, int target) {
        int compute = 0;
 for(int i=0; i<nums.length-1; i++)
 {
     for(int j=1; j<nums.length; j++)
     {
         compute = nums[i] + nums[j];
         if(compute == target)
             return new int[] {i, j};
     }
 }
 throw new IllegalArgumentException("No solution");
    }

	public static void main(String[] args) {
		

	}

}
