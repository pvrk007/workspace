
public class InsertionSort {
	public static void main (String[] args){
		int input [] = {4,5,3,2,6,1};
		insertionSort(input);
		System.out.println("final exit");
		printArray(input);		
	}

	private static void insertionSort(int[] input) {
		// TODO Auto-generated method stub
		System.out.println(input.length);
		for(int i=1;i<input.length;i++){
			for(int j=i;j>0;j--){
				if(input[j]<input[j-1]){
					int temp = input[j-1];
					input[j-1]=input[j];
					input[j]=temp;
				}
				System.out.println("after first loop");
				printArray(input);
				
			}
		}
		System.out.println("after second loop");
		printArray(input);
		
	}

	private static void printArray(int[] input) {
		// TODO Auto-generated method stub
		for(int k=0;k<input.length;k++){
			System.out.print(input[k]+", ");
		}
	}
}
