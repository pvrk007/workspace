
public class Quicksort {
	public static void main (String[] args){
		int[] input = {41,15,4,53,5,63,12,23};
			quickSort(input,0,7);
		System.out.println("final exit");
		printArray(input);		

}

	private static void printArray(int[] input) {
		// TODO Auto-generated method stub
		for(int k=0;k<input.length;k++){
			System.out.print(input[k]+", ");
		}
	}

	private static void quickSort(int[] input, int start, int end) {
		// TODO Auto-generated method stub
		if(start>=end)
		{
			return;
		}	
		int pi = partition(input,start,end);
		
		quickSort(input,start,pi-1);
		quickSort(input,pi+1,end);
		
	}

	private static int partition(int[] input, int start, int end) {
		// TODO Auto-generated method stub
		int pivot=input[end];
		int pi=start;		
		for(int j=pi;j<end;j++){
			if(input[j]<pivot){
				int temp = input[j];
				input[j]=input[pi];
				input[pi]=temp;
				pi++;
			}
		}
		int temp = input[pi];
		input[pi]=input[end];
		input[end]=temp;

		return pi;
	}

}
