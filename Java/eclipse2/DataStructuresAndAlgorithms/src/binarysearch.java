public class binarysearch {
	public static int binarySearch(int[] a, int target) {
	    return binarySearch(a, 0, a.length-1, target);
	}

	public static int binarySearch(int[] a, int start, int end, int target) {
	    int middle = (start + end) / 2;
	    if(end < start) {
	        return -1;
	    } 

	    if(target==a[middle]) {
	        return middle;
	    } else if(target<a[middle]) {
	        return binarySearch(a, start, middle - 1, target);
	    } else {
	        return binarySearch(a, middle + 1, end, target);
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 5, 6, 11, 45, 245, 35, 2453, 2445, 13};
		int n = binarySearch(arr, 11);
		System.out.println(" Found " + arr[n] + " at index " + n);

	}

}
