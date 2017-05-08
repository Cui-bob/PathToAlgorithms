import java.util.Arrays;
import java.util.Random;

public class MergeSort {
	
	public static void main(String[] arg)
	{
		int length = 10000;
		double[] array = new double[length];
		double[] arrayR = new double[length];
		Random r = new Random();
		for(int i=0;i<length;i++)
		{
			array[i] = r.nextDouble();
		}

		
		long time1,time2;
		
		for(int i=0;i<2;i++)
		{
			time1=System.currentTimeMillis();
			InsertSort.recursion(array,0);
			time2=System.currentTimeMillis();
			System.out.println("time1: " + (time2-time1));
			
			time1 = System.currentTimeMillis();
			mergeSort(array,0,array.length-1);
			time2 = System.currentTimeMillis();
			System.out.println("time2: " + (time2-time1));
		}
		//printArray(array);
	}
	
	
	public static double[] bubbleSort(double[] array2Sort)
	{
		//check array2Sort is not null, or return null
		if(array2Sort == null)
		{
			return null;
		}
		//put the array in a new references in order to not modified the original array
		double[] array = array2Sort;
		double temp;
		
		//[array2Sort.length] times sort should be performed
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array.length-i-1;j++)  //Since we have a [j+1] in the loop so we should only increase to j = length - i - 1
			{
				if(array[j] > array[j+1])
				{
					temp = array[j+1];
					array[j+1]=array[j];
					array[j]=temp;
				}
			}
		}
		return array;
	}
	
	static void merge_sort_recursive(double[] arr, double[] result, int start, int end) {
		if (start >= end)
			return;
		int len = end - start, mid = (len >> 1) + start;
		int start1 = start, end1 = mid;
		int start2 = mid + 1, end2 = end;
		merge_sort_recursive(arr, result, start1, end1);
		merge_sort_recursive(arr, result, start2, end2);
		int k = start;
		while (start1 <= end1 && start2 <= end2)
			result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
		while (start1 <= end1)
			result[k++] = arr[start1++];
		while (start2 <= end2)
			result[k++] = arr[start2++];
		for (k = start; k <= end; k++)
			arr[k] = result[k];
	}
	
	protected static void mergeSort(double[] srcArray, int startIndex, int endIndex)
	{
		int l = endIndex - startIndex + 1;
		int midPoint = startIndex + l/2 - 1;
		if(!(startIndex>=endIndex))
		{
			mergeSort(srcArray, startIndex,midPoint);
			mergeSort(srcArray, midPoint + 1, endIndex);
			double[] tempArray = new double[l];
			int i=0,j=0;
			while(true)
			{
				if(srcArray[startIndex + i]<srcArray[midPoint+1+j])
				{
					tempArray[i+j] = srcArray[startIndex+i];
					i++;
				}
				else
				{
					tempArray[i+j] = srcArray[midPoint+1+j];
					j++;
				}
				if(j>=endIndex - midPoint)
				{
					while(i+j<l)
					{
						tempArray[i+j] = srcArray[startIndex+i];
						i++;
					}
					break;
				}
				else if(i>midPoint - startIndex)
				{
					while(i+j<l)
					{
						tempArray[i+j] = srcArray[midPoint+1+j];
						j++;
					}
					break;
				}
			}
			for(int k=0;k<l;k++)
			{
				srcArray[startIndex + k] = tempArray[k];
			}
			//printArray(srcArray);
		}
		else
		{
			return;
		}
	}
	
	
	public static void tryMethod(double[] srcArray)
	{
		srcArray[0] = srcArray[1];
	}
	
	public static void printArray(double[] srcArray)
	{
		System.out.print("{ ");
		for(int i=0;i<srcArray.length - 1;i++)
		{
			System.out.print(Double.toString(srcArray[i]) + " , ");
		}
		System.out.println(Double.toString(srcArray[srcArray.length-1]) + " }");
	}

}
