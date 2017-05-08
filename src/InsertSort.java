
public class InsertSort {

	public static double[] recursion(double[] srcArray, int index)
	{
		double temp;
		int position = findPlace(srcArray,0,index-1,srcArray[index]);
		temp = srcArray[index];
		for(int j=index;j>position;j--)
		{
			srcArray[j] = srcArray[j-1];
		}
			srcArray[position]=temp;
		if(index<srcArray.length-1)
		{
			recursion(srcArray,++index);
		}
		return srcArray;
	}
	
	/**
	 * 二分查找法 -- 迭代
	 * @param srcArray
	 * @param start
	 * @param end
	 * @param srcNumber
	 * @return
	 */
	public static int findPlace(double[] srcArray, int start, int end, double srcNumber)
	{
		if(srcArray[(end-start)/2 + start] > srcNumber)
		{
			if((end-start)/2 + start == start)
				return start;
			else
				return findPlace(srcArray,start,(end-start)/2 + start - 1,srcNumber);
		}
		else if(srcArray[(end-start)/2 + start] < srcNumber)
		{
			if((end-start)/2 + start == end)
				return end + 1;
			else
				return findPlace(srcArray,(end-start)/2 + start + 1,end,srcNumber);
		}
		else
		{
			return (end-start)/2 + start;
		}
	}
	
	public static void main(String[] arg)
	{
		double[] srcArray = {3,9,2,5,6,3,4,5,7,8,3};
		recursion(srcArray,0);
		System.out.println(findPlace(srcArray,0,8,3));
	}
}
