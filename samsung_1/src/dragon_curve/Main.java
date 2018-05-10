package dragon_curve;


import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;


public class Main {

	private static int[][] map;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		map = new int[101][101];
		
		
		while(num > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
	
			Stack<Integer> st = new Stack<>();
			st.add(sc.nextInt());		
			int gen = sc.nextInt();			
			for(int i = 1; i <= gen; i++ ) {
				int co = st.size();
				while(co > 0) {		
					int cnt = co;
					int a = st.get(--cnt);
					if(a == 3)
						a = 0;
					else
						a++;
					st.add(a);
					co--;
					
				}	
			}	
			Iterator<Integer> iter;
			iter = st.iterator();
			paint(iter,x,y);
			num--;
		}
		sc.close();
		
		int cnt = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0 ; j < 100; j++) {
					if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1] == 1 && map[i+1][j+1] == 1) 
						cnt++;				
			}
		}
		
		System.out.println(cnt);
	}
	

	public static void paint(Iterator<Integer> iter,int x, int y) {
		int a = x;
		int b = y;
		
		while(iter.hasNext()) {
			switch(iter.next()) {
			case 0:
				map[a][b] = 1;
				a += 1;
				map[a][b] = 1;
				break;
			case 1:
				map[a][b] = 1;
				b -= 1;
				map[a][b] = 1;
				break;
			case 2:
				map[a][b] = 1;
				a -= 1;
				map[a][b] = 1;
				break;
			case 3:
				map[a][b] = 1;
				b += 1;
				map[a][b] = 1;
				break;
			}		
		}					
	}
	
}





