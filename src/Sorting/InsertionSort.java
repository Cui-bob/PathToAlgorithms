package Sorting;

import java.util.Arrays;

public class InsertionSort {
	public static int[] insertionSort(int[] nums){
		try{
			int tmp;
			for(int i=1;i<nums.length;i++){
				tmp = nums[i];
				int j;
				for(j=i-1;j>=0;j--){
					if(nums[j]>tmp){
						nums[j+1]=nums[j];
					}
					else{
						break;
					}
				}
				nums[j+1]=tmp;
			}
			
			return nums;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args){
		int[] nums = {6,5,4,7,8,3,2,7};
		System.out.print(Arrays.toString(insertionSort(nums)));
	}

}
