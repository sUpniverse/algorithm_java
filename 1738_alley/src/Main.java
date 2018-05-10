import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int way = sc.nextInt();
		int way_num = sc.nextInt();
		
		int[][] value = new int[way+1][way+1];
		int[][] check = new int[way+1][way+1];
		
		for(int i = 1; i <= way_num; i++) {
			
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			int way_value = sc.nextInt();
			
			value[num1][num2] = way_value;
			value[num2][num1] = way_value;
			check[num1][num2] = -1;
			check[num2][num1] = -1;
			
		}
			
		for(int k = 1; k <= way ; k++) {
			for(int row = 1; row <= way; row++) {
				for(int col = 1; col <= way; col++) {
					if(value[row][col] < value[row][k] + value[k][row])
					check[row][col] = k;
				}
			}
		}
		for(int row = 1; row <= way; row++) {
			for(int col = 1; col <= way; col++) {
				System.out.print(check[row][col] + ",");
			}
			System.out.println();
		}
		
		print_path(1,way,check);
		
		
	}
	public static void print_path(int s,int t,int[][] check) {
		if(check[s][t] == -1) {
			return ;
		}
		print_path(s,check[s][t],check);
		System.out.println();
		print_path(check[s][t],t,check);
	}
}
