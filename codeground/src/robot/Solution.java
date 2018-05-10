package robot;


import java.util.Scanner;

class Solution {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			/////////////////////////////////////////////////////////////////////////////////////////////
			
			
			int robot_num = sc.nextInt();
			int r = sc.nextInt();
			int l = sc.nextInt();
			
			
			int[] robot = new int[r];
			
			for(int i = 0; i < r; i++) {
				robot[i] = sc.nextInt();
			}
			
			if((2 * r * robot_num) < l) {
				Answer = -1;
			} else {
				int flag = (0 - robot[0] >= l - robot[robot_num])? 1: 0;
				if(flag == 1 ) {
					for(int i = 0; i < robot_num; i++ ) {
						
					}
				} else {
					for(int i = robot_num; i > 0; i-- ) {
						
					}
					
				}
				
			}
			
			
			
			
			/////////////////////////////////////////////////////////////////////////////////////////////


			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}