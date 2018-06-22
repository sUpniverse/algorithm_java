
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[][] copymap;
	static boolean end;
	static int m;
	static int n;
	static int value;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();

		map = new int[m][n];
		copymap = new int[m][n];
		end = false;
		value = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		virous(0,0,0);
		
		System.out.println(value);

	}

//	public static void virous(int a, int b, int pic) {
//		if (b == n) {
//			a++;
//			b = 0;
//		}	
//		
//		if (a < 0 || a >= m || b < 0 || b > n) {
//			end = true;
//			return;
//		}	
//
//		if (pic < 3) {
//			if (map[a][b] == 0) {
//				map[a][b] = 1;
//				pic++;
//			}			
//			System.out.println(a+","+ b);
//			virous(a, b + 1, pic);
//			map[a][b] = 0;
//			pic--;		
//		}		
//		
//		if (pic == 3) {
//			clear();
//			for (int i = 0; i < m; i++) {
//				for (int j = 0; j < n; j++) {
//					if (copymap[i][j] == 2) {
//						fire(i, j);
//					}
//				}
//			}			
//			value = Math.max(counting(), value);
//			System.out.println(a+","+ b);
//			System.out.println(pic);
//			print(copymap);
//			clear();			
//			return;
//		}
//		
//	}
	
	public static void virous(int a, int b, int pic) {
		if(pic < 2) {
			if(pic == 1) {
				int z = 0;
				if(z == a)
					return ;
				for(int i = 0; i < n; i++) {
					virous
				}
			}
			
		}
		
		if (pic == 3) {
			clear();
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (copymap[i][j] == 2) {
						fire(i, j);
					}
				}
			}			
			value = Math.max(counting(), value);
			System.out.println(a+","+ b);
			System.out.println(pic);
			print(copymap);
			clear();			
			return;
		}		
	}
	
	public static void fire(int a, int b) {	
		if(a < 0 || a >= m || b < 0 || b >= n)
			return ;
		
		if (copymap[a][b] == 3) {
			return;
		}
		
		if (copymap[a][b] == 1) {
			return;
		}
		
		if (copymap[a][b] == 0 || copymap[a][b] == 2) {
			copymap[a][b] = 3;
			fire(a-1, b);
			fire(a+1, b);
			fire(a, b-1);
			fire(a, b-1);
		}
		
		
	}

	public static int counting() {
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (copymap[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void clear() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				copymap[i][j] = map[i][j];
			}
		}
	}
	
	public static void print(int[][] temp) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(temp[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
