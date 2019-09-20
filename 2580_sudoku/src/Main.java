import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int[][] map;
	static int cnt;
	
	public static void main(String[] args) {
		map = new int[9][9];
		int[][] inform = new int[30][2];
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		cnt = 0;
		for(int i = 0; i < 9 ; i++) {
			for(int j = 0 ; j < 9 ; j++) {
				num = sc.nextInt();
				map[i][j] = num;
				if(num == 0) {
					inform[cnt][0] = i;
					inform[cnt][1] = j;
					cnt++;
				}
			}
		}
		
		
		
		for(int i = 0; i < 9 ; i++) {
			for(int j = 0 ; j < 9 ; j++) {
				num = sc.nextInt();
				System.out.println(map[i][j]);				
			}
		}	
		
	}
	public static void solve() {
		int a = 0;
		int b = 0;
		for(int i =0 ; i < cnt; i++) {
			a = map[i][0];
			b = map[i][1];
			
			checkHorizontal(a,b);
			checkVertical(a,b);
		}
	}
	
	
	public static void checkHorizontal(int a, int b) {
		int[] graphX = new int[9];
		for(int i = 0; i < 9; i++)  {
			graphX[map[i][b]]++;
		}		
	}
	
	public static void checkVertical(int a, int b) {
		int[] graphY = new int[9];
		for(int i = 0; i < 9; i++)  {
			graphY[map[a][i]]++;
		}
	}
	
}
