package cctv;

import java.util.Scanner;

public class Main {
	static int[][] map;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		map = new int[num1][num2];
		
		int end = 0;
		for(int i = 0; i < num1; i++) {
			for(int j = 0; j < num2; j++) {			
				map[i][j] = sc.nextInt();;
			}
		}
		
		int[][] check = new int[num1][num2];
		int answer = 0;
		
		for(int i = 0; i < num1; i++) {
			for(int j = 0; j < num2; j++) {				
				if(map[i][j] == 5) {
					Move_left(i,j,1);
					Move_right(i,j,1);
					Move_top(i,j,1);
					Move_bottom(i,j,1);
				}					
			}
		}
		
		for(int i = 4; i > 0 ; i--)
			solve(i);	
//		
//		
//		for(int i = 0; i < num1; i++) {
//		for(int j = 0; j < num2; j++) {			
//			System.out.print(map[i][j]);
//		}
//		System.out.println();
//	
		for(int i = 0; i < num1; i++) {
			for(int j = 0; j < num2; j++) {				
				if(map[i][j] == 0) 
					answer++;
			}
		}	
		
		
		System.out.println(answer);
		
	}
	
	public static void solve(int z) {
		 for(int i = 0; i < map.length; i++) {
			 for(int j = 0; j < map[i].length; j++) {
				 if(map[i][j] == 1 && map[i][j] == z) {
					 
					 int max = 0;
					 int value = 0;
					 int position = 0;
					 
					 value = Move_left(i,j,0);
					 position = (max > value)? position : 1;
					 max = (max > value)? max : value;
					 value = Move_right(i,j,0);
					 position = (max > value)? position : 2;
					 max = (max > value)? max : value;
					 value = Move_top(i,j,0);
					 position = (max > value)? position : 3;
					 max = (max > value)? max : value;
					 value = Move_bottom(i,j,0);
					 position = (max > value)? position : 4;
					 max = (max > value)? max : value;
					 
					 switch (position) {
					case 1:
						Move_left(i,j,1);
						break;

					case 2:
						Move_right(i,j,1);
						break;
						
					case 3:
						Move_top(i,j,1);
						break;
						
					case 4:
						Move_bottom(i,j,1);
						break;
					}
					 
				 }else if(map[i][j] == 2 && map[i][j] == z) {
					 int max = 0;
					 int value = 0;
					 int position = 0;
					 
					 value = Move_left(i,j,0) + Move_right(i,j,0);
					 position = (max > value)? position : 1;
					 max = (max > value)? max : value;
					 value = Move_top(i,j,0) + Move_bottom(i,j,0);
					 position = (max > value)? position : 2;
					 max = (max > value)? max : value;			 
					 
					 switch (position) {
						case 1:
							Move_left(i,j,1);
							Move_right(i,j,1);
							break;

						case 2:
							Move_top(i,j,1);
							Move_bottom(i,j,1);
							break;							
						}
					 
				 }else if(map[i][j] == 3 && map[i][j] == z) {
					 int max = 0;
					 int value = 0;
					 int position = 0;
					 
					 value = Move_top(i,j,0) + Move_left(i,j,0);
					 position = (max > value)? position : 1;
					 max = (max > value)? max : value;
					 value = Move_left(i,j,0) + Move_bottom(i,j,0);
					 position = (max > value)? position : 2;
					 max = (max > value)? max : value;
					 value = Move_bottom(i,j,0) + Move_right(i,j,0);
					 position = (max > value)? position : 3;
					 max = (max > value)? max : value;
					 value = Move_right(i,j,0) + Move_top(i,j,0);
					 position = (max > value)? position : 4;
					 max = (max > value)? max : value;
					 
					 switch (position) {
						case 1:
							Move_top(i,j,1);
							Move_left(i,j,1);
							break;

						case 2:
							Move_left(i,j,1);
							Move_bottom(i,j,1);
							break;
							
						case 3:
							Move_bottom(i,j,1);
							Move_right(i,j,1);
							break;
							
						case 4:
							Move_right(i,j,1);
							Move_top(i,j,1);
							break;
						}
					 
				 }else if(map[i][j] == 4 && map[i][j] == z) {
					 int max = 0;
					 int value = 0;
					 int position = 0;
					 
					 value = Move_top(i,j,0) + Move_left(i,j,0) + Move_right(i,j,0) ;
					 position = (max > value)? position : 1;
					 max = (max > value)? max : value;
					 value = Move_top(i,j,0) + Move_left(i,j,0) + Move_bottom(i,j,0) ;
					 position = (max > value)? position : 2;
					 max = (max > value)? max : value;
					 value =  Move_left(i,j,0) + Move_bottom(i,j,0) + Move_right(i,j,0);
					 position = (max > value)? position : 3;
					 max = (max > value)? max : value;
					 value = Move_bottom(i,j,0)+ Move_right(i,j,0) + Move_top(i,j,0);
					 position = (max > value)? position : 4;
					 max = (max > value)? max : value;
					 
					 switch (position) {
						case 1:
							Move_top(i,j,1);
							Move_left(i,j,1);
							Move_right(i,j,1);
							break;

						case 2:
							Move_top(i,j,1);
							Move_left(i,j,1);
							Move_bottom(i,j,1);
							break;
							
						case 3:
							Move_left(i,j,1);
							Move_bottom(i,j,1);
							Move_right(i,j,1);
							break;
							
						case 4:
							Move_bottom(i,j,1);
							Move_right(i,j,1);
							Move_top(i,j,1);
							break;
						}
					 
				 }
			 }
		 }
			
	}
	
	public static int Move_left(int i, int j, int k) {
		int cnt = 0;
		while(j >= 0 && j < map[i].length && map[i][j] != 6) {
			if(map[i][j] == 0  && k == 0) 
				cnt++;
			else if(map[i][j] == 0 && k == 1)
				map[i][j] = 9;
			j--;
		}
		return cnt;
	}
	
	public static int Move_right(int i, int j, int k) {
		int cnt = 0;
		while(j >= 0 && j < map[i].length && map[i][j] != 6) {
			if(map[i][j] == 0  && k == 0)
				cnt++;
			else if(map[i][j] == 0 &&k == 1)
				map[i][j] = 9;
			j++;
		}
		return cnt;
	}
	
	public static int Move_top(int i, int j, int k) {
		int cnt = 0;
		while(i >= 0 && i < map.length && map[i][j] != 6) {
			if(map[i][j] == 0  && k == 0)
				cnt++;
			else if(map[i][j] == 0 && k == 1)
				map[i][j] = 9;
			i--;
		}		
		return cnt;
	}
	
	public static int Move_bottom(int i, int j, int k) {
		int cnt = 0;
		while(i >= 0 && i > map.length && map[i][j] != 6) {
			if(map[i][j] == 0  && k == 0)
				cnt++;
			else if(map[i][j] == 0 &&k == 1)
				map[i][j] = 9;
			i++;
		}
		return cnt;
	}
	
}
