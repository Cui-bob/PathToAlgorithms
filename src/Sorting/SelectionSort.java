package Sorting;

import java.util.Arrays;

public class SelectionSort {
	public static int[] selectionSort(int[] nums){
		int tmp;
		int smallest = 0;
		
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				if(nums[smallest]>nums[j]){
					smallest = j;
				}
			}
			tmp = nums[i];
			nums[i] = nums[smallest];
			nums[smallest] = tmp;
			smallest = i+1;
		}
		
		return nums;
	}
	
	public static void main(String[] args){
		int[] nums = {6,4,2,6,8,4,5,2};
		System.out.print(Arrays.toString(selectionSort(nums)));
	}
}
