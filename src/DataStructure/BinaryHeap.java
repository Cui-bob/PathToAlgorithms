package DataStructure;

public class BinaryHeap {

	class HeapNode{
		int val;
		HeapNode left;
		HeapNode right;
		HeapNode parent;
		
		public String toString(){
			return Integer.toString(val);
		}
		
		public HeapNode(int val){
			this.val = val;
		}
	}
	
	public int size = 0;
	
	public HeapNode binaryHeap = null;
	
	public void add(int val){
		if(binaryHeap == null){
			binaryHeap = new HeapNode(val);
			size++;
			return;
		}
		int depth = log(size+1);
		int index = (((size+1) - (1<<depth))/2)+1;
		int lor = ((size+1) - (1<<depth))%2;  //left or right: 0 for l and 1 for r;
		HeapNode toAdd = binaryHeap;
		for(int i=0; i < depth - 1; i++){
			if(index<=(1<<(depth-i-1))/2){
				toAdd = toAdd.left;
			}else{
				toAdd = toAdd.right;
				index -= (1<<(depth-i-1))/2;
			}
		}
		HeapNode parent = toAdd;
		if(lor==0){
			
			toAdd= toAdd.left;
			toAdd = new HeapNode(val);
			parent.left = toAdd;
		}else{
			toAdd = toAdd.right;
			toAdd = new HeapNode(val);
			parent.right = toAdd;
		}
		
		size++;
		toAdd.parent = parent;
		upperAdjust(toAdd);
	}
	
	private static int log(int n){
		int result = 0;
		while(n!=1){
			n=(n>>1);
			result++;
		}
		return result;
	}
	
	private void upperAdjust(HeapNode o){
		int tmp;
		if(o.parent!=null && o.val < o.parent.val){
			tmp = o.val;
			o.val = o.parent.val;
			o.parent.val = tmp;
			upperAdjust(o.parent);
		}
	}
	
	private void lowerAdjust(HeapNode o){
		if(o.right == null || (o.left!=null && o.left.val<o.right.val)){
			if(o.left == null || o.val <= o.left.val){
				return;
			}
			int tmp = o.left.val;
			o.left.val = o.val;
			o.val = tmp;
			lowerAdjust(o.left);
		}else{
			if(o.val<=o.right.val){
				return;
			}
			int tmp = o.right.val;
			o.right.val = o.val;
			o.val = tmp;
			lowerAdjust(o.right);
		}
	}
	
	public int poll(){
		int result = binaryHeap.val;
		if(size==1){
			binaryHeap = null;
			size--;
			return result;
		}
		
		int depth = log(size);
		int index = (((size) - (1<<depth))/2)+1;
		int lor = ((size) - (1<<depth))%2;  //left or right: 0 for l and 1 for r;
		HeapNode toHead = binaryHeap;
		for(int i=0; i < depth - 1; i++){
			if(index<=(1<<(depth-i-1))/2){
				toHead = toHead.left;
			}else{
				toHead = toHead.right;
				index -= (1<<(depth-i-1))/2;
			}
		}
		
		if(lor==0){
			binaryHeap.val = toHead.left.val;
			toHead.left = null;
		}else{
			binaryHeap.val = toHead.right.val;
			toHead.right = null;
		}
		size--;
		lowerAdjust(binaryHeap);
		return result;
	}
	
	
	public static void main(String[] args){
		BinaryHeap bp = new BinaryHeap();

		bp.add(1);
		bp.add(1);
		bp.add(1);
		bp.add(1);
		bp.add(1);
		bp.add(2);
		bp.add(2);
		bp.add(2);
		bp.add(2);
		bp.add(2);
		bp.add(2);
		bp.add(2);
		bp.add(3);
		bp.add(3);
		bp.add(3);
		bp.add(3);

		for(int i=0;i<6;i++)
			System.out.println(bp.poll());
	}
	

	
}
