package campus_road;

import java.util.Scanner;

public class Solution {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			int uni = sc.nextInt();
			int road_num = sc.nextInt();
			
			
			int[][] road = new int[uni+1][uni+1];
			int[][] check = new int[uni+1][uni+1];
			
			
					
			for(int i = 0; i < road_num; i++) {
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();				
				int value = sc.nextInt();
				
				road[num1][num2] = value;
				road[num2][num1] = value;
				
			}		
				
			for(int k = 1; k <= uni; k++) {
				for(int row = 1; row <= (uni/2)+1; row++) {
					for(int col = 1; col <= uni; col++) {
						if(road[row][k] != 0 && road[k][col] != 0 && row != col) {
							if(road[row][col] == 0) {								
								road[row][col] = road[row][k] + road[k][col];
								road[col][row] = road[col][k] + road[k][row];
								check[row][col] = k;
								check[col][row] = k;
								
							} else {
								if(road[row][col] > road[row][k] + road[k][col]) {
									road[row][col] = road[row][k] + road[k][col];
									road[col][row] = road[col][k] + road[k][row];
									check[row][col] = k;
									check[col][row] = k;
								}								
							}								
						}
					}
				}
			}
			
//			for(int i = 1; i <= uni; i++) {
//				for(int j = 1; j <= uni; j++) {
//					System.out.print(road[i][j] +",");
//				}
//				System.out.println();
//			}
//			
//			System.out.println();
//			System.out.println();
//			
//			for(int i = 1; i <= uni; i++) {
//				for(int j = 1; j <= uni; j++) {
//					System.out.print(check[i][j] +",");
//				}
//				System.out.println();
//			}
//			
//			System.out.println();
//			System.out.println();
			
			
			int[] sum = new int[uni+1];
			
			for(int i = 1 ; i <= (uni/2)+1; i++) {
				for(int j = 1; j <= uni; j++) {
					sum[check[i][j]]++;
				}				
			}
			
			int count = 0;
			
			
			for(int i= 1; i <= uni; i++) {
				if(sum[i] == 0) {
					count++;
				}
			}
			
			
			/////////////////////////////////////////////////////////////////////////////////////////////


			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			//System.out.println(Answer);
			System.out.print(count + " ");
			
			for(int i= 1; i <= uni; i++) {
				if(sum[i] == 0) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
	}
}
