
public class MergeSort {
	public static void main (String[] args){
		int[] input = {4123,15123,4123,5322,55666,6321,12,231};
		mergeSort(input);
		System.out.println("final exit");
		printArray(input);		
	}

	private static void printArray(int[] input) {
		// TODO Auto-generated method stub
		for(int k=0;k<input.length;k++){
			System.out.print(input[k]+", ");
		}
	}

	private static void mergeSort(int[] input) {
		// TODO Auto-generated method stub
		int l=input.length;
		if(l<2){
			return;
		}
		else
		{
			long temp=Math.round(Math.ceil(l/2));
			int mid=(int) temp;
			int left[]=new int[mid];
			int right[]=new int[l-mid];
			for(int i=0;i<mid;i++){
				left[i]=input[i];
			}
			for(int j=mid;j<l;j++){
				right[j-mid]=input[j];
			}
			mergeSort(left);
			mergeSort(right);
			merge(left,right,input);
		}
	}

	private static void merge(int[] left, int[] right, int[] input) {
		// TODO Auto-generated method stub
		int x=left.length;
		int y=right.length;
		int i=0;int j=0;int k=0;
		while(i<x && j<y)
		{
			if(left[i]<=right[j])
			{
				input[k]=left[i];
				i++;
			}
			else{
				input[k]=right[j];
				j++;
			}
			k++;
		}
		while(i<x)
		{
			input[k]=left[i];
			i++;
			k++;
		}
		while(j<y)
		{
			input[k]=right[j];
			j++;
			k++;
		}
	}

}		
