import java.io.File;


public class MaxRangeSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		String s = "7 -3 -10 4 2 8 -2 4 -5 -2 -1";		
		String[] sArray = s.split(" ");		
		int[] nums = new int[sArray.length];		
		for (int i=0; i<sArray.length; i++){
			nums[i] = Integer.parseInt(sArray[i]);
		}
		
	//	int[] nums = {7, -3, -10, 4, 2, 8, -2, 4, -5, -2 };  
		if (nums==null || nums.length==0){
	            System.out.println(0);
	        }
	        
	        int sum =0, max=Integer.MIN_VALUE;
	        
	        for (int i=0; i< nums.length; i++){
	            sum=sum+ nums[i];
	            max = Math.max(sum,max);
	            sum = Math.max(sum,0);
	        }
	        System.out.println(max);
	}

}
