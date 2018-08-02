import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[][] copymap;
	static int m;
	static int n;
	static int value;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();

		map = new int[m][n];
		copymap = new int[m][n];
		value = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}		
		virous(0,0,0);		
		System.out.println(value);
	}

	public static void virous(int a, int b, int pic) {
		if (b == n) {
			a++;
			b = 0;
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
			clear();            
			return;
		}  
        
		if (a >= m && b >= 0 ) {
			return;            
		}	               

		if (pic < 3) {
			if (map[a][b] == 0) {
				map[a][b] = 1;                
                virous(a, b + 1, pic+1);
                map[a][b] = 0;
			}			  
		}        	        
        virous(a,b+1,pic);		
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
			fire(a, b+1);
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
}