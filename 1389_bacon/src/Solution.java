import java.util.Scanner;

public class Solution {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int user_num = sc.nextInt();
		int rel_num = sc.nextInt();
	
		int[][] relation = new int[user_num+1][user_num+1];
		int answer = 0;
		int sum = 0;
		int value = Integer.MAX_VALUE;
		
		
		for(int i = 1; i <= rel_num; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			relation[num1][num2] = 1;
	 		relation[num2][num1] = 1;
		}
		
		
		for(int i = 1 ; i <= user_num ; i++) {  				// 가운데 노드, 여기를 거쳐간다.
			for(int row = 1; row <= user_num; row++) { 		// 시작노드
				for(int col = 1; col <= user_num; col++) {	// 종착노드
					if(relation[row][i] != 0 && relation[i][col] != 0 ) {
						if(relation[row][col] > relation[row][i] + relation[i][col]) {
							if(relation[row][col] == 0) {
								relation[row][col] = relation[row][i] + relation[i][col];
								relation[col][row] = relation[row][i] + relation[i][col];
							} else {
								relation[row][col] = Math.min(relation[row][col], relation[row][i] + relation[i][col]);
								relation[col][row] = relation[row][i] + relation[i][col];
							}														
						}
					}					
				}
			}
		}
		
		for(int i = 1 ; i <= user_num; i++ ) {
			for(int j = 1 ; j <= user_num; j++) {
				sum += relation[i][j];
				System.out.println(sum);
			}
			System.out.println();
			if(value > sum) {
				value = sum;
				answer = i;
			}
			sum = 0;
		}
		System.out.println(answer);
	}
}
