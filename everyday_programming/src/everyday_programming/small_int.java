package everyday_programming;

import java.util.Scanner;

public class small_int {
	public small_int() {
		
		int[] A = {2,3,7,8};
		int max = 0;
		
		for(int i = 0; i < A.length ; i++) {
			if(A[i] > max)
				max = A[i];
		}
		
		int[] check = new int[max+2];
		
		for(int i = 0 ; i < A.length; i++) {
			if(A[i] < 0)
				continue;
				check[A[i]]++;
			}
		
		for(int j = 1 ; j < check.length; j++) {
			if(check[j] == 0 ) {
				System.out.println("가장 작은 양수는 " + j);
				break;
			}				
		}
			
	}
}
