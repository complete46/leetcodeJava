
public class WiggleSort {
	public static void wiggle_sort(int[] arr) {  
	    if (arr.length < 2) return;
	    boolean inc = true;
	    int prev = arr[0];
	    
	    for (int i = 1; i < arr.length; i++) {
	    	if ((inc && arr[i] >= prev) || (!inc && arr[i] <= prev)) {
	    		arr[i - 1] = prev;
	    		prev = arr[i];
	    	} else {
	    		arr[i - 1] = arr[i];
	    		arr[i] = prev;
	    	}
	    	
	    	inc = !inc;
	    }
	    
	    for (int i : arr) {
	    	System.out.print(i + " ");
	    }
	}  
	
	public static void main(String[] args) {
		int[] arr = {8, 2, 10, 1, 2, 5, 99, 10};
		wiggle_sort(arr);
		
		WiggleSort ws = new WiggleSort();
		System.out.print(ws.hashCode());
		
	}
}
