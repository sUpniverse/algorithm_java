import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int com_num = sc.nextInt();
		int rel_num = sc.nextInt();
		
		int[][] relation = new int[com_num+1][com_num+1];
		
		boolean[] check = new boolean[com_num+1];
		
		for(int i = 1; i <= rel_num ; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			relation[num1][num2] = 1;
			relation[num2][num1] = 1;
		}
		
		dfs(check,relation,1);
		
		int answer = 0;
		for(int i = 2; i <= com_num; i++) {
			if(check[i]) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	public static void dfs(boolean[] check,int[][] relation, int com) {
		for(int j = 1; j <= check.length - 1 ; j++) {
			if(relation[com][j] == 1 && !check[j]) {			
				check[j] = true;
				dfs(check,relation,j);
			}			
		}
		return ;
	}
}
