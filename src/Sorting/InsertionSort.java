package Sorting;

import java.util.Arrays;

public class InsertionSort {
	public static int[] insertionSort(int[] nums){
		try{
			int[] result = new int[nums.length];
			for(int i=1;i<nums.length;i++){
				for(int j=i-1;j>=0;j--){
					if(result[j]>nums[i]){
						result[j+1]=result[j];
					}else{
						result[j+1]=nums[i];
						break;
					}
				}
			}
			return result;
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
