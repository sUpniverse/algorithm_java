package frog_jump;

import java.util.Scanner;

public class Solution {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			int stone_num  = sc.nextInt();
			int[] stone = new int[stone_num+1];
			stone[0] = 0;
			
			for(int i = 1; i <= stone_num; i++) {
				stone[i] = sc.nextInt();				
			}				
			
			int jump = sc.nextInt();
			int stone_point = 0;
//			while(stone_point != stone_num || Answer != -1) {				
//				for(int i = stone_num; i > stone_point ; i--) {
//					if(stone[stone_point] + jump >= stone[i]) {
//						Answer++;
//						stone_point = i;
//						break;					
//					} else if(i == stone_point + 1) {
//						Answer = -1;
//						break;
//					}					
//				}
//			}
			
			for(int i = 0; i < stone_num; i++) {				
				for(int j = jump; j >= 0; j--) {
					if(stone[i+1] <= stone[i] + j) {
						Answer++;
						break;
					}
				}
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
			
		}
	}

}
