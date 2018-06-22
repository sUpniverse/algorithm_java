package chicken;

import java.util.Scanner;

public class Main {
	
	
	static int[][] chicken;
	static int[][] pic;
	static int[][] home;
	static int N;
	static int M;
	static int chick_num = 0;
	static int home_num = 0;
	static int min;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
			
		chicken = new int [14][2];
		home = new int [(2*N)+1][2];
		pic = new int[14][2];
		
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < N; j ++) {
				int a = sc.nextInt();
				if(a == 2) {
					chicken[chick_num][0] = i;
					chicken[chick_num++][1] = j;
				} else if(a == 1) {
					home[home_num][0] = i;
					home[home_num++][1] = j;
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		dfs(0,0);
		System.out.println(min);
	}	
	
	public static void dfs(int pic_num,int search_num) {
		if(search_num > chick_num)  {//base case
			return ;
		}
		
		if((search_num == chick_num) && (pic_num == M)) {   //base case, pic다한 경우
			int sum = 0;			
			for(int i = 0; i < home_num; i++) {
				int tmp = Integer.MAX_VALUE;
				for(int j = 0; j < M; j++) {
					if(tmp > (Math.abs(pic[j][0] - home[i][0]) + Math.abs(pic[j][1] - home[i][1]))) 
						tmp = (Math.abs(pic[j][0] - home[i][0]) + Math.abs(pic[j][1] - home[i][1]));
				}
				sum += tmp;
				if(min <= sum)
					return;
			}
			if(min > sum)
				min = sum;
			return;
		} 
		
		if(pic_num < M) {
			pic[pic_num][0] = chicken[search_num][0];
			pic[pic_num][1] = chicken[search_num][1];
			dfs(pic_num+1,search_num+1);
		}
		dfs(pic_num,search_num+1);
	}
}
